package com.lifesense.quality.controller;

import com.github.pagehelper.PageInfo;
import com.lifesense.quality.domain.BadCode;
import com.lifesense.quality.domain.Bom;
import com.lifesense.quality.domain.Process;
import com.lifesense.quality.domain.ProductType;
import com.lifesense.quality.facade.BomServiceFacadeImpl;
import com.lifesense.quality.facade.ProductTypeServiceFacadeImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by 赵春定 on 2017/8/30.
 */
@RequestMapping("/bom")
@Controller
public class BomController {

	@Autowired
	private BomServiceFacadeImpl bomServiceFacade;
	@Autowired
	private ProductTypeServiceFacadeImpl productTypeServiceFacade;

	@RequestMapping(value = "/list_data", method = RequestMethod.POST)
	@ResponseBody
	Page listData(@RequestParam(name = "page", defaultValue = "1") int page,
			@RequestParam(name = "limit", defaultValue = "10") int limit, Bom entity) {
		PageInfo<Bom> pageData = bomServiceFacade.getPageData(entity, page, limit);
		return new Page("200", "查询成功", pageData.getTotal(), pageData.getList());
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	ModelAndView add() {
		ModelAndView view = new ModelAndView();
		List<ProductType> ProductTypes = productTypeServiceFacade.findValidProductType();
		view.addObject("ProductTypes", ProductTypes);
		return view;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	ModelAndView edit(Long id) {
		ModelAndView view = new ModelAndView();
		List<ProductType> ProductTypes = productTypeServiceFacade.findValidProductType();
		view.addObject("ProductTypes", ProductTypes);
		Bom bom = bomServiceFacade.findBadcodById(id);
		view.addObject("bom", bom);
		return view;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	ModelAndView badcodList() {
		ModelAndView view = new ModelAndView();
		List<ProductType> ProductTypes = productTypeServiceFacade.findValidProductType();
		view.addObject("ProductTypes", ProductTypes);
		return view;
	}

	/**
	 * 保存用户，返还0成功，1不成功
	 *
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	ResponseMessage save(Bom entity) {
		int result = 0;
		String productTypeCode = entity.getProductTypeCode();
		String code = entity.getCode();
		String name = entity.getName();
		Bom bom = bomServiceFacade.findBomByExample(productTypeCode, name, code);
		Long id = entity.getId();
		if (id == null) {
			if (bom != null) {
				return new ResponseMessage("-1", "该产品类型已存在相同物料条码");
			} else {
				result = bomServiceFacade.saveOrUpdate(entity);
				return new ResponseMessage("200", "保存成功");
			}
		} else {
			if (bom != null && bom.getId().longValue() != id.longValue()) {
				return new ResponseMessage("-1", "该产品类型已存在相同物料条码");
			} else {
				result = bomServiceFacade.saveOrUpdate(entity);
				return new ResponseMessage("200", "保存成功");
			}
		}

	}
}
