package com.lifesense.quality.controller;

import com.github.pagehelper.PageInfo;
import com.lifesense.quality.config.SnowflakeIdWorker;
import com.lifesense.quality.domain.Process;
import com.lifesense.quality.facade.ProcessServiceFacadeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 赵春定 on 2017/8/30.
 */
@RequestMapping("/process")
@Controller
public class ProcessController {


    @Autowired
    private ProcessServiceFacadeImpl processServiceFacade;

    @Autowired
    private SnowflakeIdWorker worker;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    ModelAndView processList() {
        ModelAndView view = new ModelAndView();
        return view;
    }

    @RequestMapping(value = "/list_data", method = RequestMethod.POST)
    @ResponseBody
    Page listData(@RequestParam(name = "page", defaultValue = "1") int page, @RequestParam(name = "limit", defaultValue = "10") int limit, Process entity) {
        PageInfo<Process> pageData = processServiceFacade.getPageData(entity,page,limit);
        return new Page("200", "查询成功",pageData.getTotal(),pageData.getList());
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    ModelAndView add() {
        ModelAndView view = new ModelAndView();
        return view;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    ModelAndView edit(Long id) {
        ModelAndView view = new ModelAndView();
        Process Process = processServiceFacade.findProcessById(id);
        view.addObject("process", Process);
        return view;
    }

    /**
     * 保存用户，返还0成功，1不成功
     *
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    ResponseMessage save(Process process) {
        int result = 0;
        String code = process.getCode();
        Long id = process.getId();
        Process oldProcess = processServiceFacade.findProcessByCode(code);
        if (id == null) {
            if (oldProcess != null) {
                return new ResponseMessage("-1", "已存在工站代码");
            } else {
                 oldProcess  = processServiceFacade.findProcessByName(process.getName());
                if (oldProcess != null) {
                    return new ResponseMessage("-1", "已存在工站名称");
                }else {
                    process.setValid(0);
                    result = processServiceFacade.saveOrUpdate(process);
                    return new ResponseMessage("200", "保存成功");
                }
            }
        } else {
            if (oldProcess != null && oldProcess.getId().longValue() != id.longValue()) {
                return new ResponseMessage("-1", "已存在工站代码");
            } else {
                oldProcess  = processServiceFacade.findProcessByName(process.getName());
                if (oldProcess != null && oldProcess.getId().longValue() != id.longValue()) {
                    return new ResponseMessage("-1", "已存在工站名称");
                }else {
                    result = processServiceFacade.saveOrUpdate(process);
                    return new ResponseMessage("200", "保存成功");
                }
            }
        }
    }


}
