package com.lifesense.quality.facade;

import com.lifesense.quality.controller.ResponseMessage;
import com.lifesense.quality.dao.IProductDao;
import com.lifesense.quality.domain.*;
import com.lifesense.quality.domain.Process;
import com.lifesense.quality.service.BurnService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @Auther zcd
 * @Date
 */
@Service
public class BusinessServiceFacadeImpl {

	public final static String BLSN_REG = "^312[A-Z]\\d{2}(0[1-9]|1[0-2])((0[1-9])|((1|2)[0-9])|30|31)\\d{7}$";
	public final static String BBSN_REG = "^202[A-Z]\\d{2}(0[1-9]|1[0-2])((0[1-9])|((1|2)[0-9])|30|31)\\d{7}$";
	public final static String CGQSN_REG = "^411[A-Z]\\d{2}(0[1-9]|1[0-2])((0[1-9])|((1|2)[0-9])|30|31)\\d{2}$";
	public final static String CPSN_REG = "^21\\w{8}[A-Z]{2}[0-9]([1-9]|A|B|C)\\d{6}$";

	@Autowired
	private ProcessRecordServiceFacadeImpl processRecordServiceFacade;
	@Autowired
	private ProductServiceFacadeImpl productServiceFacade;
	@Autowired
	private ProcessServiceFacadeImpl processServiceFacade;
	@Autowired
	private ProcessFlowServiceFacadeImpl processFlowServiceFacade;
	@Autowired
	private SnInfoServiceFacadeImpl snInfoServiceFacade;
	@Autowired
	private WorkSheetServiceFacadeImpl workSheetServiceFacade;
	@Autowired
	private RepairRecordServiceFacadeImpl repairRecordServiceFacade;
	@Autowired
	private BomServiceFacadeImpl bomServiceFacade;
	@Autowired
	private SysLogServiceFacadeImpl sysLogServiceFacade;
	@Autowired
	private  BurnService burnService;
	@Autowired
	private IProductDao productDao;

	/**
	 * 玻璃录入站点 1、判断玻璃sn是否已经存在，存在返回录入失败，sn已经存在 2、根据工单号，查出工单的产品型号，创建产品，创建失败返回创建产品失败
	 * 3、在站点过程记录表增加当前站点的记录，设置为未处理， 4、将工单号，线别，站别，产品id,状态，操作人 进行站别处理（流程）
	 *
	 * @param sheetPo
	 *            工单NO
	 * @param productLineCode
	 *            线别
	 * @param processCode
	 *            站点code
	 * @param blsn
	 *            玻璃SN
	 * @param userId
	 *            操作用户
	 */
	public ResponseMessage processT01(String sheetPo, String productLineCode, String processCode, String blsn,
			Long userId) {
		if (!blsn.matches(BLSN_REG)) {
			return new ResponseMessage("-1", "录入失败,SN[" + blsn + "]格式不正确");
		}
		WorkSheet sheet = workSheetServiceFacade.findWorkSheetBySheetPo(sheetPo);
		if (sheet == null) {
			return new ResponseMessage("-1", "未找到工单信息");
		}
		int countProduct = productServiceFacade.countBySheetPo(sheetPo);
		if (countProduct >= sheet.getOutputNum()) {
			return new ResponseMessage("-1", "已超出工单数量[" + sheet.getOutputNum() + "]");
		}
		String productTypeCode = sheet.getProductTypeCode();
		Product product = productServiceFacade.findProductByBlsn(blsn);
		if (product != null) {
			return new ResponseMessage("-1", "录入失败,SN[" + blsn + "]已存在");
		}
		product = new Product();
		product.setBlsn(blsn);
		product.setSheetPo(sheetPo);
		product.setProductNo(sheet.getProductNo());
		product.setProductTypeCode(productTypeCode);
		product.setValid(0);
		product.setCreateTime(new Date());
		productServiceFacade.saveOrUpdate(product);
		Long productId = product.getId();
		if (productId != null) {
			// 插入当期记录
			ProcessRecord record = new ProcessRecord();
			record.setProductLine(productLineCode);
			record.setProcessCode(processCode);
			record.setProductId(productId);
			record.setUserId(userId);
			record.setStatus(1);// 其他，未处理的记录
			record.setCreateTime(new Date());
			processRecordServiceFacade.saveOrUpdate(record);
			ResponseMessage message = process(product, productLineCode, processCode, productId, 0, userId, null, "");
			if (!"200".equalsIgnoreCase(message.getCode())) {
				processRecordServiceFacade.deleteById(record.getId());
				productServiceFacade.deleteById(productId);
				return message;
			}
			SnInfo snInfo = new SnInfo();
			snInfo.setSn(blsn);
			snInfo.setCategory("玻璃");
			snInfo.setProductId(productId);
			String code = blsn.substring(0, 3);
			String type = blsn.substring(3, 4);
			String ymd = blsn.substring(4, 10);
			String number = blsn.substring(10, blsn.length());
			snInfo.setCode(code);
			snInfo.setYmd(ymd);
			snInfo.setType(type);
			snInfo.setSerialNumber(number);
			snInfoServiceFacade.saveOrUpdate(snInfo);
			/* 线别ID,站点Code，产品类型，sn,用户ID */
			return message;
		} else {
			return new ResponseMessage("-1", "录入失败，SN[" + blsn + "]新增产品失败");
		}
	}

	/**
	 * 绑定邦板 检查bbsn格式是否正确 1、检查板板sn是否已经存在，存在，返回录入失败，sn已存在
	 * 2、根据玻璃sn查询产品，是否已经录入，不存在返回录入失败，玻璃sn未录入 3、检查产品的邦板sn是否已经录入，已经录入，返回录入失败，玻璃邦板已经绑定
	 *
	 * @param sheetNo
	 *            工单NO
	 * @param productLineCode
	 *            线别Code
	 * @param processCode
	 *            站别Code
	 * @param blsn
	 *            玻璃sn
	 * @param bbsn
	 *            邦板sn
	 * @param userId
	 *            用户id
	 * @return
	 */
	public ResponseMessage processT02(String sheetNo, String productLineCode, String processCode, String blsn,
			String bbsn, Long userId) {
		if (!bbsn.matches(BBSN_REG)) {
			return new ResponseMessage("-1", "录入失败,SN[" + bbsn + "]格式不正确");
		}
		//检查邦板是否通过烧录测试
		Burn burn = burnService.queryBySN(bbsn);
		if(burn==null) {
			return new ResponseMessage("-1", "录入失败,邦板SN[" + bbsn + "]未通过烧录测试");
		}
		Product product = productServiceFacade.findProductByBbsn(bbsn);
		if (product != null) {
			return new ResponseMessage("-1", "录入失败,邦板SN[" + bbsn + "]已存在");
		}
		product = productServiceFacade.findProductByBlsn(blsn);
		if (product == null) {
			return new ResponseMessage("-1", "录入失败,玻璃SN[" + blsn + "]未录入");
		}
		if (!sheetNo.equals(product.getSheetPo())) {
			return new ResponseMessage("-1", "录入失败,SN[" + blsn + "]不属于工单[" + sheetNo + "]");
		}
		String oldBbsn = product.getBbsn();
		if (StringUtils.isEmpty(oldBbsn)) {
			Long productId = product.getId();
			Product newProduct = new Product();
			newProduct.setId(productId);
			newProduct.setBbsn(bbsn);
			SnInfo snInfo = new SnInfo();
			snInfo.setSn(bbsn);
			snInfo.setCategory("邦板");
			snInfo.setProductId(productId);
			String code = bbsn.substring(0, 3);
			String type = bbsn.substring(3, 4);
			String ymd = bbsn.substring(4, 10);
			String number = bbsn.substring(10, blsn.length());
			snInfo.setCode(code);
			snInfo.setYmd(ymd);
			snInfo.setType(type);
			snInfo.setSerialNumber(number);
			product.setBbsn(bbsn);
			ResponseMessage responseMessage = process(product, productLineCode, processCode, productId, 0, userId, null,
					"");
			if ("200".equalsIgnoreCase(responseMessage.getCode())) {
				snInfoServiceFacade.saveOrUpdate(snInfo);
				productServiceFacade.saveOrUpdate(newProduct);
				//保存邦板烧录工单信息
				Burn newBurn=new Burn();
				newBurn.setSn(bbsn);
				newBurn.setPo(sheetNo);
				newBurn.setProductId(productId);
				burnService.update(newBurn);
			}
			return responseMessage;
		} else {
			return new ResponseMessage("-1", "录入失败,玻璃SN[" + blsn + "]已绑定邦板");
		}
	}

	/**
	 * 刷入传感器 1、根据玻璃sn查询产品，是否已经录入，不存在返回录入失败，玻璃sn未录入 2、检查产品是否已经绑定传感器，是返回录入失败，SN已绑定
	 * 业务流程处理
	 *
	 * @param sheetPo
	 *            工单No
	 * @param productLineCode
	 *            线别code
	 * @param processCode
	 *            站别code
	 * @param blsn
	 *            玻璃sn
	 * @param cgqsn
	 *            传感器sn
	 * @param userId
	 *            用户id
	 */
	public ResponseMessage processT03(String sheetPo, String productLineCode, String processCode, String blsn,
			String cgqsn, Long userId) {
		if (!cgqsn.matches(CGQSN_REG)) {
			return new ResponseMessage("-1", "录入失败,SN[" + cgqsn + "]格式不正确");
		}
		Product product = productServiceFacade.findProductByBlsn(blsn);
		if (product == null) {
			return new ResponseMessage("-1", "录入失败,玻璃SN[" + blsn + "]未录入");
		}
		if (!sheetPo.equals(product.getSheetPo())) {
			return new ResponseMessage("-1", "录入失败,玻璃SN[" + blsn + "]不属于工单[" + sheetPo + "]");
		}
		String oldCgqSn = product.getCgqsn();
		if (StringUtils.isEmpty(oldCgqSn)) {
			Long productId = product.getId();
			Product newProduct = new Product();
			newProduct.setId(productId);
			newProduct.setCgqsn(cgqsn);
			SnInfo snInfo = new SnInfo();
			snInfo.setSn(cgqsn);
			snInfo.setCategory("传感器");
			snInfo.setProductId(productId);
			product.setCgqsn(cgqsn);
			ResponseMessage responseMessage = process(product, productLineCode, processCode, productId, 0, userId, null,
					"");
			if ("200".equalsIgnoreCase(responseMessage.getCode())) {
				snInfoServiceFacade.saveOrUpdate(snInfo);
				productServiceFacade.saveOrUpdate(newProduct);
			}
			return responseMessage;
		} else {
			return new ResponseMessage("-1", "录入失败,玻璃SN[" + blsn + "]已绑定传感器");
		}
	}

	/**
	 * 半成品测试 1、检查玻璃sn是否已经录入，否则提示玻璃sn未录入 2、检查是否已经绑定邦板sn，否提示未绑定邦板sn
	 * 3、检查是否已经绑定传感器sn,否提示未绑定传感器sn 4、业务流程处理
	 *
	 * @param sheetPo
	 *            工单NO
	 * @param productLineCode
	 *            线别Code
	 * @param processCode
	 *            站别code
	 * @param blsn
	 *            玻璃sn
	 * @param status
	 *            状态 0，1
	 * @param userId
	 *            用户id
	 * @param badcode
	 *            错误代码
	 * @return
	 */
	public ResponseMessage processT04(String sheetPo, String productLineCode, String processCode, String blsn,
			Long userId, Integer status, String badcode) {
		Product product = productServiceFacade.findProductByBlsn(blsn);
		if (product == null) {
			return new ResponseMessage("-1", "录入失败,玻璃SN[" + blsn + "]未录入");
		}
		if (!sheetPo.equals(product.getSheetPo())) {
			return new ResponseMessage("-1", "录入失败,玻璃SN[" + blsn + "]不属于工单[" + sheetPo + "]");
		}
		String bbsn = product.getBbsn();
		if (StringUtils.isEmpty(bbsn)) {
			return new ResponseMessage("-1", "录入失败,未绑定邦板sn");
		}
		String cgqsn = product.getCgqsn();
		if (StringUtils.isEmpty(cgqsn)) {
			return new ResponseMessage("-1", "录入失败,未绑定传感器sn");
		}
		Long productid = product.getId();
		return process(product, productLineCode, processCode, productid, status, userId, badcode, "");
	}

	/**
	 * 合壳 1、校验玻璃sn，产品sn格式是否正确
	 *
	 * @param sheetPo
	 *            工单NO
	 * @param productLineCode
	 *            线别Code
	 * @param processCode
	 *            站别code
	 * @param blsn
	 *            玻璃sn
	 * @param cpsn
	 *            产品SN
	 * @param userId
	 *            用户id
	 * @return
	 */
	public ResponseMessage processT05(String sheetPo, String productLineCode, String processCode, String blsn,
			String cpsn, Long userId) {
		if (!cpsn.matches(CPSN_REG)) {
			return new ResponseMessage("-1", "录入失败,SN[" + cpsn + "]格式不正确");
		}
		Product product = productServiceFacade.findProductByCpsn(cpsn);
		if (product != null) {
			return new ResponseMessage("-1", "录入失败,产品SN[" + cpsn + "]已使用");
		}
		product = productServiceFacade.findProductByBlsn(blsn);
		if (product == null) {
			return new ResponseMessage("-1", "录入失败,玻璃SN[" + blsn + "]未录入");
		}
		String productCpsn = product.getCpsn();
		if (!StringUtils.isEmpty(productCpsn)) {
			return new ResponseMessage("-1", "录入失败,玻璃SN[" + blsn + "]已绑定产品SN");
		}
		if (!sheetPo.equals(product.getSheetPo())) {
			return new ResponseMessage("-1", "录入失败,玻璃SN[" + blsn + "]不属于工单[" + sheetPo + "]");
		}

		Long productId = product.getId();
		Product newProduct = new Product();
		newProduct.setId(productId);
		newProduct.setCpsn(cpsn);
		SnInfo snInfo = new SnInfo();
		snInfo.setSn(cpsn);
		snInfo.setCategory("产品SN");
		snInfo.setProductId(productId);
		String code = cpsn.substring(0, 2);
		String type = cpsn.substring(2, 12);
		String ymd = cpsn.substring(12, 13);
		snInfo.setCode(code);
		snInfo.setYmd(ymd);
		snInfo.setType(type);
		product.setCpsn(cpsn);

		ResponseMessage responseMessage = process(product, productLineCode, processCode, productId, 0, userId, null,
				"");
		if ("200".equalsIgnoreCase(responseMessage.getCode())) {
			snInfoServiceFacade.saveOrUpdate(snInfo);
			productServiceFacade.saveOrUpdate(newProduct);
		}
		return responseMessage;
	}

	/**
	 * 校磅,验磅,心率测试,阻抗 &偏载，测压力开机 自动接口
	 *
	 * @param productLineCode
	 *            线别code
	 * @param processCode
	 *            站别codee
	 * @param cpsn
	 *            产品sn
	 * @param status
	 *            状态0，1
	 * @param badcode
	 *            错误码
	 * @return
	 */
	public ResponseMessage processAuto(String productLineCode, String processCode, String cpsn, Integer status,
			Long userId, String badcode, String json) {
		Product product = productServiceFacade.findProductByCpsn(cpsn);
		if (product == null) {
			return new ResponseMessage("-1", "产品SN[" + cpsn + "]不存在");
		}
		Long productId = product.getId();
		return process(product, productLineCode, processCode, productId, status, userId, badcode, json);
	}

	/**
	 * 外观检验
	 *
	 * @param sheetPo
	 *            工单No
	 * @param productLineCode
	 *            线别code
	 * @param processCode
	 *            站别codee
	 * @param cpsn
	 *            产品sn
	 * @param userId
	 *            用户id
	 * @param status
	 *            状态0，1
	 * @param badcode
	 *            错误码
	 * @return
	 */
	public ResponseMessage processT12(String sheetPo, String productLineCode, String processCode, String cpsn,
			Long userId, Integer status, String badcode) {
		Product product = productServiceFacade.findProductByCpsn(cpsn);
		if (product == null) {
			return new ResponseMessage("-1", "产品SN[" + cpsn + "]不存在");
		}
		if (!sheetPo.equals(product.getSheetPo())) {
			return new ResponseMessage("-1", "录入失败,产品SN[" + cpsn + "]不属于工单[" + sheetPo + "]");
		}
		Long productId = product.getId();
		return process(product, productLineCode, processCode, productId, status, userId, badcode, "");
	}

	/**
	 * 装塑料带，刷产品sn，说明书sn,彩盒sn
	 *
	 * @param sheetPo
	 * @param productLineCode
	 * @param processCode
	 * @param cpsn
	 * @param bxk
	 * @return
	 */
	public ResponseMessage processT13(String sheetPo, String productLineCode, String processCode, String cpsn,
			String sms, String ch, Long userId) {
		Product product = productServiceFacade.findProductByCpsn(cpsn);
		if (product == null) {
			return new ResponseMessage("-1", "产品SN[" + cpsn + "]不存在");
		}
		if (!sheetPo.equals(product.getSheetPo())) {
			return new ResponseMessage("-1", "录入失败,产品SN[" + cpsn + "]不属于工单[" + sheetPo + "]");
		}
		if (!StringUtils.isEmpty(product.getSmssn()) || !StringUtils.isEmpty(product.getChsn())) {
			return new ResponseMessage("-1", "录入失败,产品SN[" + cpsn + "]已经刷入说明书和彩盒");
		}
		Long productId = product.getId();
		String productTypeCode = product.getProductTypeCode();
		Bom bomsms = bomServiceFacade.findBomByExample(productTypeCode, "说明书", sms);
		int status = 0;
		String badcode = null;
		if (bomsms == null) {
			return new ResponseMessage("-1", "录入失败,刷入的说明书[" + sms + "]与产品类型的不符合");
		}
		Bom bomch = bomServiceFacade.findBomByExample(productTypeCode, "彩盒", ch);
		if (bomch == null) {
			return new ResponseMessage("-1", "录入失败,刷入的彩盒[" + ch + "]与产品类型的不符合");
		}
		Product newProduct = new Product();
		newProduct.setId(productId);
		newProduct.setSmssn(sms);
		newProduct.setChsn(ch);;
		SnInfo smsInfo = new SnInfo();
		smsInfo.setSn(sms);
		smsInfo.setCategory("说明书");
		smsInfo.setProductId(productId);
		SnInfo chInfo = new SnInfo();
		chInfo.setSn(ch);
		chInfo.setCategory("彩盒");
		chInfo.setProductId(productId);
		product.setSmssn(sms);
		product.setChsn(ch);;
		ResponseMessage responseMessage = process(product, productLineCode, processCode, productId, status, userId,
				badcode, "");
		if ("200".equalsIgnoreCase(responseMessage.getCode())) {
			snInfoServiceFacade.saveOrUpdate(smsInfo);
			snInfoServiceFacade.saveOrUpdate(chInfo);
			newProduct.setValid(1);// 完成全部工序
			productServiceFacade.saveOrUpdate(newProduct);
		}
		return responseMessage;
	}

	/**
	 * 装彩盒
	 *
	 * @param sheetPo
	 * @param productLineCode
	 * @param processCode
	 * @param cpsn
	 * @param wlbm
	 * @return
	 */
	/*
	public ResponseMessage processT12(String sheetPo, String productLineCode, String processCode, String cpsn,
			String wlbm, Long userId) {
		Product product = productServiceFacade.findProductByCpsn(cpsn);
		if (product == null) {
			return new ResponseMessage("-1", "SN[" + cpsn + "]不存在");
		}
		if (!sheetPo.equals(product.getSheetPo())) {
			return new ResponseMessage("-1", "录入失败,SN[" + cpsn + "]不属于工单[" + sheetPo + "]");
		}
		if (StringUtils.isEmpty(product.getBxksn()) || StringUtils.isEmpty(product.getSmssn())) {
			return new ResponseMessage("-1", "录入失败,SN[" + product.getCpsn() + "]未刷入保修卡和说明书");
		}
		Long productId = product.getId();
		String productTypeCode = product.getProductTypeCode();
		Bom bomch = bomServiceFacade.findBomByExample(productTypeCode, "彩盒", wlbm);
		int status = 0;
		String badcode = null;
		// 彩盒跟产品类型不匹配
		if (bomch == null) {
			return new ResponseMessage("-1", "录入失败,刷入的彩盒[" + wlbm + "]与产品类型的不符合");
		}
		product.setChsn(wlbm);
		Product newProduct = new Product();
		newProduct.setId(productId);
		newProduct.setChsn(wlbm);
		//newProduct.setValid(1);// 完成
		SnInfo bxkInfo = new SnInfo();
		bxkInfo.setSn(wlbm);
		bxkInfo.setCategory("彩盒");
		bxkInfo.setProductId(productId);
		ResponseMessage responseMessage = process(product, productLineCode, processCode, productId, status, userId,
				badcode, "");
		if ("200".equalsIgnoreCase(responseMessage.getCode())) {
			snInfoServiceFacade.saveOrUpdate(bxkInfo);
			newProduct.setValid(1);// 完成全部工序
			productServiceFacade.saveOrUpdate(newProduct);
		}
		return responseMessage;
	}
	*/
	/**
	 * 1、根据产品ID查询产品 2、使用站别code,产品类型查询站别流程， 3、产品id,查询当前未处理检测记录
	 * 4、将当前未处理的检查记录的站别与当前站别对比，是否属于此站别 5、属于此站别，查询当前站别的上下信息，处理当前站别，记录下一个站别未处理。
	 *
	 * @param productLineCode
	 *            线别Code
	 * @param processCode
	 *            站别Code
	 * @param productId
	 *            产品ID
	 * @param status
	 *            状态 0OK,1NG
	 * @param userId
	 *            操作用户
	 * @param badcode
	 *            错误代码，只有status<>0才需要传入
	 * @return
	 */
	private ResponseMessage process(Product product, String productLineCode, String processCode, Long productId,
			int status, Long userId, String badcode, String json) {
		// Product product = productServiceFacade.findProductById(productId);
		if (product == null) {
			return new ResponseMessage("-1", "录入失败，产品未录入");
		}
		ProcessFlow processFlow = processFlowServiceFacade.findByProductTypeAndProcessCode(product.getProductTypeCode(),
				processCode);
		if (processFlow == null
				|| (StringUtils.isEmpty(processFlow.getNextProcessCode()) && !"T13".equalsIgnoreCase(processCode))) {
			return new ResponseMessage("-1", "录入失败，该产品类型[" + product.getProductTypeCode() + "]未设置下一工作站，请联系管理员设置工作流程");
		}
		ProcessRecord unHandleProcessRecord = processRecordServiceFacade.findUnHandleProcessRecord(productId);
		if (unHandleProcessRecord == null) {
			return new ResponseMessage("-1", "录入失败，该玻璃SN[" + product.getBlsn() + "]未找到下一个工作流程");
		}
		String unHandleProcessRecordProcessCode = unHandleProcessRecord.getProcessCode();
		Process currenProcess = processServiceFacade.findProcessByCode(unHandleProcessRecordProcessCode);
		// 当前站点不同
		if (!processCode.equalsIgnoreCase(unHandleProcessRecord.getProcessCode())) {
			return new ResponseMessage("-1", "录入失败，当前在[" + currenProcess.getName() + "("+currenProcess.getCode()+")]工站与产品正在的工站不符合");
		}
		String msg = "";
		String op = "";
		if ("t01".equalsIgnoreCase(processCode)) {
			msg = String.format("录入成功，SN[%s]", product.getBlsn());
			op = String.format("绑定玻璃[%s],工单[%s],产线[%s]", product.getBlsn(), product.getSheetPo(), productLineCode);
		} else if ("t02".equalsIgnoreCase(processCode)) {
			msg = String.format("录入成功，SN[%s]", product.getBlsn());
			op = String.format("绑定邦板[%s],玻璃[%s],工单[%s],产线[%s]", product.getBbsn(), product.getBlsn(),
					product.getSheetPo(), productLineCode);
		} else if ("t03".equalsIgnoreCase(processCode)) {
			msg = String.format("录入成功，SN[%s]", product.getBlsn());
			op = String.format("绑定传感器[%s],玻璃[%s],工单[%s],产线[%s]", product.getCgqsn(), product.getBlsn(),
					product.getSheetPo(), productLineCode);
		} else if ("t04".equalsIgnoreCase(processCode)) {
			msg = String.format("录入成功，SN[%s],检测结果[%s]", product.getBlsn(), status == 0 ? "OK" : "NG(" + badcode + ")");
			op = String.format("半成品测试[%s],工单[%s],产线[%s],结果[%s]", product.getBlsn(), product.getSheetPo(),
					productLineCode, status == 0 ? "OK" : "NG(" + badcode + ")");
		} else if ("t05".equalsIgnoreCase(processCode)) {
			msg = String.format("录入成功，SN[%s]", product.getCpsn());
			op = String.format("绑定底盒,产品[%s],玻璃[%s],工单[%s],产线[%s]", product.getCpsn(), product.getBlsn(),
					product.getSheetPo(), productLineCode);
		} else if ("t06".equalsIgnoreCase(processCode)) {
			msg = String.format("录入成功，SN[%s],结果[%s]", product.getCpsn(), status == 0 ? "OK" : "NG(" + badcode + ")");
			op = String.format("WIFI测试,产品[%s],工单[%s],产线[%s],结果[%s]", product.getCpsn(), product.getSheetPo(),
					productLineCode, status == 0 ? "OK" : "NG(" + badcode + ")");
		} else if ("t07".equalsIgnoreCase(processCode)) {
			msg = String.format("录入成功，SN[%s],结果[%s]", product.getCpsn(), status == 0 ? "OK" : "NG(" + badcode + ")");
			op = String.format("校磅,产品[%s],工单[%s],产线[%s],结果[%s]", product.getCpsn(), product.getSheetPo(),
					productLineCode, status == 0 ? "OK" : "NG(" + badcode + ")");
		}else if ("t08".equalsIgnoreCase(processCode)) {
			msg = String.format("录入成功，SN[%s],结果[%s]", product.getCpsn(), status == 0 ? "OK" : "NG(" + badcode + ")");
			op = String.format("验磅,产品[%s],工单[%s],产线[%s],结果[%s]", product.getCpsn(), product.getSheetPo(),
					productLineCode, status == 0 ? "OK" : "NG(" + badcode + ")");
		} else if ("t09".equalsIgnoreCase(processCode)) {
			msg = String.format("录入成功，SN[%s],结果[%s]", product.getCpsn(), status == 0 ? "OK" : "NG(" + badcode + ")");
			op = String.format("心率测试,产品[%s],工单[%s],产线[%s],结果[%s]", product.getCpsn(), product.getSheetPo(),
					productLineCode, status == 0 ? "OK" : "NG(" + badcode + ")");
		}else if ("t10".equalsIgnoreCase(processCode)) {
			msg = String.format("录入成功，SN[%s],结果[%s]", product.getCpsn(), status == 0 ? "OK" : "NG(" + badcode + ")");
			op = String.format("阻抗 & 偏载测试,产品[%s],工单[%s],产线[%s],结果[%s]", product.getCpsn(), product.getSheetPo(),
					productLineCode, status == 0 ? "OK" : "NG(" + badcode + ")");
		} else if ("t11".equalsIgnoreCase(processCode)) {
			msg = String.format("录入成功，SN[%s],结果[%s]", product.getCpsn(), status == 0 ? "OK" : "NG(" + badcode + ")");
			op = String.format("测压力开机,产品[%s],工单[%s],产线[%s],结果[%s]", product.getCpsn(), product.getSheetPo(),
					productLineCode, status == 0 ? "OK" : "NG(" + badcode + ")");
		} else if ("t12".equalsIgnoreCase(processCode)) {
			msg = String.format("录入成功，SN[%s],结果[%s]", product.getCpsn(), status == 0 ? "OK" : "NG(" + badcode + ")");
			op = String.format("外观检验,产品[%s],工单[%s],产线[%s],结果[%s]", product.getCpsn(), product.getSheetPo(),
					productLineCode, status == 0 ? "OK" : "NG(" + badcode + ")");
		} else if ("t13".equalsIgnoreCase(processCode)) {
			msg = String.format("录入成功，SN[%s,%s]", product.getSmssn(), product.getChsn());
			op = String.format("绑定说明书[%s]&彩盒[%s],产品[%s],工单[%s],产线[%s],结果[%s]", product.getSmssn(), product.getChsn(),
					product.getCpsn(), product.getSheetPo(), productLineCode,
					status == 0 ? "OK" : "NG(" + badcode + ")");
		}  else {
			msg = "未知操作";
		}
		// 当期站点相同
		unHandleProcessRecord.setProductLine(productLineCode);
		unHandleProcessRecord.setModifyTime(new Date());
		unHandleProcessRecord.setStatus(status);
		unHandleProcessRecord.setDescription(op);
		unHandleProcessRecord.setCreateTime(new Date());
		unHandleProcessRecord.setContentJson(json);
		unHandleProcessRecord.setUserId(userId);
		int num = processRecordServiceFacade.saveOrUpdate(unHandleProcessRecord);
		ResponseMessage message = new ResponseMessage("200", msg);
		if (num > 0) {
			if (processFlow != null) {
				ProcessRecord record = new ProcessRecord();
				record.setProductId(productId);
				if (status == -1 && !StringUtils.isEmpty(processFlow.getRepairProcessCode())) {
					// 需要维修,并且有维修站点
					record.setProcessCode(processFlow.getRepairProcessCode());
					message.setData(processFlow.getRepairProcessCode());
				} else {
					record.setProcessCode(processFlow.getNextProcessCode());
					message.setData(processFlow.getNextProcessCode());
				}
				record.setProductLine(productLineCode);
				record.setStatus(1);
				record.setCreateTime(new Date());
				record.setModifyTime(new Date());
				record.setUserId(userId);
				/* 下一个站点 */
				if (!StringUtils.isEmpty(record.getProcessCode())) {
					processRecordServiceFacade.saveOrUpdate(record);
				}
				if (status == -1 && !StringUtils.isEmpty(processFlow.getRepairProcessCode())) {
					RepairRecord repairRecord = new RepairRecord();
					repairRecord.setProductId(productId);
					repairRecord.setProductLine(productLineCode);
					repairRecord.setProcessRecordId(unHandleProcessRecord.getId());
					repairRecord.setBadCode(badcode);
					repairRecord.setRepairProcessCode(processFlow.getRepairProcessCode());
					repairRecord.setRepair(-1);
					repairRecordServiceFacade.saveOrUpdate(repairRecord);
				}
			}
			// 降低资源
			// saveSysLog(productId, productLineCode, processCode,
			// unHandleProcessRecord.getDescription(), userId);
			return message;
		} else {
			return new ResponseMessage("-1", "录入失败，保存失败");
		}
	}

	public ResponseMessage repairProcess(RepairRecord entity, Long processRecordId) {
		ProcessRecord processRecord = processRecordServiceFacade.findProcessRecordById(processRecordId);
		Long productId = processRecord.getProductId();
		String processCode = processRecord.getProcessCode();
		String productLine = processRecord.getProductLine();
		if (processRecord == null) {
			return new ResponseMessage("-1", "维修失败，找不到源工站");
		}
		Product product = productServiceFacade.findProductById(productId);
		if (product == null) {
			return new ResponseMessage("-1", "维修失败，找不到产品");
		}
		ProcessRecord unHandleProcessRecord = processRecordServiceFacade.findUnHandleProcessRecord(productId);
		if (unHandleProcessRecord != null) {
			unHandleProcessRecord.setStatus(0);// 完成
			unHandleProcessRecord.setCreateTime(new Date());
			unHandleProcessRecord.setModifyTime(new Date());
			unHandleProcessRecord.setDescription(entity.getBadReson());
			unHandleProcessRecord.setUserId(entity.getUserId());
			// int num = processRecordServiceFacade.saveOrUpdate(unHandleProcessRecord);
			//if (!"T04".equalsIgnoreCase(processCode)) {
				//processCode = "T06";// 写死返回
			//}
			//查询源工站名称
			Process process = processServiceFacade.findProcessByCode(processCode);
			String processName = process.getName();
			boolean flag="复判OK".equals(entity.getBadReson());
			if(!flag) {
				processCode = "T04";//返回半成品测试
				//删除产品SN
				productDao.updateCPSN(productId,new Date());
				//删除snInfo
				snInfoServiceFacade.del("产品SN", productId);
			}
			ProcessRecord record = new ProcessRecord();
			record.setProductId(productId);
			record.setProcessCode(processCode);
			record.setProductLine(productLine);
			record.setStatus(1);
			record.setCreateTime(new Date());
			record.setUserId(entity.getUserId());
			/* 下一个站点 */
			processRecordServiceFacade.saveOrUpdate(unHandleProcessRecord);
			processRecordServiceFacade.saveOrUpdate(record);
			repairRecordServiceFacade.saveOrUpdate(entity);
			// 降低资源
			// saveSysLog(productId, unHandleProcessRecord.getProductLine(),
			// unHandleProcessRecord.getProcessCode(), "维修产品成功", entity.getUserId());
			ResponseMessage message = new ResponseMessage("200",
					"维修成功,返回" + (!flag ? "半成品测试" : processName));
			message.setData(processCode);
			return message;
		}
		return new ResponseMessage("-1", "维修失败");
	}

	private void saveSysLog(Long productId, String productLineCode, String processCode, String context, Long userId) {
		SysLog sysLog = new SysLog();
		sysLog.setProductId(productId);
		sysLog.setProductLineCode(productLineCode);
		sysLog.setProcessCode(processCode);
		sysLog.setContent(context);
		sysLog.setUserId(userId);
		sysLog.setCreateTime(new Date());
		sysLogServiceFacade.save(sysLog);
	}

}
