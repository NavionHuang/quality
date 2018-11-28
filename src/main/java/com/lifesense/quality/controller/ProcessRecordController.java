package com.lifesense.quality.controller;

import com.github.pagehelper.PageInfo;
import com.lifesense.quality.config.security.SecurityUser;
import com.lifesense.quality.domain.Process;
import com.lifesense.quality.domain.ProcessRecord;
import com.lifesense.quality.domain.ProductLine;
import com.lifesense.quality.domain.QaUser;
import com.lifesense.quality.facade.ProcessRecordServiceFacadeImpl;
import com.lifesense.quality.facade.ProcessServiceFacadeImpl;
import com.lifesense.quality.facade.ProductLineServiceFacadeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
@RequestMapping("/process_record")
@Controller
public class ProcessRecordController {

    @Autowired
    private ProcessRecordServiceFacadeImpl processRecordServiceFacade;
    @Autowired
    private ProductLineServiceFacadeImpl productLineServiceFacade;
    @Autowired
    private ProcessServiceFacadeImpl processServiceFacade;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    ModelAndView testList() {
        ModelAndView view = new ModelAndView();
        List<ProductLine> productLines = productLineServiceFacade.findAll();
        view.addObject("productLines", productLines);
        List<Process> processes = processServiceFacade.findValidProcess(0);
        view.addObject("processes", processes);
        return view;
    }

    @RequestMapping(value = "/list_data", method = RequestMethod.POST)
    @ResponseBody
    Page listData(@RequestParam(name = "page", defaultValue = "1") int page, @RequestParam(name = "limit", defaultValue = "10") int limit, ProcessRecord entity) {
        SecurityUser userDetails = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (userDetails.getUser() != null) {
            QaUser user = userDetails.getUser();
            if (user.getProcessSign()!=1) {
                entity.setProductLine(user.getLineCode());
            }
        }
        PageInfo<ProcessRecord> pageData = processRecordServiceFacade.getPageData(entity,page,limit);
        return new Page("200", "查询成功",pageData.getTotal(),pageData.getList());
    }

}
