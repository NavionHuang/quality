package com.lifesense.quality.controller;

import com.github.pagehelper.PageInfo;
import com.lifesense.quality.config.security.SecurityUser;
import com.lifesense.quality.domain.Bom;
import com.lifesense.quality.domain.ProductType;
import com.lifesense.quality.domain.QaUser;
import com.lifesense.quality.domain.WorkSheet;
import com.lifesense.quality.facade.BomServiceFacadeImpl;
import com.lifesense.quality.facade.ProductServiceFacadeImpl;
import com.lifesense.quality.facade.ProductTypeServiceFacadeImpl;
import com.lifesense.quality.facade.WorkSheetServiceFacadeImpl;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

/**
 * Created by 赵春定 on 2017/8/30.
 */
@RequestMapping("/sheet")
@Controller
public class SheetController {

	@Autowired
	private WorkSheetServiceFacadeImpl workSheetServiceFacade;
	@Autowired
	private ProductTypeServiceFacadeImpl productTypeServiceFacade;
	@Autowired
	private BomServiceFacadeImpl bomServiceFacade;
	@Autowired
	private ProductServiceFacadeImpl productServiceFacade;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	ModelAndView sheetList() {
		ModelAndView view = new ModelAndView();
		return view;
	}

	@RequestMapping(value = "/list_data", method = RequestMethod.POST)
	@ResponseBody
	Page listData(@RequestParam(name = "page", defaultValue = "1") int page,
			@RequestParam(name = "limit", defaultValue = "10") int limit, WorkSheet entity) {
		PageInfo<WorkSheet> pageData = workSheetServiceFacade.getPageData(entity, page, limit);
		return new Page("200", "查询成功", pageData.getTotal(), pageData.getList());
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	ModelAndView add() {
		ModelAndView view = new ModelAndView();
		List<ProductType> productTypeList = productTypeServiceFacade.findValidProductType();
		view.addObject("productTypeList", productTypeList);
		return view;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	ModelAndView edit(Long id) {
		ModelAndView view = new ModelAndView();
		List<ProductType> productTypeList = productTypeServiceFacade.findValidProductType();
		view.addObject("productTypeList", productTypeList);
		WorkSheet sheet = workSheetServiceFacade.findWorkSheetById(id);
		view.addObject("sheet", sheet);
		return view;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	ResponseMessage save(WorkSheet entity) {
		if (entity.getId() != null) {
			WorkSheet oldEntity = workSheetServiceFacade.findWorkSheetById(entity.getId());
			entity.setSheetNo(oldEntity.getSheetNo());
			entity.setProductTypeCode(oldEntity.getProductTypeCode());
		} else {
			String sheetPo = entity.getSheetPo();
			WorkSheet oldEntity = workSheetServiceFacade.findWorkSheetBySheetPo(sheetPo);

			if (oldEntity != null) {
				return new ResponseMessage("-1", "已存在重复的评审号");
			}
			int count = productServiceFacade.countBySheetPo(sheetPo);
			if (count > 0) {
				return new ResponseMessage("-1", "投产不能编辑");
			} else {
				SecurityUser userDetails = (SecurityUser) SecurityContextHolder.getContext().getAuthentication()
						.getPrincipal();
				entity.setCreateUser(userDetails.getUsername());
				entity.setCreateTime(new Date());
				entity.setValid(1);
			}
		}
		int result = workSheetServiceFacade.saveOrUpdate(entity);
		return new ResponseMessage("200", "保存成功");
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody
	ResponseMessage upload(@RequestParam MultipartFile file, HttpServletRequest req) {
		try {
			if (file != null) {
				// 取得当前上传文件的文件名称
				String myFileName = file.getOriginalFilename();
				// 如果名称不为“”,说明该文件存在，否则说明该文件不存在
				SecurityUser userDetails = (SecurityUser) SecurityContextHolder.getContext().getAuthentication()
						.getPrincipal();
				QaUser user = userDetails.getUser();
				if (myFileName.trim() != "") {
					XSSFWorkbook xssfWorkbook = new XSSFWorkbook(file.getInputStream());
					XSSFSheet sheet = xssfWorkbook.getSheetAt(0);
					XSSFSheet bomSheet = xssfWorkbook.getSheetAt(1);
					int sheetNum = 0;
					int bomNum = 0;
					for (int i = 1; i <= sheet.getLastRowNum(); i++) {
						XSSFRow xssfRow = sheet.getRow(i);
						XSSFCell cell0 = xssfRow.getCell(0);
						XSSFCell cell1 = xssfRow.getCell(1);
						XSSFCell cell2 = xssfRow.getCell(2);
						XSSFCell cell3 = xssfRow.getCell(3);
						XSSFCell cell4 = xssfRow.getCell(4);
						XSSFCell cell5 = xssfRow.getCell(5);
						String v0 = cell0.getStringCellValue();
						String v1 = cell1.getStringCellValue();
						String v2 = cell2.getStringCellValue();
						String v3 = cell3.getStringCellValue();
						String v4 = cell4.getStringCellValue();
						Double v5 = cell5.getNumericCellValue();
						WorkSheet workSheet = new WorkSheet();
						workSheet.setSheetNo(v0);
						workSheet.setSheetPo(v1);
						workSheet.setProductNo(v2);
						workSheet.setProductTypeCode(v4);
						workSheet.setOutputNum(v5.longValue());
						workSheet.setValid(0);
						workSheet.setCreateTime(new Date());
						workSheet.setCreateUser(user.getName());
						String sheetPo = workSheet.getSheetPo();
						String productTypeCode = workSheet.getProductTypeCode();
						ProductType productType = productTypeServiceFacade.findProductTypeByCode(productTypeCode);
						if (productType == null) {
							productType = new ProductType();
							productType.setCode(productTypeCode);
							productType.setName(v3 + "(" + productTypeCode + ")");
							productType.setValid(0);
							productTypeServiceFacade.saveOrUpdate(productType);
						}
						WorkSheet oldEntity = workSheetServiceFacade.findWorkSheetBySheetPo(sheetPo);
						if (oldEntity == null) {
							workSheetServiceFacade.saveOrUpdate(workSheet);
							sheetNum++;
						}
					}
					for (int i = 1; i <= bomSheet.getLastRowNum(); i++) {
						XSSFRow xssfRow = bomSheet.getRow(i);
						XSSFCell cell0 = xssfRow.getCell(0);
						XSSFCell cell2 = xssfRow.getCell(2);
						XSSFCell cell4 = xssfRow.getCell(4);
						XSSFCell cell5 = xssfRow.getCell(5);
						XSSFCell cell6 = xssfRow.getCell(6);
						String v0 = cell0.getStringCellValue();
						String v2 = cell2.getStringCellValue();
						String v4 = cell4.getStringCellValue();
						String v5 = cell5.getStringCellValue();
						String v6 = cell6.getStringCellValue();
						Bom bom = new Bom();
						bom.setProductNo(v0);
						bom.setProductTypeCode(v2);
						bom.setCode(v4);
						bom.setName(v5);
						bom.setSpec(v6);
						List<Bom> boms = bomServiceFacade.findBomByProductTypeCode(bom.getProductTypeCode(),
								bom.getCode());
						if (boms == null || boms.isEmpty()) {
							bomServiceFacade.saveOrUpdate(bom);
							bomNum++;
						}
					}
					// 结果绑定文件路径
					return new ResponseMessage("200", "导入成功工单数：" + sheetNum + ",bom数:" + bomNum);
				}
			} else {
				return new ResponseMessage("-1", "文件错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseMessage("-1", "导入出错");
		}
		return new ResponseMessage("-1", "导入出错");
	}

	@RequestMapping(value = "/export", method = RequestMethod.GET)
	void export(HttpServletRequest request, HttpServletResponse response) {
		String fileName = "sheet_data";
		// 设置response参数，可以打开下载页面
		OutputStream out = null;
		XSSFWorkbook wb = null;// keep 100 rows in memory, exceeding rows will be flushed to disk
		try {
			response.reset();
			response.setContentType("application/vnd.ms-excel;charset=utf-8");
			response.setHeader("Content-Disposition",
					"attachment;filename=" + new String((fileName + ".xlsx").getBytes(), "iso-8859-1"));
			response.addHeader("Pargam", "no-cache");
			response.addHeader("Cache-Control", "no-cache");
			out = response.getOutputStream();
			String filePath = this.getClass().getResource("/temple.xlsx").getPath();
			File file = new File(filePath);
			wb = new XSSFWorkbook(file);
			wb.write(out);
			out.flush();
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
