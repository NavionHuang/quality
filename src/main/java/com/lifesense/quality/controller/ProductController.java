package com.lifesense.quality.controller;

import com.github.pagehelper.PageInfo;
import com.lifesense.quality.domain.ProcessRecord;
import com.lifesense.quality.domain.Product;
import com.lifesense.quality.facade.ProcessRecordServiceFacadeImpl;
import com.lifesense.quality.facade.ProductServiceFacadeImpl;
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
@RequestMapping("/product")
@Controller
public class ProductController {

    @Autowired
    private ProductServiceFacadeImpl productServiceFacade;
    @Autowired
    private ProcessRecordServiceFacadeImpl processRecordServiceFacade;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    ModelAndView productList() {
        ModelAndView view = new ModelAndView();
        return view;
    }

    @RequestMapping(value = "/list_data", method = RequestMethod.POST)
    @ResponseBody
    Page listData(@RequestParam(name = "page", defaultValue = "1") int page, @RequestParam(name = "limit", defaultValue = "10") int limit, Product entity) {
        PageInfo<Product> pageData = productServiceFacade.getPageData(entity,page,limit);
        return new Page("200", "查询成功", pageData.getTotal(), pageData.getList());
    }


    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    ModelAndView sheetProductList(Long id) {
        ModelAndView view = new ModelAndView();
        Product product = productServiceFacade.findProductById(id);
        List<ProcessRecord> processRecords = processRecordServiceFacade.findProcessRecord(id);
        view.addObject("product", product);
        view.addObject("processRecords", processRecords);
        return view;
    }


}
