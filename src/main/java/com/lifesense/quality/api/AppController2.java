package com.lifesense.quality.api;

import com.github.pagehelper.PageInfo;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.lifesense.quality.controller.ResponseMessage;
import com.lifesense.quality.domain.Process;
import com.lifesense.quality.domain.ProcessRecord;
import com.lifesense.quality.domain.Product;
import com.lifesense.quality.domain.ProductLine;
import com.lifesense.quality.domain.QaUser;
import com.lifesense.quality.facade.BusinessServiceFacadeImpl;
import com.lifesense.quality.facade.ProcessRecordServiceFacadeImpl;
import com.lifesense.quality.facade.ProcessServiceFacadeImpl;
import com.lifesense.quality.facade.ProductLineServiceFacadeImpl;
import com.lifesense.quality.facade.ProductServiceFacadeImpl;
import com.lifesense.quality.facade.QaUserServiceFacadeImpl;
import com.lifesense.quality.service.BurnService;
import com.lifesense.quality.domain.Burn;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Auther zcd
 * @Date
 */
@RestController
@RequestMapping("/api/v2")
public class AppController2 {

	private Logger logger = LoggerFactory.getLogger(AppController2.class);

	private static final String OK = "OK";
	private static final String NG = "NG";

	@Autowired
	private BusinessServiceFacadeImpl businessServiceFacade;
	@Autowired
	private QaUserServiceFacadeImpl userServiceFacade;
	@Autowired
	private ProductLineServiceFacadeImpl productLineServiceFacade;
	@Autowired
	private ProcessServiceFacadeImpl processServiceFacade;
	@Autowired
	private BurnService burnService;
	@Autowired
	private ProductServiceFacadeImpl productServiceFacadeImpl;
	@Autowired
	private ProcessRecordServiceFacadeImpl processRecordServiceFacadeImpl;
	
	

	@RequestMapping("/T06")
	ResponseData autoT06(@RequestBody String json) {
		logger.info("input ={}", json);
		long st = System.currentTimeMillis();
		ResponseData responseData = new ResponseData("200");
		try {
			JsonObject jsonRoot = new JsonParser().parse(json).getAsJsonObject();
			JsonArray jsonArray = jsonRoot.getAsJsonArray("json");
			List<ProductInfo> productInfos = new ArrayList<>();
			List<String> msg = new ArrayList<>();
			jsonArray.forEach(jo -> {
				ProductInfo productInfo = new Gson().fromJson(jo, new TypeToken<ProductInfo>() {
				}.getType());
				String processCode = productInfo.getProcessCode();
				String productLineCode = productInfo.getProductLine();
				String sn = productInfo.getSn();
				String result = productInfo.getResult();
				ProductLine productLine = productLineServiceFacade.findProductLineByCode(productLineCode);
				if (productLine == null) {
					msg.add("产线代码[" + productLineCode + "]不存在");
					productInfos.add(productInfo);
					return;
				}
				Process process = processServiceFacade.findProcessByCode(processCode);
				if (process == null) {
					msg.add("工站代码[" + processCode + "]不存在");
					productInfos.add(productInfo);
					return;
				}
				if ("T06".equalsIgnoreCase(processCode) || "T07".equalsIgnoreCase(processCode)
						|| "T08".equalsIgnoreCase(processCode) || "T09".equalsIgnoreCase(processCode)
						|| "T10".equalsIgnoreCase(processCode) || "T11".equalsIgnoreCase(processCode)
						|| processCode.startsWith("AT")) {
					//T06 WIFI测试
					if("T06".equalsIgnoreCase(processCode)) {
						if(sn.indexOf("_")>0) {
							String[] strings = sn.split("_");
							if(strings.length!=2) {
								msg.add("请输入一个MAC编码");
								productInfos.add(productInfo);
								return;	
							}
							sn=strings[0];
							String mac=strings[1];
							//查询产品ID
							Product product = productServiceFacadeImpl.findProductByCpsn(sn);
							if(null==product) {
								msg.add("产品SN["+sn+"]不存在");
								productInfos.add(productInfo);
								return;
							}
							Burn burn=new Burn();
							burn.setMac(mac);
							burn.setProductId(product.getId());
							PageInfo<Burn> query = burnService.query(burn,null,null, 1, 1);
							List<Burn> burnList = query.getList();
							if(burnList.size()==0) {
								msg.add("产品SN["+sn+"]与MAC["+mac+"]不匹配");
								productInfos.add(productInfo);
								return;
							}
						}else {
							msg.add("WIFI测试必须包含产品SN和MAC,用下划线分隔");
							productInfos.add(productInfo);
							return;
						}
					}
					Integer status = OK.equalsIgnoreCase(result) ? 0 : -1;
					Map data = productInfo.getData();
					String jsonData = null;
					if (data != null) {
						jsonData = new Gson().toJson(data);
					}
					String userName = productInfo.getName();
					if (StringUtils.isEmpty(userName)) {
						// productInfo.setResult(NG);
						msg.add("操作员不存在");
						productInfos.add(productInfo);
					} else {
						QaUser user = userServiceFacade.findQaUserByCode(userName);
						if (user == null) {
							// productInfo.setResult(NG);
							msg.add("操作员不存在");
							productInfos.add(productInfo);
						} else {
							ResponseMessage message = businessServiceFacade.processAuto(productLineCode, processCode,
									sn, status, user.getId(), "NG", jsonData);
							if (!"200".equalsIgnoreCase(message.getCode())) {
								// productInfo.setResult(NG);
								msg.add(message.getMsg());
								productInfos.add(productInfo);
							}
						}
					}
				} else {
					// productInfo.setResult(NG);
					msg.add("工站代码必须为T06,T07,T08,T09,T10,T11");
					productInfos.add(productInfo);
				}
			});
			if (!productInfos.isEmpty()) {
				responseData.setData(productInfos);
				responseData.setMsg(msg);
			}
			responseData.setCode("200");
		} catch (Exception e) {
			e.printStackTrace();
			List<String> errors = new ArrayList<>();
			String msg = e.getMessage();
			errors.add(msg);
			responseData.setMsg(errors);
			responseData.setCode("-1");
		}
		logger.info("output 花费{}秒== {}", (System.currentTimeMillis() - st) / 1000, new Gson().toJson(responseData));
		return responseData;
	}
	@RequestMapping("/T07")
	ResponseData autoT07(@RequestBody String json) {
		logger.info("input ={}", json);
		long st = System.currentTimeMillis();
		ResponseData responseData = new ResponseData("200");
		try {
			JsonObject jsonRoot = new JsonParser().parse(json).getAsJsonObject();
			JsonArray jsonArray = jsonRoot.getAsJsonArray("json");
			List<ProductInfo> productInfos = new ArrayList<>();
			List<String> msg = new ArrayList<>();
			jsonArray.forEach(jo -> {
				ProductInfo productInfo = new Gson().fromJson(jo, new TypeToken<ProductInfo>() {
				}.getType());
				String processCode = productInfo.getProcessCode();
				String productLineCode = productInfo.getProductLine();
				String sn = productInfo.getSn();
				String result = productInfo.getResult();
				ProductLine productLine = productLineServiceFacade.findProductLineByCode(productLineCode);
				if (productLine == null) {
					msg.add("产线代码[" + productLineCode + "]不存在");
					productInfos.add(productInfo);
					return;
				}
				Process process = processServiceFacade.findProcessByCode(processCode);
				if (process == null) {
					msg.add("工站代码[" + processCode + "]不存在");
					productInfos.add(productInfo);
					return;
				}
				if ("T06".equalsIgnoreCase(processCode) || "T07".equalsIgnoreCase(processCode)
						|| "T08".equalsIgnoreCase(processCode) || "T09".equalsIgnoreCase(processCode)
						|| "T10".equalsIgnoreCase(processCode) || "T11".equalsIgnoreCase(processCode)
						|| processCode.startsWith("AT")) {
					//T06 WIFI测试
					if("T06".equalsIgnoreCase(processCode)) {
						if(sn.indexOf("_")>0) {
							String[] strings = sn.split("_");
							if(strings.length!=2) {
								msg.add("请输入一个MAC编码");
								productInfos.add(productInfo);
								return;	
							}
							sn=strings[0];
							String mac=strings[1];
							//查询产品ID
							Product product = productServiceFacadeImpl.findProductByCpsn(sn);
							if(null==product) {
								msg.add("产品SN["+sn+"]不存在");
								productInfos.add(productInfo);
								return;
							}
							Burn burn=new Burn();
							burn.setMac(mac);
							burn.setProductId(product.getId());
							PageInfo<Burn> query = burnService.query(burn,null,null, 1, 1);
							List<Burn> burnList = query.getList();
							if(burnList.size()==0) {
								msg.add("产品SN["+sn+"]与MAC["+mac+"]不匹配");
								productInfos.add(productInfo);
								return;
							}
						}else {
							msg.add("WIFI测试必须包含产品SN和MAC,用下划线分隔");
							productInfos.add(productInfo);
							return;
						}
					}
					Integer status = OK.equalsIgnoreCase(result) ? 0 : -1;
					Map data = productInfo.getData();
					String jsonData = null;
					if (data != null) {
						jsonData = new Gson().toJson(data);
					}
					String userName = productInfo.getName();
					if (StringUtils.isEmpty(userName)) {
						// productInfo.setResult(NG);
						msg.add("操作员不存在");
						productInfos.add(productInfo);
					} else {
						QaUser user = userServiceFacade.findQaUserByCode(userName);
						if (user == null) {
							// productInfo.setResult(NG);
							msg.add("操作员不存在");
							productInfos.add(productInfo);
						} else {
							ResponseMessage message = businessServiceFacade.processAuto(productLineCode, processCode,
									sn, status, user.getId(), "NG", jsonData);
							if (!"200".equalsIgnoreCase(message.getCode())) {
								// productInfo.setResult(NG);
								msg.add(message.getMsg());
								productInfos.add(productInfo);
							}
						}
					}
				} else {
					// productInfo.setResult(NG);
					msg.add("工站代码必须为T06,T07,T08,T09,T10,T11");
					productInfos.add(productInfo);
				}
			});
			if (!productInfos.isEmpty()) {
				responseData.setData(productInfos);
				responseData.setMsg(msg);
			}
			responseData.setCode("200");
		} catch (Exception e) {
			e.printStackTrace();
			List<String> errors = new ArrayList<>();
			String msg = e.getMessage();
			errors.add(msg);
			responseData.setMsg(errors);
			responseData.setCode("-1");
		}
		logger.info("output 花费{}秒== {}", (System.currentTimeMillis() - st) / 1000, new Gson().toJson(responseData));
		return responseData;
	}
	@RequestMapping("/T08")
	ResponseData autoT08(@RequestBody String json) {
		logger.info("input ={}", json);
		long st = System.currentTimeMillis();
		ResponseData responseData = new ResponseData("200");
		try {
			JsonObject jsonRoot = new JsonParser().parse(json).getAsJsonObject();
			JsonArray jsonArray = jsonRoot.getAsJsonArray("json");
			List<ProductInfo> productInfos = new ArrayList<>();
			List<String> msg = new ArrayList<>();
			jsonArray.forEach(jo -> {
				ProductInfo productInfo = new Gson().fromJson(jo, new TypeToken<ProductInfo>() {
				}.getType());
				String processCode = productInfo.getProcessCode();
				String productLineCode = productInfo.getProductLine();
				String sn = productInfo.getSn();
				String result = productInfo.getResult();
				ProductLine productLine = productLineServiceFacade.findProductLineByCode(productLineCode);
				if (productLine == null) {
					msg.add("产线代码[" + productLineCode + "]不存在");
					productInfos.add(productInfo);
					return;
				}
				Process process = processServiceFacade.findProcessByCode(processCode);
				if (process == null) {
					msg.add("工站代码[" + processCode + "]不存在");
					productInfos.add(productInfo);
					return;
				}
				if ("T06".equalsIgnoreCase(processCode) || "T07".equalsIgnoreCase(processCode)
						|| "T08".equalsIgnoreCase(processCode) || "T09".equalsIgnoreCase(processCode)
						|| "T10".equalsIgnoreCase(processCode) || "T11".equalsIgnoreCase(processCode)
						|| processCode.startsWith("AT")) {
					//T06 WIFI测试
					if("T06".equalsIgnoreCase(processCode)) {
						if(sn.indexOf("_")>0) {
							String[] strings = sn.split("_");
							if(strings.length!=2) {
								msg.add("请输入一个MAC编码");
								productInfos.add(productInfo);
								return;	
							}
							sn=strings[0];
							String mac=strings[1];
							//查询产品ID
							Product product = productServiceFacadeImpl.findProductByCpsn(sn);
							if(null==product) {
								msg.add("产品SN["+sn+"]不存在");
								productInfos.add(productInfo);
								return;
							}
							Burn burn=new Burn();
							burn.setMac(mac);
							burn.setProductId(product.getId());
							PageInfo<Burn> query = burnService.query(burn,null,null, 1, 1);
							List<Burn> burnList = query.getList();
							if(burnList.size()==0) {
								msg.add("产品SN["+sn+"]与MAC["+mac+"]不匹配");
								productInfos.add(productInfo);
								return;
							}
						}else {
							msg.add("WIFI测试必须包含产品SN和MAC,用下划线分隔");
							productInfos.add(productInfo);
							return;
						}
					}
					Integer status = OK.equalsIgnoreCase(result) ? 0 : -1;
					Map data = productInfo.getData();
					String jsonData = null;
					if (data != null) {
						jsonData = new Gson().toJson(data);
					}
					String userName = productInfo.getName();
					if (StringUtils.isEmpty(userName)) {
						// productInfo.setResult(NG);
						msg.add("操作员不存在");
						productInfos.add(productInfo);
					} else {
						QaUser user = userServiceFacade.findQaUserByCode(userName);
						if (user == null) {
							// productInfo.setResult(NG);
							msg.add("操作员不存在");
							productInfos.add(productInfo);
						} else {
							ResponseMessage message = businessServiceFacade.processAuto(productLineCode, processCode,
									sn, status, user.getId(), "NG", jsonData);
							if (!"200".equalsIgnoreCase(message.getCode())) {
								// productInfo.setResult(NG);
								msg.add(message.getMsg());
								productInfos.add(productInfo);
							}
						}
					}
				} else {
					// productInfo.setResult(NG);
					msg.add("工站代码必须为T06,T07,T08,T09,T10,T11");
					productInfos.add(productInfo);
				}
			});
			if (!productInfos.isEmpty()) {
				responseData.setData(productInfos);
				responseData.setMsg(msg);
			}
			responseData.setCode("200");
		} catch (Exception e) {
			e.printStackTrace();
			List<String> errors = new ArrayList<>();
			String msg = e.getMessage();
			errors.add(msg);
			responseData.setMsg(errors);
			responseData.setCode("-1");
		}
		logger.info("output 花费{}秒== {}", (System.currentTimeMillis() - st) / 1000, new Gson().toJson(responseData));
		return responseData;
	}
	@RequestMapping("/T09")
	ResponseData autoT09(@RequestBody String json) {
		logger.info("input ={}", json);
		long st = System.currentTimeMillis();
		ResponseData responseData = new ResponseData("200");
		try {
			JsonObject jsonRoot = new JsonParser().parse(json).getAsJsonObject();
			JsonArray jsonArray = jsonRoot.getAsJsonArray("json");
			List<ProductInfo> productInfos = new ArrayList<>();
			List<String> msg = new ArrayList<>();
			jsonArray.forEach(jo -> {
				ProductInfo productInfo = new Gson().fromJson(jo, new TypeToken<ProductInfo>() {
				}.getType());
				String processCode = productInfo.getProcessCode();
				String productLineCode = productInfo.getProductLine();
				String sn = productInfo.getSn();
				String result = productInfo.getResult();
				ProductLine productLine = productLineServiceFacade.findProductLineByCode(productLineCode);
				if (productLine == null) {
					msg.add("产线代码[" + productLineCode + "]不存在");
					productInfos.add(productInfo);
					return;
				}
				Process process = processServiceFacade.findProcessByCode(processCode);
				if (process == null) {
					msg.add("工站代码[" + processCode + "]不存在");
					productInfos.add(productInfo);
					return;
				}
				if ("T06".equalsIgnoreCase(processCode) || "T07".equalsIgnoreCase(processCode)
						|| "T08".equalsIgnoreCase(processCode) || "T09".equalsIgnoreCase(processCode)
						|| "T10".equalsIgnoreCase(processCode) || "T11".equalsIgnoreCase(processCode)
						|| processCode.startsWith("AT")) {
					//T06 WIFI测试
					if("T06".equalsIgnoreCase(processCode)) {
						if(sn.indexOf("_")>0) {
							String[] strings = sn.split("_");
							if(strings.length!=2) {
								msg.add("请输入一个MAC编码");
								productInfos.add(productInfo);
								return;	
							}
							sn=strings[0];
							String mac=strings[1];
							//查询产品ID
							Product product = productServiceFacadeImpl.findProductByCpsn(sn);
							if(null==product) {
								msg.add("产品SN["+sn+"]不存在");
								productInfos.add(productInfo);
								return;
							}
							Burn burn=new Burn();
							burn.setMac(mac);
							burn.setProductId(product.getId());
							PageInfo<Burn> query = burnService.query(burn,null,null, 1, 1);
							List<Burn> burnList = query.getList();
							if(burnList.size()==0) {
								msg.add("产品SN["+sn+"]与MAC["+mac+"]不匹配");
								productInfos.add(productInfo);
								return;
							}
						}else {
							msg.add("WIFI测试必须包含产品SN和MAC,用下划线分隔");
							productInfos.add(productInfo);
							return;
						}
					}
					Integer status = OK.equalsIgnoreCase(result) ? 0 : -1;
					Map data = productInfo.getData();
					String jsonData = null;
					if (data != null) {
						jsonData = new Gson().toJson(data);
					}
					String userName = productInfo.getName();
					if (StringUtils.isEmpty(userName)) {
						// productInfo.setResult(NG);
						msg.add("操作员不存在");
						productInfos.add(productInfo);
					} else {
						QaUser user = userServiceFacade.findQaUserByCode(userName);
						if (user == null) {
							// productInfo.setResult(NG);
							msg.add("操作员不存在");
							productInfos.add(productInfo);
						} else {
							ResponseMessage message = businessServiceFacade.processAuto(productLineCode, processCode,
									sn, status, user.getId(), "NG", jsonData);
							if (!"200".equalsIgnoreCase(message.getCode())) {
								// productInfo.setResult(NG);
								msg.add(message.getMsg());
								productInfos.add(productInfo);
							}
						}
					}
				} else {
					// productInfo.setResult(NG);
					msg.add("工站代码必须为T06,T07,T08,T09,T10,T11");
					productInfos.add(productInfo);
				}
			});
			if (!productInfos.isEmpty()) {
				responseData.setData(productInfos);
				responseData.setMsg(msg);
			}
			responseData.setCode("200");
		} catch (Exception e) {
			e.printStackTrace();
			List<String> errors = new ArrayList<>();
			String msg = e.getMessage();
			errors.add(msg);
			responseData.setMsg(errors);
			responseData.setCode("-1");
		}
		logger.info("output 花费{}秒== {}", (System.currentTimeMillis() - st) / 1000, new Gson().toJson(responseData));
		return responseData;
	}
	@RequestMapping("/T10")
	ResponseData autoT10(@RequestBody String json) {
		logger.info("input ={}", json);
		long st = System.currentTimeMillis();
		ResponseData responseData = new ResponseData("200");
		try {
			JsonObject jsonRoot = new JsonParser().parse(json).getAsJsonObject();
			JsonArray jsonArray = jsonRoot.getAsJsonArray("json");
			List<ProductInfo> productInfos = new ArrayList<>();
			List<String> msg = new ArrayList<>();
			jsonArray.forEach(jo -> {
				ProductInfo productInfo = new Gson().fromJson(jo, new TypeToken<ProductInfo>() {
				}.getType());
				String processCode = productInfo.getProcessCode();
				String productLineCode = productInfo.getProductLine();
				String sn = productInfo.getSn();
				String result = productInfo.getResult();
				ProductLine productLine = productLineServiceFacade.findProductLineByCode(productLineCode);
				if (productLine == null) {
					msg.add("产线代码[" + productLineCode + "]不存在");
					productInfos.add(productInfo);
					return;
				}
				Process process = processServiceFacade.findProcessByCode(processCode);
				if (process == null) {
					msg.add("工站代码[" + processCode + "]不存在");
					productInfos.add(productInfo);
					return;
				}
				if ("T06".equalsIgnoreCase(processCode) || "T07".equalsIgnoreCase(processCode)
						|| "T08".equalsIgnoreCase(processCode) || "T09".equalsIgnoreCase(processCode)
						|| "T10".equalsIgnoreCase(processCode) || "T11".equalsIgnoreCase(processCode)
						|| processCode.startsWith("AT")) {
					//T06 WIFI测试
					if("T06".equalsIgnoreCase(processCode)) {
						if(sn.indexOf("_")>0) {
							String[] strings = sn.split("_");
							if(strings.length!=2) {
								msg.add("请输入一个MAC编码");
								productInfos.add(productInfo);
								return;	
							}
							sn=strings[0];
							String mac=strings[1];
							//查询产品ID
							Product product = productServiceFacadeImpl.findProductByCpsn(sn);
							if(null==product) {
								msg.add("产品SN["+sn+"]不存在");
								productInfos.add(productInfo);
								return;
							}
							Burn burn=new Burn();
							burn.setMac(mac);
							burn.setProductId(product.getId());
							PageInfo<Burn> query = burnService.query(burn,null,null, 1, 1);
							List<Burn> burnList = query.getList();
							if(burnList.size()==0) {
								msg.add("产品SN["+sn+"]与MAC["+mac+"]不匹配");
								productInfos.add(productInfo);
								return;
							}
						}else {
							msg.add("WIFI测试必须包含产品SN和MAC,用下划线分隔");
							productInfos.add(productInfo);
							return;
						}
					}
					Integer status = OK.equalsIgnoreCase(result) ? 0 : -1;
					Map data = productInfo.getData();
					String jsonData = null;
					if (data != null) {
						jsonData = new Gson().toJson(data);
					}
					String userName = productInfo.getName();
					if (StringUtils.isEmpty(userName)) {
						// productInfo.setResult(NG);
						msg.add("操作员不存在");
						productInfos.add(productInfo);
					} else {
						QaUser user = userServiceFacade.findQaUserByCode(userName);
						if (user == null) {
							// productInfo.setResult(NG);
							msg.add("操作员不存在");
							productInfos.add(productInfo);
						} else {
							ResponseMessage message = businessServiceFacade.processAuto(productLineCode, processCode,
									sn, status, user.getId(), "NG", jsonData);
							if (!"200".equalsIgnoreCase(message.getCode())) {
								// productInfo.setResult(NG);
								msg.add(message.getMsg());
								productInfos.add(productInfo);
							}
						}
					}
				} else {
					// productInfo.setResult(NG);
					msg.add("工站代码必须为T06,T07,T08,T09,T10,T11");
					productInfos.add(productInfo);
				}
			});
			if (!productInfos.isEmpty()) {
				responseData.setData(productInfos);
				responseData.setMsg(msg);
			}
			responseData.setCode("200");
		} catch (Exception e) {
			e.printStackTrace();
			List<String> errors = new ArrayList<>();
			String msg = e.getMessage();
			errors.add(msg);
			responseData.setMsg(errors);
			responseData.setCode("-1");
		}
		logger.info("output 花费{}秒== {}", (System.currentTimeMillis() - st) / 1000, new Gson().toJson(responseData));
		return responseData;
	}
	@RequestMapping("/T11")
	ResponseData autoT11(@RequestBody String json) {
		logger.info("input ={}", json);
		long st = System.currentTimeMillis();
		ResponseData responseData = new ResponseData("200");
		try {
			JsonObject jsonRoot = new JsonParser().parse(json).getAsJsonObject();
			JsonArray jsonArray = jsonRoot.getAsJsonArray("json");
			List<ProductInfo> productInfos = new ArrayList<>();
			List<String> msg = new ArrayList<>();
			jsonArray.forEach(jo -> {
				ProductInfo productInfo = new Gson().fromJson(jo, new TypeToken<ProductInfo>() {
				}.getType());
				String processCode = productInfo.getProcessCode();
				String productLineCode = productInfo.getProductLine();
				String sn = productInfo.getSn();
				String result = productInfo.getResult();
				ProductLine productLine = productLineServiceFacade.findProductLineByCode(productLineCode);
				if (productLine == null) {
					msg.add("产线代码[" + productLineCode + "]不存在");
					productInfos.add(productInfo);
					return;
				}
				Process process = processServiceFacade.findProcessByCode(processCode);
				if (process == null) {
					msg.add("工站代码[" + processCode + "]不存在");
					productInfos.add(productInfo);
					return;
				}
				if ("T06".equalsIgnoreCase(processCode) || "T07".equalsIgnoreCase(processCode)
						|| "T08".equalsIgnoreCase(processCode) || "T09".equalsIgnoreCase(processCode)
						|| "T10".equalsIgnoreCase(processCode) || "T11".equalsIgnoreCase(processCode)
						|| processCode.startsWith("AT")) {
					//T06 WIFI测试
					if("T06".equalsIgnoreCase(processCode)) {
						if(sn.indexOf("_")>0) {
							String[] strings = sn.split("_");
							if(strings.length!=2) {
								msg.add("请输入一个MAC编码");
								productInfos.add(productInfo);
								return;	
							}
							sn=strings[0];
							String mac=strings[1];
							//查询产品ID
							Product product = productServiceFacadeImpl.findProductByCpsn(sn);
							if(null==product) {
								msg.add("产品SN["+sn+"]不存在");
								productInfos.add(productInfo);
								return;
							}
							Burn burn=new Burn();
							burn.setMac(mac);
							burn.setProductId(product.getId());
							PageInfo<Burn> query = burnService.query(burn,null,null, 1, 1);
							List<Burn> burnList = query.getList();
							if(burnList.size()==0) {
								msg.add("产品SN["+sn+"]与MAC["+mac+"]不匹配");
								productInfos.add(productInfo);
								return;
							}
						}else {
							msg.add("WIFI测试必须包含产品SN和MAC,用下划线分隔");
							productInfos.add(productInfo);
							return;
						}
					}
					Integer status = OK.equalsIgnoreCase(result) ? 0 : -1;
					Map data = productInfo.getData();
					String jsonData = null;
					if (data != null) {
						jsonData = new Gson().toJson(data);
					}
					String userName = productInfo.getName();
					if (StringUtils.isEmpty(userName)) {
						// productInfo.setResult(NG);
						msg.add("操作员不存在");
						productInfos.add(productInfo);
					} else {
						QaUser user = userServiceFacade.findQaUserByCode(userName);
						if (user == null) {
							// productInfo.setResult(NG);
							msg.add("操作员不存在");
							productInfos.add(productInfo);
						} else {
							ResponseMessage message = businessServiceFacade.processAuto(productLineCode, processCode,
									sn, status, user.getId(), "NG", jsonData);
							if (!"200".equalsIgnoreCase(message.getCode())) {
								// productInfo.setResult(NG);
								msg.add(message.getMsg());
								productInfos.add(productInfo);
							}
						}
					}
				} else {
					// productInfo.setResult(NG);
					msg.add("工站代码必须为T06,T07,T08,T09,T10,T11");
					productInfos.add(productInfo);
				}
			});
			if (!productInfos.isEmpty()) {
				responseData.setData(productInfos);
				responseData.setMsg(msg);
			}
			responseData.setCode("200");
		} catch (Exception e) {
			e.printStackTrace();
			List<String> errors = new ArrayList<>();
			String msg = e.getMessage();
			errors.add(msg);
			responseData.setMsg(errors);
			responseData.setCode("-1");
		}
		logger.info("output 花费{}秒== {}", (System.currentTimeMillis() - st) / 1000, new Gson().toJson(responseData));
		return responseData;
	}
	@RequestMapping("/auto")
	ResponseData auto(@RequestBody String json) {
		logger.info("input ={}", json);
		long st = System.currentTimeMillis();
		ResponseData responseData = new ResponseData("200");
		try {
			JsonObject jsonRoot = new JsonParser().parse(json).getAsJsonObject();
			JsonArray jsonArray = jsonRoot.getAsJsonArray("json");
			List<ProductInfo> productInfos = new ArrayList<>();
			List<String> msg = new ArrayList<>();
			jsonArray.forEach(jo -> {
				ProductInfo productInfo = new Gson().fromJson(jo, new TypeToken<ProductInfo>() {
				}.getType());
				String processCode = productInfo.getProcessCode();
				String productLineCode = productInfo.getProductLine();
				String sn = productInfo.getSn();
				String result = productInfo.getResult();
				ProductLine productLine = productLineServiceFacade.findProductLineByCode(productLineCode);
				if (productLine == null) {
					msg.add("产线代码[" + productLineCode + "]不存在");
					productInfos.add(productInfo);
					return;
				}
				Process process = processServiceFacade.findProcessByCode(processCode);
				if (process == null) {
					msg.add("工站代码[" + processCode + "]不存在");
					productInfos.add(productInfo);
					return;
				}
				if ("T06".equalsIgnoreCase(processCode) || "T07".equalsIgnoreCase(processCode)
						|| "T08".equalsIgnoreCase(processCode) || "T09".equalsIgnoreCase(processCode)
						|| "T10".equalsIgnoreCase(processCode) || "T11".equalsIgnoreCase(processCode)
						|| processCode.startsWith("AT")) {
					//T06 WIFI测试
					if("T06".equalsIgnoreCase(processCode)) {
						if(sn.indexOf("_")>0) {
							String[] strings = sn.split("_");
							if(strings.length!=2) {
								msg.add("请输入一个MAC编码");
								productInfos.add(productInfo);
								return;	
							}
							sn=strings[0];
							String mac=strings[1];
							//查询产品ID
							Product product = productServiceFacadeImpl.findProductByCpsn(sn);
							if(null==product) {
								msg.add("产品SN["+sn+"]不存在");
								productInfos.add(productInfo);
								return;
							}
							Burn burn=new Burn();
							burn.setMac(mac);
							burn.setProductId(product.getId());
							PageInfo<Burn> query = burnService.query(burn,null,null, 1, 1);
							List<Burn> burnList = query.getList();
							if(burnList.size()==0) {
								msg.add("产品SN["+sn+"]与MAC["+mac+"]不匹配");
								productInfos.add(productInfo);
								return;
							}
						}else {
							msg.add("WIFI测试必须包含产品SN和MAC,用下划线分隔");
							productInfos.add(productInfo);
							return;
						}
					}
					Integer status = OK.equalsIgnoreCase(result) ? 0 : -1;
					Map data = productInfo.getData();
					String jsonData = null;
					if (data != null) {
						jsonData = new Gson().toJson(data);
					}
					String userName = productInfo.getName();
					if (StringUtils.isEmpty(userName)) {
						// productInfo.setResult(NG);
						msg.add("操作员不存在");
						productInfos.add(productInfo);
					} else {
						QaUser user = userServiceFacade.findQaUserByCode(userName);
						if (user == null) {
							// productInfo.setResult(NG);
							msg.add("操作员不存在");
							productInfos.add(productInfo);
						} else {
							ResponseMessage message = businessServiceFacade.processAuto(productLineCode, processCode,
									sn, status, user.getId(), "NG", jsonData);
							if (!"200".equalsIgnoreCase(message.getCode())) {
								// productInfo.setResult(NG);
								msg.add(message.getMsg());
								productInfos.add(productInfo);
							}
						}
					}
				} else {
					// productInfo.setResult(NG);
					msg.add("工站代码必须为T06,T07,T08,T09,T10,T11");
					productInfos.add(productInfo);
				}
			});
			if (!productInfos.isEmpty()) {
				responseData.setData(productInfos);
				responseData.setMsg(msg);
			}
			responseData.setCode("200");
		} catch (Exception e) {
			e.printStackTrace();
			List<String> errors = new ArrayList<>();
			String msg = e.getMessage();
			errors.add(msg);
			responseData.setMsg(errors);
			responseData.setCode("-1");
		}
		logger.info("output 花费{}秒== {}", (System.currentTimeMillis() - st) / 1000, new Gson().toJson(responseData));
		return responseData;
	}

	/**
	 * 邦板烧录对接
	 * 
	 * @param burn
	 * @return
	 */
	@PostMapping("/burn")
	public Result burn(@RequestBody Burn burn) {
		if (burn == null) {
			return new Result(1, "参数不能为空");
		}
		if (burn.getName() == null || burn.getName().trim().isEmpty()) {
			return new Result(1, "测试人不能为空");
		}
		if (burn.getVersion() == null || burn.getVersion().trim().isEmpty()) {
			return new Result(1, "版本信息不能为空");
		}
		if (burn.getMac() == null || burn.getMac().trim().isEmpty()) {
			return new Result(1, "邦板MAC不能为空");
		}
		if (burn.getSn() == null || burn.getSn().trim().isEmpty()) {
			return new Result(1, "邦板SN不能为空");
		}
		if (!burn.getSn().matches(BusinessServiceFacadeImpl.BBSN_REG)) {
			return new Result(1, "邦板SN[" + burn.getSn() + "]格式不正确");
		}
		burn.setCreateTime(new Date());
		int tatal = burnService.inser(burn);
		if (tatal > 0) {
			Result result = new Result();
			result.setCode(0);
			return result;
		} else {
			//重复烧录
			burnService.reBurn(burn);
			return new Result(0, "邦板SN[" + burn.getSn() + "]重新烧录完成");
		}
	}

	
	/**
	 * 告知条码打印系统产品sn是否走完全部流程
	 * @param sn
	 * @return
	 */
	@RequestMapping("/isFinish")
	public CodePrintResult isFinsh(String sn) {
		CodePrintResult codePrintResult=new CodePrintResult();
		Product product = productServiceFacadeImpl.findProductByCpsn(sn);
		if(null==product) {
			return null;
		}
		ProcessRecord processRecord = processRecordServiceFacadeImpl.findProcessRecord(product.getId(), "T13", 0);
		if(null==processRecord) {
			codePrintResult.setStatus(0);
		}else {
			codePrintResult.setPo(product.getSheetPo());
			codePrintResult.setStatus(product.getValid());
			codePrintResult.setProductLine(processRecord.getProductLine());
		}
		return codePrintResult;
	}
}
