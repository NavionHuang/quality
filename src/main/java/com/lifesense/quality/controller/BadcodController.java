package com.lifesense.quality.controller;

import com.github.pagehelper.PageInfo;
import com.lifesense.quality.domain.BadCode;
import com.lifesense.quality.domain.Process;
import com.lifesense.quality.facade.BadcodeServiceFacadeImpl;
import com.lifesense.quality.facade.ProcessServiceFacadeImpl;
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
@RequestMapping("/badcod")
@Controller
public class BadcodController {

    @Autowired
    private BadcodeServiceFacadeImpl badcodeServiceFacade;
    @Autowired
    private ProcessServiceFacadeImpl processServiceFacade;


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    ModelAndView badcodList() {
        ModelAndView view = new ModelAndView();
        List<Process> processList = processServiceFacade.findValidProcess(0);
        view.addObject("processList", processList);
        return view;
    }

    @RequestMapping(value = "/list_data", method = RequestMethod.POST)
    @ResponseBody
    Page listData(@RequestParam(name = "page", defaultValue = "1") int page, @RequestParam(name = "limit", defaultValue = "10") int limit, BadCode entity) {
        PageInfo<BadCode> pageData = badcodeServiceFacade.getPageData(entity,page,limit);
        return new Page("200", "查询成功",pageData.getTotal(),pageData.getList());
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    ModelAndView add() {
        ModelAndView view = new ModelAndView();
        List<Process> processList = processServiceFacade.findValidProcess(0);
        view.addObject("processList", processList);
        return view;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    ModelAndView edit(Long id) {
        ModelAndView view = new ModelAndView();
        List<Process> processList = processServiceFacade.findValidProcess(0);
        view.addObject("processList", processList);
        BadCode badCode = badcodeServiceFacade.findBadcodById(id);
        view.addObject("badCode", badCode);
        return view;
    }

    /**
     * 保存用户，返还0成功，1不成功
     *
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    ResponseMessage save(BadCode entity) {
        int result = 0;
        String processCode = entity.getProcessCode();
        String code = entity.getCode();
        BadCode badCode = badcodeServiceFacade.findBadcodeByCode(processCode, code);
        Long id = entity.getId();
        if (id == null) {
            if (badCode != null) {
                return new ResponseMessage("-1", "工站已存在不良代码");
            } else {
                entity.setValid(0);
                result = badcodeServiceFacade.saveOrUpdate(entity);
               return new ResponseMessage("200", "保存成功");
            }
        } else {
            if (badCode != null && badCode.getId().longValue() != id.longValue()) {
                return new ResponseMessage("-1", "工站已存在不良代码");
            } else {
                BadCode oldBadCode = badcodeServiceFacade.findBadcodById(id);
                entity.setCode(oldBadCode.getCode());
                result = badcodeServiceFacade.saveOrUpdate(entity);
                return new ResponseMessage("200", "保存成功");
            }
        }
    }
}
