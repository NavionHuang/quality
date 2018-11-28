package com.lifesense.quality.controller;

import com.github.pagehelper.PageInfo;
import com.lifesense.quality.domain.BadCode;
import com.lifesense.quality.domain.Bom;
import com.lifesense.quality.domain.Burn;
import com.lifesense.quality.domain.Process;
import com.lifesense.quality.domain.ProductType;
import com.lifesense.quality.facade.BomServiceFacadeImpl;
import com.lifesense.quality.facade.ProductTypeServiceFacadeImpl;
import com.lifesense.quality.service.BurnService;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 赵春定 on 2017/8/30.
 */
@RequestMapping("/burn")
@Controller
public class BurnController {

	@Autowired
	private BurnService burnService;
	

	@RequestMapping(value = "/list_data", method = RequestMethod.POST)
	@ResponseBody
	Page listData(@RequestParam(name = "page", defaultValue = "1") int page,
			@RequestParam(name = "limit", defaultValue = "10") int limit, Burn entity, String startTime,
			String endTime) {
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
		PageInfo<Burn> pageData = burnService.query(entity, startDt, endDt, page, limit);
		return new Page("200", "查询成功", pageData.getTotal(), pageData.getList());
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	ModelAndView burnList() {
		ModelAndView view = new ModelAndView();
		return view;
	}

	/**
	 * 下载报表
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/export", method = RequestMethod.GET)
	void export(HttpServletRequest request, HttpServletResponse response, Burn entity, String startTime,
			String endTime) {
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
		// 设置文件名
		String fileName = "邦板烧录数据" + sdf.format(new Date());
		// 输出流
		OutputStream out = null;
		// 声明一个工作簿
		XSSFWorkbook workbook = new XSSFWorkbook();
		try {
			// 设置response参数，可以打开下载页面
			response.reset();
			response.setContentType("application/vnd.ms-excel;charset=utf-8");
			response.setHeader("Content-Disposition",
					"attachment;filename=" + new String((fileName + ".xlsx").getBytes("gbk"), "iso-8859-1"));
			response.addHeader("Pargam", "no-cache");
			response.addHeader("Cache-Control", "no-cache");
			out = response.getOutputStream();
			String title = "邦板烧录数据";
			String[] headers = { "邦板SN", "MAC", "工单号", "版本信息", "测试人", "测试时间" };
			String[] headersName = { "sn", "mac", "po", "version", "name", "createTime" };
			// 查询数据
			List<Burn> list = burnService.query(entity, startDt, endDt);
			// 声明一个表格
			XSSFSheet sheet = workbook.createSheet(title);
			// 设置表格默认列宽
			sheet.setDefaultColumnWidth((short) 20);
			// 设置表格默认行高
			// sheet.setDefaultRowHeight((short)25);
			// 产生表格标题行
			XSSFRow row = sheet.createRow(0);
			for (short i = 0; i < headers.length; i++) {
				XSSFCell cell = row.createCell(i);
				// cell.setCellStyle(styleCaptaion);
				XSSFRichTextString text = new XSSFRichTextString(headers[i]);
				cell.setCellValue(text);
			}
			// 产生数据行
			for (int i = 0; i < list.size(); i++) {
				row = sheet.createRow(i + 1);
				for (int j = 0; j < headersName.length; j++) {
					XSSFCell cell = row.createCell(j);
					String str = "";
					String header = headersName[j];
					switch (header) {
					case "sn":
						str = list.get(i).getSn();
						break;
					case "mac":
						str = list.get(i).getMac();
						break;
					case "po":
						str = list.get(i).getPo();
						break;
					case "version":
						str = list.get(i).getVersion();
						break;
					case "name":
						str = list.get(i).getName();
						break;
					case "createTime":
						str=sdf.format(list.get(i).getCreateTime());
						break;
					default:
						break;
					}
					XSSFRichTextString text = new XSSFRichTextString(str);
					cell.setCellValue(text);
				}
			}
			workbook.write(out);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				workbook.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
