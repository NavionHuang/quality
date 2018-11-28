package com.lifesense.quality.controller;

import com.github.pagehelper.PageInfo;
import com.lifesense.quality.domain.Process;
import com.lifesense.quality.domain.ProductLine;
import com.lifesense.quality.domain.SysLog;
import com.lifesense.quality.facade.ProcessServiceFacadeImpl;
import com.lifesense.quality.facade.ProductLineServiceFacadeImpl;
import com.lifesense.quality.facade.SysLogServiceFacadeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by 赵春定 on 2017/10/19.
 */
@Controller
@RequestMapping("/syslog")
public class SysLogController {

    @Autowired
    private SysLogServiceFacadeImpl sysLogServiceFacade;
    @Autowired
    private ProcessServiceFacadeImpl processServiceFacade;
    @Autowired
    private ProductLineServiceFacadeImpl productLineServiceFacade;

    /**
     * 用户列表页面
     *
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    ModelAndView List() {
        ModelAndView view = new ModelAndView();
        List<ProductLine> productLines = productLineServiceFacade.findAll();
        List<Process> processes = processServiceFacade.findAll();
        view.addObject("productLines", productLines);
        view.addObject("processes", processes);
        return view;
    }

    /**
     * @return
     */
    @RequestMapping(value = "/list_data", method = RequestMethod.POST)
    @ResponseBody
    Page listData(@RequestParam(name = "page", defaultValue = "1") int page, @RequestParam(name = "limit", defaultValue = "10") int limit, SysLog entity) {
        PageInfo<SysLog> pageData = sysLogServiceFacade.getPageData(entity,page,limit);
        return new Page("200", "查询成功", pageData.getTotal(), pageData.getList());
    }
}
