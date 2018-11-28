package com.lifesense.quality.api;

import com.google.gson.Gson;
import com.lifesense.quality.config.security.SecurityUser;
import com.lifesense.quality.controller.ResponseMessage;
import com.lifesense.quality.domain.*;
import com.lifesense.quality.domain.Process;
import com.lifesense.quality.facade.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 赵春定 on 2017/8/8.
 */
@RestController
@RequestMapping("/api/v1")
public class AppController {

	private final static String SESSION_USER = "user";
	private final static String SESSION_LINE = "line";
	private final static String SESSION_PO = "po";
	private final static String SESSION_PROCESS = "process";

	private Logger logger = LoggerFactory.getLogger(AppController.class);

	@Autowired
	private BusinessServiceFacadeImpl businessServiceFacade;
	@Autowired
	private ProductLineServiceFacadeImpl productLineServiceFacade;

	@Autowired
	private WorkSheetServiceFacadeImpl workSheetServiceFacade;

	@Autowired
	private BadcodeServiceFacadeImpl badcodeServiceFacade;
	@Autowired
	private ProcessServiceFacadeImpl processServiceFacade;
	@Autowired
	private ProductTypeServiceFacadeImpl productTypeServiceFacade;
	/**
	 * 登录 返还message是消息，code是代码，0登录失败，1登录成功
	 *
	 * @param workcode
	 *            工号
	 * @return
	 */
	/*
	 * 默认使用security登录
	 * 
	 * @RequestMapping(value = "/{workcode}/login", method = RequestMethod.POST)
	 * ResponseMessage login(HttpServletRequest requst, @PathVariable String
	 * workcode) { HttpSession session = requst.getSession(); ResponseMessage
	 * response = new ResponseMessage(); Object obj =
	 * session.getAttribute(SESSION_USER); if (obj == null) { QaUser user =
	 * userService.loadUserByUserName(workcode); if (user == null || user.getValid()
	 * != 0) { response.setCode("0"); response.setMsg("工号[" + workcode +
	 * "]已经无效,请联系管理员或者拉长"); } else { session.setAttribute(SESSION_USER, user);
	 * response.setCode("1"); response.setMsg("工号[" + workcode + "]登陆成功"); } } else
	 * { response.setCode("0"); response.setMsg("工号[" + workcode + "]已经登陆"); }
	 * logger.info("{}正在登陆，登陆结果{}", workcode, response.getMsg()); return response; }
	 */

	/**
	 * 退出 返还message是消息，code是代码，0退出失败，1退出成功
	 *
	 * @return
	 */
	/*
	 * 使用security退出
	 * 
	 * @RequestMapping(value = "/logout", method = RequestMethod.POST)
	 * ResponseMessage logout(HttpServletRequest request) { ResponseMessage response
	 * = new ResponseMessage(); HttpSession session = request.getSession(); Object
	 * obj = session.getAttribute(SESSION_USER); if (obj != null) { QaUser user =
	 * (QaUser) obj; //user.setOnLine(0); //userService.updateUser(user);
	 * response.setCode("1"); response.setMsg("退出成功");
	 * session.removeAttribute(SESSION_USER); } else { response.setCode("0");
	 * response.setMsg("客户端没有用户登录"); } logger.info("{}正在退出，登陆结果{}",
	 * response.getMsg()); return response; }
	 */

	/**
	 * OK测试录入 line 线别代码 workcode 工号 sn 产品sn
	 */
	@RequestMapping(value = "/{code}/setline", method = RequestMethod.POST)
	ResponseMessage setline(HttpServletRequest request, @PathVariable String code) {
		HttpSession session = request.getSession();
		ProductLine productLine = productLineServiceFacade.findProductLineByCode(code);
		if (productLine == null) {
			logger.warn("{}设置线别，设置失败", code);
			return new ResponseMessage("-1", "线别[" + code + "]不存在");
		} else {
			logger.info("{}设置线别，设置成功", code);
			session.setAttribute(SESSION_LINE, productLine);
			return new ResponseMessage("200", "当前工作线别[" + code + "]");
		}
	}

	/**
	 * OK测试录入 line 线别代码 workcode 工号 sn 产品sn
	 */
	@RequestMapping(value = "/{po}/setpo", method = RequestMethod.POST)
	ResponseMessage setSheetNo(HttpServletRequest request, @PathVariable String po) {
		HttpSession session = request.getSession();
		WorkSheet sheet = workSheetServiceFacade.findWorkSheetBySheetPo(po);
		if (sheet == null) {
			logger.warn("{}设置工单，设置失败", po);
			return new ResponseMessage("-1", "工单[" + po + "]不存在");
		} else {
			String productTypeCode = sheet.getProductTypeCode();
			ProductType productType = productTypeServiceFacade.findProductTypeByCode(productTypeCode);
			sheet.setProductTypeName(productType.getName());
			session.setAttribute(SESSION_PO, sheet);
			logger.info("{}设置工单，设置成功", po);
			return new ResponseMessage("200", "当前工单[" + po + "]");
		}
	}

	/**
	 * 录入玻璃 半成品测试 外观测试
	 *
	 * @param request
	 * @param sn
	 * @return
	 */
	@RequestMapping(value = "/{sn}/ok", method = RequestMethod.POST)
	ResponseMessage workOk(HttpServletRequest request, @PathVariable String sn) {
		ResponseMessage message = checkReqeust(request);
		if (!"200".equals(message.getCode())) {
			return message;
		}
		QaUser user = getUser();
		Long userId = user.getId();
		String processCode = user.getProcessCode();
		WorkSheet sheet = getWorkSheet(request);
		ProductLine productLine = getProductLine(request);
		String sheetPo = sheet.getSheetPo();
		String productLineCode = productLine.getCode();
		long st = System.currentTimeMillis();
		logger.info("workOK input {},{},{},{}", sheetPo, productLineCode, sn, userId);
		if ("T01".equalsIgnoreCase(processCode)) {
			// 录入玻璃
			message = businessServiceFacade.processT01(sheetPo, productLineCode, processCode, sn, userId);
		} else if ("T04".equalsIgnoreCase(processCode)) {
			// 半成品测试
			message = businessServiceFacade.processT04(sheetPo, productLineCode, processCode, sn, userId, 0, null);
		} else if ("T12".equalsIgnoreCase(processCode)) {
			/* 外观测试 ok */
			message = businessServiceFacade.processT12(sheetPo, productLineCode, processCode, sn, userId, 0, null);
		} else {
			message = businessServiceFacade.processAuto(productLineCode, processCode, sn, 0, userId, null, null);
		}
		logger.info("workOK output 花费{}秒==={}", (System.currentTimeMillis() - st) / 1000, new Gson().toJson(message));
		return message;
	}

	/**
	 * 半成品测试 外观测试
	 *
	 * @param request
	 * @param sn
	 * @param badcode
	 * @return
	 */
	@RequestMapping(value = "/{badcode}/{sn}/ng", method = RequestMethod.POST)
	ResponseMessage workNg(HttpServletRequest request, @PathVariable String sn, @PathVariable String badcode) {
		ResponseMessage message = checkReqeust(request);
		if (!"200".equals(message.getCode())) {
			return message;
		}
		String json = request.getParameter("json");
		QaUser user = getUser();
		Long userId = user.getId();
		String processCode = user.getProcessCode();
		WorkSheet sheet = getWorkSheet(request);
		ProductLine productLine = getProductLine(request);
		String sheetPo = sheet.getSheetPo();
		String productLineCode = productLine.getCode();
		long st = System.currentTimeMillis();
		logger.info("workNg input {},{},{},{},{}", sheetPo, productLineCode, sn, userId, badcode);
		BadCode badCode = badcodeServiceFacade.findBadcodeByCode(processCode, badcode);
		if (badCode == null) {
			message = new ResponseMessage("-1", "不良码不存在，请联系管理员录入不良码");
			return message;
		}
		if ("T04".equalsIgnoreCase(processCode)) {
			// 半成品测试
			message = businessServiceFacade.processT04(sheetPo, productLineCode, processCode, sn, userId, -1, badcode);
		} else if ("T12".equalsIgnoreCase(processCode)) {
			/* 外观测试 */
			message = businessServiceFacade.processT12(sheetPo, productLineCode, processCode, sn, userId, -1, badcode);
		} else {
			message = businessServiceFacade.processAuto(productLineCode, processCode, sn, -1, userId, badcode, json);
		}
		logger.info("workNg output 花费{}秒==={}", (System.currentTimeMillis() - st) / 1000, new Gson().toJson(message));
		return message;
	}

	/**
	 * 绑定邦板 绑定传感器 绑定产品sn
	 *
	 * @param request
	 * @param sn
	 *            主sn
	 * @param other
	 * @return
	 */
	@RequestMapping(value = "/{sn}/{other}/ok", method = RequestMethod.POST)
	ResponseMessage workBind(HttpServletRequest request, @PathVariable String sn, @PathVariable String other) {
		ResponseMessage message = checkReqeust(request);
		if (!"200".equals(message.getCode())) {
			return message;
		}
		QaUser user = getUser();
		Long userId = user.getId();
		String processCode = user.getProcessCode();
		WorkSheet sheet = getWorkSheet(request);
		ProductLine productLine = getProductLine(request);
		String sheetPo = sheet.getSheetPo();
		String productLineCode = productLine.getCode();
		long st = System.currentTimeMillis();
		logger.info("workBind input {},{},{},{},{}", sheetPo, productLineCode, sn, other, userId);
		if ("T02".equalsIgnoreCase(processCode)) {
			// 邦板
			message = businessServiceFacade.processT02(sheetPo, productLineCode, processCode, sn, other, userId);
		} else if ("T03".equalsIgnoreCase(processCode)) {
			/* 传感器 */
			message = businessServiceFacade.processT03(sheetPo, productLineCode, processCode, sn, other, userId);
		} else if ("T05".equalsIgnoreCase(processCode)) {
			/* 合壳 */
			message = businessServiceFacade.processT05(sheetPo, productLineCode, processCode, sn, other, userId);
		}/* else if ("T12".equalsIgnoreCase(processCode)) {
			
			message = businessServiceFacade.processT12(sheetPo, productLineCode, processCode, sn, other, userId);
		} */else {
			message = new ResponseMessage("-1", "参数错误，没有处理的工站");
		}
		logger.info("workBind output 花费{}秒==={}", (System.currentTimeMillis() - st) / 1000, new Gson().toJson(message));
		return message;
	}

	/**
	 * 绑定说明书，保修卡，
	 *
	 * @param request
	 * @param sn
	 * @param sms
	 * @param bxk
	 * @return
	 */
	@RequestMapping(value = "/{sn}/{sms}/{ch}/ok", method = RequestMethod.POST)
	ResponseMessage workBind(HttpServletRequest request, @PathVariable String sn, @PathVariable String sms,
			@PathVariable String ch) {
		ResponseMessage message = checkReqeust(request);
		if (!"200".equals(message.getCode())) {
			return message;
		}
		QaUser user = getUser();
		Long userId = user.getId();
		String processCode = user.getProcessCode();
		WorkSheet sheet = getWorkSheet(request);
		ProductLine productLine = getProductLine(request);
		String sheetPo = sheet.getSheetPo();
		String productLineCode = productLine.getCode();
		long st = System.currentTimeMillis();
		logger.info("workBind input {},{},{},{},{}", sheetPo, productLineCode, sn, sms, ch, userId);
		if ("T13".equalsIgnoreCase(processCode)) {
			// 说明书，彩盒
			message = businessServiceFacade.processT13(sheetPo, productLineCode, processCode, sn, sms, ch, userId);
		} else {
			message = new ResponseMessage("-1", "参数错误，没有处理的工站");
		}
		logger.info("workBind output 花费{}秒==={}", (System.currentTimeMillis() - st) / 1000, new Gson().toJson(message));
		return message;
	}

	@RequestMapping(value = "/info", method = RequestMethod.POST)
	Map<String, Object> info(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		SecurityUser userDetails = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		QaUser user = userDetails.getUser();
		ProductLine productLine = (ProductLine) session.getAttribute(SESSION_LINE);
		WorkSheet sheet = (WorkSheet) session.getAttribute(SESSION_PO);
		Process process = (Process) session.getAttribute(SESSION_PROCESS);
		if (user != null) {
			map.put(SESSION_USER, user);
		}
		if (process == null) {
			String processCode = user.getProcessCode();
			process = processServiceFacade.findProcessByCode(processCode);
			session.setAttribute(SESSION_PROCESS, process);
			map.put(SESSION_PROCESS, process);
		} else {
			map.put(SESSION_PROCESS, process);
		}
		if ((productLine == null)) {
			String lineCode = user.getLineCode();
			if (!StringUtils.isEmpty(lineCode)) {
				productLine = productLineServiceFacade.findProductLineByCode(lineCode);
				session.setAttribute(SESSION_LINE, productLine);
				map.put(SESSION_LINE, productLine);
			}
		} else {
			map.put(SESSION_LINE, productLine);
		}
		if (sheet != null) {
			map.put(SESSION_PO, sheet);
		}
		return map;
	}

	private ResponseMessage checkReqeust(HttpServletRequest request) {
		QaUser user = getUser();
		if (user == null) {
			return new ResponseMessage("-1", "用户未登陆，请重新登陆");
		}
		ProductLine productLine = getProductLine(request);
		if (productLine == null) {
			return new ResponseMessage("-1", "线别未设置，请重新设置");
		}
		WorkSheet sheet = getWorkSheet(request);
		if (sheet == null) {
			return new ResponseMessage("-1", "未设置工单，请重新设置");
		}
		String processCode = user.getProcessCode();
		if (StringUtils.isEmpty(processCode)) {
			return new ResponseMessage("-1", "作业员的工站未找到，请设置作业员工站");
		}
		return new ResponseMessage("200", "正常");
	}

	/**
	 * 从session里取值
	 *
	 * @param request
	 * @return
	 */
	private ProductLine getProductLine(HttpServletRequest request) {
		HttpSession session = request.getSession();
		return (ProductLine) session.getAttribute(SESSION_LINE);
	}

	/**
	 * 从session里取值
	 *
	 * @param request
	 * @return
	 */
	private WorkSheet getWorkSheet(HttpServletRequest request) {
		HttpSession session = request.getSession();
		return (WorkSheet) session.getAttribute(SESSION_PO);
	}

	private QaUser getUser() {
		SecurityUser userDetails = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return userDetails != null ? userDetails.getUser() : null;
	}

}
