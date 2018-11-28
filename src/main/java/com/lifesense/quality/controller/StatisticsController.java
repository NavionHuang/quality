package com.lifesense.quality.controller;

import com.alibaba.druid.sql.visitor.functions.If;
import com.github.pagehelper.PageInfo;
import com.lifesense.quality.base.ExportExcel;
import com.lifesense.quality.config.security.SecurityUser;
import com.lifesense.quality.domain.*;
import com.lifesense.quality.domain.Process;
import com.lifesense.quality.facade.*;
import com.lifesense.quality.service.StatisticsService;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 赵春定 on 2017/10/20.
 */
@Controller
@RequestMapping("/statistics")
public class StatisticsController {

	@Autowired
	private StatisticsService statisticsService;
	@Autowired
	private ProcessServiceFacadeImpl processServiceFacade;
	@Autowired
	private ProductLineServiceFacadeImpl productLineServiceFacade;
	@Autowired
	private ProductTypeServiceFacadeImpl productTypeServiceFacade;
	@Autowired
	private ProductServiceFacadeImpl productServiceFacade;
	@Autowired
	private SnInfoServiceFacadeImpl snInfoServiceFacade;
	@Autowired
	private ExportExcel<Map<String, Object>> exportExcel;

	/**
	 * 根据工单号统计
	 *
	 * @return
	 */
	@RequestMapping(value = "/bySheet", method = RequestMethod.GET)
	ModelAndView statisBySheet() {
		ModelAndView model = new ModelAndView();
		return model;
	}

	@RequestMapping(value = "/bySheetData", method = RequestMethod.POST)
	@ResponseBody
	Page statisBySheet(@RequestParam(name = "page", defaultValue = "1") int page,
			@RequestParam(name = "limit", defaultValue = "10") int limit, String po, Date startDate, Date endDate) {
		PageInfo<Map<String, Object>> pageData = statisticsService.spsBySheet(page, limit, po, startDate, endDate);
		return new Page("200", "查询成功", pageData.getTotal(), pageData.getList());
	}

	/**
	 * 根据根据工单线别统计
	 *
	 * @return
	 */
	@RequestMapping(value = "/byLine", method = RequestMethod.GET)
	ModelAndView statisByLine() {
		ModelAndView model = new ModelAndView();
		List<ProductLine> productLines = productLineServiceFacade.findAll();
		model.addObject("productLines", productLines);
		return model;
	}

	@RequestMapping(value = "/byLineData", method = RequestMethod.POST)
	@ResponseBody
	Page statisByLine(@RequestParam(name = "page", defaultValue = "1") int page,
			@RequestParam(name = "limit", defaultValue = "10") int limit, String po, String productType, String line,
			Date startDate, Date endDate) {
		SecurityUser userDetails = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (userDetails.getUser() != null) {
			QaUser user = userDetails.getUser();
			if (user.getProcessSign() != 1) {
				line = user.getLineCode();
			}
		}
		PageInfo<Map<String, Object>> pageData = statisticsService.spsByLine(page, limit, po, productType, line,
				startDate, endDate);
		return new Page("200", "查询成功", pageData.getTotal(), pageData.getList());
	}

	/**
	 * 根据根据工单、站点、统计
	 *
	 * @return
	 */
	@RequestMapping(value = "/byState", method = RequestMethod.GET)
	ModelAndView statisByState(@RequestParam(name = "page", defaultValue = "1") int page,
			@RequestParam(name = "limit", defaultValue = "10") int limit, String sheetPo, String productType,
			String productLineCode, Date beginTime, Date endTime) {
		ModelAndView model = new ModelAndView();
		List<ProductLine> productLines = productLineServiceFacade.findAll();
		model.addObject("productLines", productLines);
		List<Process> processes = processServiceFacade.findAllSps();
		model.addObject("processes", processes);
		List<ProductType> productTypes = productTypeServiceFacade.findValidProductType();
		model.addObject("productTypes", productTypes);
		PageInfo<Map<String, Object>> linesData = statisticsService.spsRateByLine(page, limit, sheetPo, productType,
				productLineCode, beginTime, endTime);
		List<Map<String, Object>> data = linesData.getList();
		List<String> sheetPoes = data.parallelStream().map(d -> String.valueOf(d.get("SHEET_PO")))
				.collect(Collectors.toList());
		List<String> lines = data.parallelStream().map(d -> String.valueOf(d.get("PRODUCT_LINE_CODE")))
				.collect(Collectors.toList());
		List<Map<String, Object>> statesData = statisticsService.spsByState(sheetPoes, lines, beginTime, endTime, 0);
		data.parallelStream().forEach(d -> {
			Object sheet_po = d.get("SHEET_PO");
			Object product_line_code = d.get("PRODUCT_LINE_CODE");
			Map<String, Object> states = (Map<String, Object>) d.get("STATES");
			if (states == null) {
				states = new HashMap<>();
				d.put("STATES", states);
			}
			if (statesData != null) {
				List<Map<String, Object>> stateData = statesData.parallelStream().filter(
						m -> sheet_po.equals(m.get("SHEET_PO")) && product_line_code.equals(m.get("PRODUCT_LINE_CODE")))
						.collect(Collectors.toList());
				for (Map<String, Object> m : stateData) {
					Object processCode = m.get("PROCESS_CODE");
					states.put(String.valueOf(processCode), m);
				}
			}
		});
		model.addObject("page", new Page("200", "", linesData.getTotal(), data));
		Map<String, Object> defaultMap = new HashMap<String, Object>();
		defaultMap.put("PNUM", new Integer(0));
		defaultMap.put("PRNUM", new Integer(0));
		defaultMap.put("PRRNUM", new Integer(0));
		model.addObject("defaultState", defaultMap);
		return model;
	}

	/*
	 * @RequestMapping(value = "/byStateData", method = RequestMethod.POST)
	 * 
	 * @ResponseBody Page statisByState(@RequestParam(name = "page", defaultValue =
	 * "1") int page, @RequestParam(name = "limit", defaultValue = "10") int limit,
	 * String sheetPo, String productLineCode) { PageInfo<Map<String, Object>>
	 * pageData = statisticsService.spsByState(page, limit, sheetPo,
	 * productLineCode); return new Page("200", "查询成功", pageData.getTotal(),
	 * pageData.getList()); }
	 */

	/**
	 * 产品追溯
	 *
	 * @return
	 */
	@RequestMapping(value = "/query_by_product", method = RequestMethod.GET)
	ModelAndView queryByProduct() {
		ModelAndView model = new ModelAndView();
		return model;
	}

	@RequestMapping(value = "/query_by_product_data", method = RequestMethod.POST)
	@ResponseBody
	Page queryByProduct(@RequestParam(name = "page", defaultValue = "1") int page,
			@RequestParam(name = "limit", defaultValue = "10") int limit, String cpsn) {
		PageInfo<Map<String, Object>> pageData = statisticsService.queryByProduct(page, limit, cpsn);
		return new Page("200", "查询成功", pageData.getTotal(), pageData.getList());
	}

	/**
	 * WIP查询
	 *
	 * @return
	 */
	@RequestMapping(value = "/query_count_by_state", method = RequestMethod.GET)
	ModelAndView queryCountByState(@RequestParam(name = "page", defaultValue = "1") int page,
			@RequestParam(name = "limit", defaultValue = "10") int limit, String sheetPo, String productType,
			String productLineCode, Date beginTime, Date endTime) {
		ModelAndView model = new ModelAndView();
		List<Process> processes = processServiceFacade.findAll();
		model.addObject("processes", processes);
		List<ProductLine> productLines = productLineServiceFacade.findAll();
		List<ProductType> productTypes = productTypeServiceFacade.findValidProductType();
		model.addObject("productLines", productLines);
		model.addObject("productTypes", productTypes);
		PageInfo<Map<String, Object>> linesData = statisticsService.spsByLine(page, limit, sheetPo, productType,
				productLineCode, beginTime, endTime);
		List<Map<String, Object>> data = linesData.getList();
		List<String> sheetPoes = data.parallelStream().map(d -> String.valueOf(d.get("SHEET_PO")))
				.collect(Collectors.toList());
		List<String> lines = data.parallelStream().map(d -> String.valueOf(d.get("PRODUCT_LINE_CODE")))
				.collect(Collectors.toList());
		List<Map<String, Object>> statesData = statisticsService.spsByState(sheetPoes, lines, beginTime, endTime, null);
		data.parallelStream().forEach(d -> {
			Object sheet_po = d.get("SHEET_PO");
			Object product_line_code = d.get("PRODUCT_LINE_CODE");
			Map<String, Object> states = (Map<String, Object>) d.get("STATES");
			if (states == null) {
				states = new HashMap<>();
				d.put("STATES", states);
			}
			if (statesData != null) {
				List<Map<String, Object>> stateData = statesData.parallelStream().filter(
						m -> sheet_po.equals(m.get("SHEET_PO")) && product_line_code.equals(m.get("PRODUCT_LINE_CODE")))
						.collect(Collectors.toList());
				for (Map<String, Object> m : stateData) {
					Object processCode = m.get("PROCESS_CODE");
					states.put(String.valueOf(processCode), m);
				}
			}
		});
		model.addObject("page", new Page("200", "", linesData.getTotal(), data));
		return model;
	}

	/*
	 * @RequestMapping(value = "/query_count_by_state_data", method =
	 * RequestMethod.POST)
	 * 
	 * @ResponseBody Page queryCountByState(@RequestParam(name = "page",
	 * defaultValue = "1") int page, @RequestParam(name = "limit", defaultValue =
	 * "10") int limit, String sheetPo, String productLineCode, String
	 * productTypeCode, String processCode, Date startTime, Date endTime) {
	 * PageInfo<Map<String, Object>> pageData =
	 * statisticsService.queryCountByState(page, limit, sheetPo, productLineCode,
	 * productTypeCode, processCode, startTime, endTime); return new Page("200",
	 * "查询成功", pageData.getTotal(), pageData.getList()); }
	 */

	/**
	 * 产出追溯
	 *
	 * @return
	 */
	@RequestMapping(value = "/query_count_time_by_state", method = RequestMethod.GET)
	ModelAndView queryCountTimeByState() {
		ModelAndView model = new ModelAndView();
		List<Process> processes = processServiceFacade.findAll();
		List<ProductLine> productLines = productLineServiceFacade.findAll();
		List<ProductType> productTypes = productTypeServiceFacade.findValidProductType();
		model.addObject("processes", processes);
		model.addObject("productLines", productLines);
		model.addObject("productTypes", productTypes);
		return model;
	}

	@RequestMapping(value = "/query_count_time_by_state_data", method = RequestMethod.POST)
	@ResponseBody
	Page queryCountTimeByState(@RequestParam(name = "page", defaultValue = "1") int page,
			@RequestParam(name = "limit", defaultValue = "10") int limit, String sheetPo, String productType,
			String productLineCode, String processCode, String startTime, String endTime) {
		Date startDt = null;
		Date endDt = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (!StringUtils.isEmpty(startTime)) {
			try {
				startDt = sdf.parse(startTime);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (!StringUtils.isEmpty(endTime)) {
			try {
				endDt = sdf.parse(endTime);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		PageInfo<Map<String, Object>> pageData = statisticsService.queryCountTimeByState(page, limit, sheetPo,
				productType, productLineCode, processCode, startDt, endDt);
		return new Page("200", "查询成功", pageData.getTotal(), pageData.getList());
	}

	/**
	 * 物料追溯
	 *
	 * @return
	 */
	@RequestMapping(value = "/query_sninfo", method = RequestMethod.GET)
	ModelAndView querySninfo(@RequestParam(name = "page", defaultValue = "1") int page,
			@RequestParam(name = "limit", defaultValue = "10") int limit, String sheetPo, String cpsn, String sn) {
		ModelAndView model = new ModelAndView();
		Product product = new Product();
		if (!StringUtils.isEmpty(sheetPo)) {
			product.setSheetPo(sheetPo);
		}
		if (!StringUtils.isEmpty(cpsn)) {
			product.setCpsn(cpsn);
		}
		if (!StringUtils.isEmpty(sn)) {
			SnInfo snInfo = snInfoServiceFacade.findBysn(sn);
			if (snInfo != null) {
				Product search = productServiceFacade.findProductById(snInfo.getProductId());
				if (sn.equalsIgnoreCase(search.getBlsn())) {
					product.setBlsn(sn);
				} else if (sn.equalsIgnoreCase(search.getBbsn())) {
					product.setBbsn(sn);
				} else if (sn.equalsIgnoreCase(search.getCgqsn())) {
					product.setCgqsn(sn);
				} else if (sn.equalsIgnoreCase(search.getCpsn())) {
					product.setCpsn(sn);
				} else if (sn.equalsIgnoreCase(search.getSmssn())) {
					product.setSmssn(sn);
				} else if (sn.equalsIgnoreCase(search.getBxksn())) {
					product.setBxksn(sn);
				} else if (sn.equalsIgnoreCase(search.getChsn())) {
					product.setChsn(sn);
				}
			}
		}
		// product.setValid(1);
		PageInfo<Product> pageData = productServiceFacade.getPageData(product, page, limit);
		List<Product> list = pageData.getList();
		List<Long> ids = list.stream().map(p -> p.getId()).collect(Collectors.toList());
		List<SnInfo> snInfos = snInfoServiceFacade.findByIds(ids, sn);
		List<Map<String, Object>> data = list.parallelStream().map(p -> {
			Map<String, Object> map = new HashMap<>();
			long productId = p.getId().longValue();
			List<SnInfo> infos = snInfos.parallelStream().filter(s -> productId == s.getProductId().longValue())
					.collect(Collectors.toList());
			map.put("snInfo", infos);
			map.put("cpsn", p.getCpsn());
			map.put("sheetPo", p.getSheetPo());
			map.put("productTypeCode", p.getProductTypeCode());
			map.put("productTypeName", p.getProductTypeName());
			return map;
		}).collect(Collectors.toList());
		model.addObject("page", new Page("200", "", pageData.getTotal(), data));
		return model;
	}

	/**
	 * 根据根据工单线别统计
	 *
	 * @return
	 */
	@RequestMapping(value = "/{sheetPo}/{product_line_code}/{state}/query_repair", method = RequestMethod.GET)
	ModelAndView queryRepair(@PathVariable("sheetPo") String sheetPo,
			@PathVariable("product_line_code") String product_line_code, @PathVariable("state") String state) {
		ModelAndView model = new ModelAndView();
		model.setViewName("/statistics/query_repair");
		model.addObject("po", sheetPo);
		model.addObject("line", product_line_code);
		model.addObject("state", state);
		return model;
	}

	@RequestMapping(value = "/{sheetPo}/{product_line_code}/{state}/repair_data", method = RequestMethod.POST)
	@ResponseBody
	Page repairData(@RequestParam(name = "page", defaultValue = "1") int page,
			@RequestParam(name = "limit", defaultValue = "10") int limit, @PathVariable("sheetPo") String sheetPo,
			@PathVariable("product_line_code") String product_line_code, @PathVariable("state") String state) {
		PageInfo<Map<String, Object>> pageData = statisticsService.queryRepair(page, limit, sheetPo, product_line_code,
				state);
		return new Page("200", "查询成功", pageData.getTotal(), pageData.getList());
	}
	/**
	 * 数据报表
	 *
	 * @return
	 */
	@RequestMapping(value = "query_data_statement", method = RequestMethod.GET)
	ModelAndView queryDataStatement() {
		ModelAndView model = new ModelAndView();
		List<Process> processes = processServiceFacade.findAll();
		List<ProductLine> productLines = productLineServiceFacade.findAll();
		model.addObject("processes", processes);
		model.addObject("productLines", productLines);
		return model;
	}
	@RequestMapping(value = "/query_data_statement_by__data", method = RequestMethod.POST)
	@ResponseBody
	Page queryDataStatementByData(@RequestParam(name = "page", defaultValue = "1") int page,
			@RequestParam(name = "limit", defaultValue = "10") int limit, String sheetPo, 
			String productLineCode, String processCode,String status,  String startTime, String endTime) {
		Date startDt = null;
		Date endDt = null;
		String[] processCodes=null;
		String[] statuss=null;
		String[] productLineCodes=null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (!StringUtils.isEmpty(startTime)) {
			try {
				startDt = sdf.parse(startTime);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (!StringUtils.isEmpty(endTime)) {
			try {
				endDt = sdf.parse(endTime);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (!StringUtils.isEmpty(processCode)) {
			processCodes = processCode.split(",");
		}
		if (!StringUtils.isEmpty(status)) {
			 statuss = status.split(",");
		}else {
			statuss= new String[]{"0","-1"};
		}
		if (!StringUtils.isEmpty(productLineCode)) {
			productLineCodes = productLineCode.split(",");
		}
		PageInfo<Map<String, Object>> pageData = statisticsService.queryDataStatement(page, limit, sheetPo, statuss, productLineCodes, processCodes, startDt, endDt);
		return new Page("200", "查询成功", pageData.getTotal(), pageData.getList());
	}
	/**
	 * 下载报表
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/export", method = RequestMethod.GET)
	void export(HttpServletRequest request, HttpServletResponse response,String sheetPo, 
			String productLineCode, String processCode,String status,  String startTime, String endTime) {
		Date startDt = null;
		Date endDt = null;
		String[] processCodes=null;
		String[] statuss=null;
		String[] productLineCodes=null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (!StringUtils.isEmpty(startTime)) {
			try {
				startDt = sdf.parse(startTime);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (!StringUtils.isEmpty(endTime)) {
			try {
				endDt = sdf.parse(endTime);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (!StringUtils.isEmpty(processCode)) {
			processCodes = processCode.split(",");
		}
		if (!StringUtils.isEmpty(status)) {
			 statuss = status.split(",");
		}else {
			statuss= new String[]{"0","-1"};
		}
		if (!StringUtils.isEmpty(productLineCode)) {
			productLineCodes = productLineCode.split(",");
		}
		//设置文件名
		String fileName = "生产数据"+sdf.format(new Date());
		//输出流
		OutputStream out = null;
		// 声明一个工作簿
		XSSFWorkbook workbook = new XSSFWorkbook();
		try {
			// 设置response参数，可以打开下载页面
			response.reset();
			response.setContentType("application/vnd.ms-excel;charset=utf-8");
			response.setHeader("Content-Disposition",
					"attachment;filename=" + new String((fileName+".xlsx").getBytes("gbk"), "iso-8859-1"));
			response.addHeader("Pargam", "no-cache");
			response.addHeader("Cache-Control", "no-cache");
			out = response.getOutputStream();
			String title = "生产数据报表";
            String[] headers = {"产品SN","玻璃SN","工单号","型号代码","产线","工站","录入结果","录入数据","操作内容","操作时间"};
            String[] headersName = {"CPSN","BLSN","SHEET_PO","PRODUCT_TYPE_CODE","PRODUCT_LINE","NAME","STATUS","CONTENT_JSON","DESCRIPTION","CREATE_TIME"};
            //查询数据
            List<Map<String, Object>> list = statisticsService.dataStatementExport(sheetPo, statuss, productLineCodes, processCodes, startDt, endDt);
            // 声明一个表格
    		XSSFSheet sheet = workbook.createSheet(title);
    		// 设置表格默认列宽
    		sheet.setDefaultColumnWidth((short)20);
    		// 设置表格默认行高
    		//sheet.setDefaultRowHeight((short)25);
    		// 产生表格标题行
    		XSSFRow row = sheet.createRow(0);
    		for (short i = 0; i < headers.length; i++) {
    			XSSFCell cell = row.createCell(i);
    			//cell.setCellStyle(styleCaptaion);
    			XSSFRichTextString text = new XSSFRichTextString(headers[i]);
    			cell.setCellValue(text);
    		}
    		//产生数据行
    		for (int i = 0; i < list.size(); i++) {
    			row = sheet.createRow(i+1);
    			for (int j = 0; j < headersName.length; j++) {
    				XSSFCell cell = row.createCell(j);
    				String str="";
    				Object object = list.get(i).get(headersName[j]);
    				if(!StringUtils.isEmpty(object)) {
    					str=object.toString();
    				}
    				XSSFRichTextString text = new XSSFRichTextString(str);
        			cell.setCellValue(text);
				}
    			
			}
    		workbook.write(out);
			out.flush();
		} catch (IOException e) {
			System.out.println("报表下载异常");
		}  finally {
			try {
				out.close();
				workbook.close();
			} catch (IOException e) {
				System.out.println("关闭输入流异常");
			}
		}
		
	}
}
