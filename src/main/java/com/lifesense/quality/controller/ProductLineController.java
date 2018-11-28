package com.lifesense.quality.controller;

import com.github.pagehelper.PageInfo;
import com.lifesense.quality.domain.ProductLine;
import com.lifesense.quality.facade.ProductLineServiceFacadeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 赵春定 on 2017/9/19.
 */
@Controller
@RequestMapping("/product_line")
public class ProductLineController {

    @Autowired
    private ProductLineServiceFacadeImpl productLineServiceFacade;


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    ModelAndView productList() {
        ModelAndView view = new ModelAndView();
        return view;
    }

    @RequestMapping(value = "/list_data", method = RequestMethod.POST)
    @ResponseBody
    Page listData(@RequestParam(name = "page", defaultValue = "1") int page, @RequestParam(name = "limit", defaultValue = "10") int limit, ProductLine entity) {
        PageInfo<ProductLine> pageData = productLineServiceFacade.getPageData(entity, page, limit);
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
        ProductLine productLine = productLineServiceFacade.findById(id);
        view.addObject("productLine", productLine);
        return view;
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    ResponseMessage save(ProductLine productLine) {
        String code = productLine.getCode();
        ProductLine oldProductLine = productLineServiceFacade.findProductLineByCode(code);
        if (oldProductLine != null && (productLine.getId() == null || !oldProductLine.getId().equals(productLine.getId()))) {
            return new ResponseMessage("-1", "线别代码已存在");
        }
        if (productLine.getValid() == null) {
            productLine.setValid(0);
        }
        int result = productLineServiceFacade.saveOrUpdate(productLine);
        return new ResponseMessage("200", "保存成功");
    }


}
