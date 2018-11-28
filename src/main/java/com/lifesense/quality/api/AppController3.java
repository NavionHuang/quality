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
import com.lifesense.quality.domain.SnInfo;
import com.lifesense.quality.facade.BusinessServiceFacadeImpl;
import com.lifesense.quality.facade.ProcessRecordServiceFacadeImpl;
import com.lifesense.quality.facade.ProcessServiceFacadeImpl;
import com.lifesense.quality.facade.ProductLineServiceFacadeImpl;
import com.lifesense.quality.facade.ProductServiceFacadeImpl;
import com.lifesense.quality.facade.QaUserServiceFacadeImpl;
import com.lifesense.quality.facade.SnInfoServiceFacadeImpl;
import com.lifesense.quality.service.BurnService;
import com.lifesense.quality.domain.Burn;


import org.codehaus.groovy.runtime.StringGroovyMethods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
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
@RequestMapping("/api/v3")
public class AppController3 {

	@Autowired
	private ProductServiceFacadeImpl productServiceFacadeImpl;
	@Autowired
	private SnInfoServiceFacadeImpl snInfoServiceFacadeImpl;
	@Autowired
	private ProcessRecordServiceFacadeImpl processRecordServiceFacadeImpl;

	/**
	 * 根据产品SN查询产品信息
	 * 
	 * @param 产品sn
	 * @return
	 */
	@RequestMapping("/queryProductByCpsn")
	public Product queryProductBySN(String cpsn) {
		if (!StringUtils.isEmpty(cpsn)) {
			Product product = productServiceFacadeImpl.findProductByCpsn(cpsn);
			return product;
		} else {
			return null;
		}
	}
	/**
	 * 根据玻璃SN查询产品创建时间
	 * 
	 * @param blsn
	 * @return
	 */
	@RequestMapping("/queryProductCreateByBlsn")
	public String queryProductCreateByBlsn(String blsn) {
		if (!StringUtils.isEmpty(blsn)) {
			Product product = productServiceFacadeImpl.findProductByBlsn(blsn);
			if(null!=product) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				return sdf.format(product.getCreateTime());
			}
		}
		return null;
	}
	/**
	 * 根据产品ID查询产品绑定物料
	 * 
	 * @param 产品sn
	 * @return
	 */
	@RequestMapping("/querySnInfo")
	public List<SnInfo> querySnInfo(Long id) {
		if (null != id) {
			List<Long> ids = new ArrayList<>();
			ids.add(id);
			return snInfoServiceFacadeImpl.findByIds(ids, null);
		} else {
			return null;
		}
	}

	/**
	 * 根据产品创建时间查询产品
	 * 
	 * @param 产品sn
	 * @return
	 */
	@RequestMapping("/queryProductByCreateTime")
	public Product queryProductByCreateTime(String createTime) {
		if (!StringUtils.isEmpty(createTime)) {
			return productServiceFacadeImpl.findProductByCreateTime(createTime);
		} else {
			return null;
		}

	}
	/**
	 * 根据产品ID查询产品操作记录
	 * 
	 * @param 产品sn
	 * @return
	 */
	@RequestMapping("/queryProductById")
	public List<ProcessRecord> queryProductById(Long id) {
		if (null!=id) {
			return processRecordServiceFacadeImpl.findProcessRecord(id);
		} else {
			return null;
		}

	}


}
