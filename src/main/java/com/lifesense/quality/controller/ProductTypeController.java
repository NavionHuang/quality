package com.lifesense.quality.controller;

import com.github.pagehelper.PageInfo;
import com.lifesense.quality.config.SnowflakeIdWorker;
import com.lifesense.quality.domain.ProductType;
import com.lifesense.quality.facade.ProductTypeServiceFacadeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 赵春定 on 2017/9/13.
 */
@Controller
@RequestMapping("/product_type")
public class ProductTypeController {

    @Autowired
    private ProductTypeServiceFacadeImpl productTypeServiceFacade;

    @Autowired
    private SnowflakeIdWorker worker;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    ModelAndView flowList() {
        ModelAndView view = new ModelAndView();
        return view;
    }

    @RequestMapping(value = "/list_data", method = RequestMethod.POST)
    @ResponseBody
    Page listData(@RequestParam(name = "page", defaultValue = "1") int page, @RequestParam(name = "limit", defaultValue = "10") int limit, ProductType entity) {
        PageInfo<ProductType> pageData = productTypeServiceFacade.getPageData(entity,  page,limit);
        return new Page("200", "查询成功", pageData.getTotal(), pageData.getList());
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    ModelAndView add() {
        ModelAndView view = new ModelAndView();
        return view;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    ModelAndView edit(Long id) {
        ModelAndView view = new ModelAndView();
        ProductType productType = productTypeServiceFacade.findProductTypeById(id);
        view.addObject("productType", productType);
        return view;
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    ResponseMessage save(ProductType productType) {
        String code = productType.getCode();
        ProductType oldProductType = productTypeServiceFacade.findProductTypeByCode(code);
        if (oldProductType != null && (productType.getId() == null || !oldProductType.getId().equals(productType.getId()))) {
            productType.setId(oldProductType.getId());
            productType.setCode(oldProductType.getCode());
        }
        productType.setValid(0);
        int result = productTypeServiceFacade.saveOrUpdate(productType);
        return new ResponseMessage("200", "保存成功");
    }


}
