package com.lifesense.quality.controller;

import com.github.pagehelper.PageInfo;
import com.lifesense.quality.config.security.SecurityUser;
import com.lifesense.quality.domain.Process;
import com.lifesense.quality.domain.*;
import com.lifesense.quality.facade.*;
import com.lifesense.quality.service.BurnService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 赵春定 on 2017/8/30.
 */
@RequestMapping("/repair")
@Controller
public class RepairController {

    @Autowired
    private RepairRecordServiceFacadeImpl repairRecordServiceFacade;
    @Autowired
    private ProcessServiceFacadeImpl processServiceFacade;

    @Autowired
    private BusinessServiceFacadeImpl businessServiceFacade;
    @Autowired
    private ProductServiceFacadeImpl productServiceFacade;
    @Autowired
    private SnInfoServiceFacadeImpl snInfoServiceFacade;
    @Autowired
    private ProcessRecordServiceFacadeImpl processRecordServiceFacade;
    @Autowired
    private ProductLineServiceFacadeImpl productLineServiceFacade;
    @Autowired
	private  BurnService burnService;
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    ModelAndView repairList() {
        ModelAndView view = new ModelAndView();
        List<Process> processes = processServiceFacade.findValidProcess(0);
        List<Process> repairProcesses = processServiceFacade.findValidProcess(1);
        List<ProductLine> lines = productLineServiceFacade.findAll();
        view.addObject("lines", lines);
        view.addObject("processes", processes);
        view.addObject("repairProcesses", repairProcesses);
        return view;
    }

    @RequestMapping(value = "/list_data", method = RequestMethod.POST)
    @ResponseBody
    Page listData(@RequestParam(name = "page", defaultValue = "1") int page, @RequestParam(name = "limit", defaultValue = "10") int limit, RepairRecord entity) {
        SecurityUser userDetails = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        QaUser user = userDetails.getUser();
        Integer repair = entity.getRepair();
        if (repair == null) {
            entity.setRepair(-1);
        }
        Integer processSign = user.getProcessSign();
        if (processSign != 1) {
            // entity.setRepairProcessCode(user.getProcessCode());//维修工号
            entity.setProductLine(user.getLineCode());
        }
        PageInfo<RepairRecord> pageData = repairRecordServiceFacade.getPageData(entity, page, limit);
        return new Page("200", "查询成功", pageData.getTotal(), pageData.getList());
    }


    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    ModelAndView edit(Long id) {
        ModelAndView view = new ModelAndView();
        RepairRecord repairEntity = repairRecordServiceFacade.getRepairRecordById(id);
        Product product = productServiceFacade.findProductById(repairEntity.getProductId());
        repairEntity.setCpsn(product.getCpsn());
        repairEntity.setBlsn(product.getBlsn());
        List<Process> processes = processServiceFacade.findValidProcess(0);
        view.addObject("processes", processes);
        view.addObject("repair", repairEntity);
        return view;
    }

    @RequestMapping(value = "/next", method = RequestMethod.GET)
    ModelAndView next(Long productId) {
        ModelAndView view = new ModelAndView();
        Product product = productServiceFacade.findProductById(productId);
        ProcessRecord unHandleProcessRecord = processRecordServiceFacade.findUnHandleProcessRecord(productId);
        Process process = processServiceFacade.findProcessByCode(unHandleProcessRecord.getProcessCode());
        String productLineCode = unHandleProcessRecord.getProductLine();
        ProductLine productLine = productLineServiceFacade.findProductLineByCode(productLineCode);
        view.addObject("product", product);
        view.addObject("process", process);
        view.addObject("productLine", productLine);
        view.addObject("processRecord", unHandleProcessRecord);
        return view;
    }

    @RequestMapping(value = "/nextSave", method = RequestMethod.POST)
    @ResponseBody
    ResponseMessage nextSave(Long productId, String sn, String json) {
        ResponseMessage message = new ResponseMessage("-1", "找不到处理工序");
        Product product = productServiceFacade.findProductById(productId);
        ProcessRecord unHandleProcessRecord = processRecordServiceFacade.findUnHandleProcessRecord(productId);
        String processCode = unHandleProcessRecord.getProcessCode();
        String productLine = unHandleProcessRecord.getProductLine();
        String cpsn = product.getCpsn();
        String blsn = product.getBlsn();
        String sheetPo = product.getSheetPo();
        SecurityUser userDetails = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        QaUser user = userDetails.getUser();
        Long userId = user.getId();
        if ("T04".equalsIgnoreCase(processCode)) {
            message = businessServiceFacade.processT04(sheetPo, productLine, processCode, blsn, userId, 0, "OK");
        } else if ("T05".equalsIgnoreCase(processCode)) {
            message = businessServiceFacade.processT05(sheetPo, productLine, processCode, blsn, sn, userId);
        } else if ("T06".equalsIgnoreCase(processCode) || "T07".equalsIgnoreCase(processCode) || "T08".equalsIgnoreCase(processCode) || "T09".equalsIgnoreCase(processCode)|| "T10".equalsIgnoreCase(processCode)) {
            message = businessServiceFacade.processAuto(productLine, processCode, cpsn, 0, userId, "OK", json);
        }
        return message;
    }


    /**
     * 保存用户，返还0成功，1不成功
     *
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    ResponseMessage save(RepairRecord entity, String nextProcessCode, String blsn, String cpsn, String bbsn, String cgqsn) {
    	RepairRecord updateEntity = repairRecordServiceFacade.getRepairRecordById(entity.getId());
        if (updateEntity == null) {
            return new ResponseMessage("-1", "无此维修记录");
        }
        if (updateEntity.getRepair() != -1) {
            return new ResponseMessage("-1", "此产品已维修，不能再维修");
        }
        SnInfo blsnInfo = null;
        SnInfo cpsnInfo = null;
        SnInfo bbsnInfo = null;
        SnInfo cgqsnInfo = null;
        Long productId = updateEntity.getProductId();
        Product oldProduct = productServiceFacade.findProductById(productId);
        String remark = "";
        if (!StringUtils.isEmpty(blsn)) {
            if (!blsn.matches(BusinessServiceFacadeImpl.BLSN_REG)) {
                return new ResponseMessage("-1", "玻璃Sn[" + blsn + "]格式不正确");
            }
            Product product = productServiceFacade.findProductByBlsn(blsn);
            if (product != null && !product.getId().equals(productId)) {
                return new ResponseMessage("-1", "玻璃SN[" + blsn + "]已使用");
            } else if (product == null) {
                blsnInfo = new SnInfo();
                blsnInfo.setSn(blsn);
                blsnInfo.setCategory("玻璃");
                blsnInfo.setProductId(productId);
                String code = blsn.substring(0, 3);
                String type = blsn.substring(3, 4);
                String ymd = blsn.substring(4, 10);
                String number = blsn.substring(10, blsn.length());
                blsnInfo.setCode(code);
                blsnInfo.setYmd(ymd);
                blsnInfo.setType(type);
                blsnInfo.setSerialNumber(number);
                remark = remark + "更换玻璃SN("+oldProduct.getBlsn()+"->"+blsn+");";
            }
        }
        if (!StringUtils.isEmpty(cpsn)) {
            if (!cpsn.matches(BusinessServiceFacadeImpl.CPSN_REG)) {
                return new ResponseMessage("-1", "产品Sn[" + cpsn + "]格式不正确");
            }
            Product product = productServiceFacade.findProductByCpsn(cpsn);
            if (product != null && !product.getId().equals(updateEntity.getProductId())) {
                return new ResponseMessage("-1", "产品SN[" + cpsn + "]已使用");
            } else if (product == null) {
                cpsnInfo = new SnInfo();
                cpsnInfo.setSn(cpsn);
                cpsnInfo.setCategory("产品SN");
                cpsnInfo.setProductId(productId);
                String code = cpsn.substring(0, 2);
                String type = cpsn.substring(2, 12);
                String ymd = cpsn.substring(12, 13);
                cpsnInfo.setCode(code);
                cpsnInfo.setYmd(ymd);
                cpsnInfo.setType(type);
                remark = remark + "更换产品SN("+oldProduct.getCpsn()+"->"+cpsn+");";
            }
        }

        if (!StringUtils.isEmpty(bbsn)) {
            if (!bbsn.matches(BusinessServiceFacadeImpl.BBSN_REG)) {
                return new ResponseMessage("-1", "录入失败,邦板SN[" + bbsn + "]格式不正确");
            }
            Burn burn = burnService.queryBySN(bbsn);
            if(burn==null) {
            	 return new ResponseMessage("-1", "邦板SN[" + bbsn + "]未通过烧码测试");
            }
            Product product = productServiceFacade.findProductByBbsn(bbsn);
            if (product != null && !product.getId().equals(updateEntity.getProductId())) {
                return new ResponseMessage("-1", "邦板SN[" + bbsn + "]已使用");
            } else if (product == null) {
                bbsnInfo = new SnInfo();
                bbsnInfo.setSn(bbsn);
                bbsnInfo.setCategory("邦板");
                bbsnInfo.setProductId(productId);
                String code = bbsn.substring(0, 3);
                String type = bbsn.substring(3, 4);
                String ymd = bbsn.substring(4, 10);
                String number = bbsn.substring(10, bbsn.length());
                bbsnInfo.setCode(code);
                bbsnInfo.setYmd(ymd);
                bbsnInfo.setType(type);
                bbsnInfo.setSerialNumber(number);
                remark = remark + "更换邦板SN("+oldProduct.getBlsn()+"->"+blsn+");";
            }
        }
        if (cgqsn != null) {
            if (!cgqsn.matches(BusinessServiceFacadeImpl.CGQSN_REG)) {
                return new ResponseMessage("-1", "录入失败,传感器SN[" + cgqsn + "]格式不正确");
            }
            cgqsnInfo = new SnInfo();
            cgqsnInfo.setSn(cgqsn);
            cgqsnInfo.setCategory("传感器");
            cgqsnInfo.setProductId(productId);
            remark = remark + "更换传感器SN("+oldProduct.getCgqsn()+"->"+cgqsn+");";
        }
        entity.setId(updateEntity.getId());
        entity.setModifyTime(new Date());
        SecurityUser userDetails = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        QaUser user = userDetails.getUser();
        entity.setUserId(user.getId());//维修工号
        entity.setRepair(0);
        entity.setRemark(remark);
        ResponseMessage message = businessServiceFacade.repairProcess(entity, updateEntity.getProcessRecordId());
        if ("200".equalsIgnoreCase(message.getCode())) {
            Product productNew = new Product();
            productNew.setId(productId);
            if (blsnInfo != null) {
            	//删除旧snInfo
				snInfoServiceFacade.del("玻璃", productId);
                productNew.setBlsn(blsn);
                snInfoServiceFacade.saveOrUpdate(blsnInfo);
            }
            if (cpsnInfo != null) {
            	//删除旧snInfo
				snInfoServiceFacade.del("产品SN", productId);
                //productNew.setCpsn(cpsn);
                snInfoServiceFacade.saveOrUpdate(cpsnInfo);
            }
            if (bbsnInfo != null) {
            	//删除旧snInfo
				snInfoServiceFacade.del("邦板", productId);
                productNew.setBbsn(bbsn);
                snInfoServiceFacade.saveOrUpdate(bbsnInfo);
               try {
            	   //删除旧的邦板烧录信息PO和产品ID关联
                	  Burn oldBurn =new Burn();
                      oldBurn.setProductId(productId);
                      PageInfo<Burn> query = burnService.query(oldBurn,null,null, 1, 1);
                      String oldBbsn = query.getList().get(0).getSn();
                      Burn newBurn =new Burn();
                      newBurn.setSn(oldBbsn);
                      burnService.update(newBurn); 
				} catch (Exception e) {
					// TODO: handle exception
				}
                //补全邦板烧录信息
                Burn burn =new Burn();
                burn.setPo(oldProduct.getSheetPo());
                burn.setProductId(productId);
                burn.setSn(bbsn);
                burnService.update(burn);
            }
            if (cgqsnInfo != null) {
            	//删除旧snInfo
				snInfoServiceFacade.del("传感器", productId);
                productNew.setCgqsn(cgqsn);
                snInfoServiceFacade.saveOrUpdate(cgqsnInfo);
            }
            if (!StringUtils.isEmpty(blsn) || !StringUtils.isEmpty(cpsn) || !StringUtils.isEmpty(bbsn) || !StringUtils.isEmpty(cgqsn)) {
            	productServiceFacade.saveOrUpdate(productNew);
            }
        }
        return message;
    }


    /**
     * 保存用户，返还0成功，1不成功
     *
     * @return
     */
    @RequestMapping(value = "/batchSave", method = RequestMethod.POST)
    @ResponseBody
    ResponseMessage batchSave(@RequestParam("ids[]") String[] ids, String badType, String badReson) {
        SecurityUser userDetails = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        QaUser user = userDetails.getUser();
        if (ids != null && userDetails != null) {
            for (String id : ids) {
                RepairRecord updateEntity = repairRecordServiceFacade.getRepairRecordById(Long.valueOf(id));
                if (updateEntity.getRepair() == -1) {
                    RepairRecord entity = new RepairRecord();
                    entity.setId(updateEntity.getId());
                    entity.setModifyTime(new Date());
                    entity.setUserId(user.getId());//维修工号
                    entity.setRepair(0);
                    entity.setBadType(badType);
                    entity.setBadReson(badReson);
                    businessServiceFacade.repairProcess(entity, updateEntity.getProcessRecordId());
                }
            }
            return new ResponseMessage("200", "维修成功");
        } else {
            return new ResponseMessage("-1", "保存失败");
        }
    }




    @RequestMapping("/info")
    @ResponseBody
    ResponseMessage queryRepari(String sn) {
        SecurityUser userDetails = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        QaUser user = userDetails.getUser();
        if (user.getProcessSign() != 2) {
            return new ResponseMessage("-1", "不是维修人员，请更换用户");
        }
        String lineCode = user.getLineCode();
        Product product = productServiceFacade.findProductByCpsn(sn);
        if (product == null) {
            product = productServiceFacade.findProductByBlsn(sn);
        }
        if (product == null) {
            return new ResponseMessage("-1", "SN不正确，没有产品绑定此SN");
        }
        Long productId = product.getId();
        RepairRecord repairRecord = repairRecordServiceFacade.findRepairRecordByProductId(productId, -1);
        if (repairRecord == null) {
            return new ResponseMessage("-1", "此产品不需要维修");
        }
        ProcessRecord processRecord = processRecordServiceFacade.findProcessRecordById(repairRecord.getProcessRecordId());
        if (processRecord== null) {
            return new ResponseMessage("-1", "此产品不需要维修");
        }
        if (!processRecord.getProductLine().equalsIgnoreCase(lineCode)) {
            return new ResponseMessage("-1", "此产品不属于本产线");
        }
      
        //查询工站名称
        Process process = processServiceFacade.findProcessByCode(processRecord.getProcessCode());
        String processName = process.getName();
        ResponseMessage message = new ResponseMessage("200", "开始维修产品");
        Map<String, Object> map = new HashMap<>();
        map.put("product", product);
        map.put("processRecord", processRecord);
        map.put("repairRecord", repairRecord);
        map.put("processName", processName);
        message.setData(map);
        return message;
    }

}
