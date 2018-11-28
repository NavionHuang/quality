package com.lifesense.quality.controller;

import com.github.pagehelper.PageInfo;
import com.lifesense.quality.domain.Process;
import com.lifesense.quality.domain.ProcessFlow;
import com.lifesense.quality.domain.ProductType;
import com.lifesense.quality.facade.ProcessFlowServiceFacadeImpl;
import com.lifesense.quality.facade.ProcessServiceFacadeImpl;
import com.lifesense.quality.facade.ProductTypeServiceFacadeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by 赵春定 on 2017/8/30.
 */
@RequestMapping("/flow")
@Controller
public class FlowController {

    @Autowired
    private ProcessFlowServiceFacadeImpl processFlowServiceFacade;
    @Autowired
    private ProcessServiceFacadeImpl processServiceFacade;
    @Autowired
    private ProductTypeServiceFacadeImpl productTypeServiceFacade;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    ModelAndView flowList() {
        ModelAndView view = new ModelAndView();
        List<Process> processList = processServiceFacade.findValidProcess(0);
        view.addObject("processList", processList);
        List<ProductType> productTypeList = productTypeServiceFacade.findValidProductType();
        view.addObject("productTypeList", productTypeList);
        return view;
    }

    @RequestMapping(value = "/list_data", method = RequestMethod.POST)
    @ResponseBody
    Page listData(@RequestParam(name = "page", defaultValue = "1") int page, @RequestParam(name = "limit", defaultValue = "10") int limit, String productTypeCode) {
        ProductType productType = new ProductType();
        productType.setCode(productTypeCode);
        PageInfo<ProductType> pageData = productTypeServiceFacade.getPageData(productType, page, limit);
        List<ProductType> productTypes = pageData.getList();
        List<Map<String, Object>> data = new ArrayList<>();
        productTypes.forEach(t -> {
            Map<String, Object> map = new HashMap<>();
            String code = t.getCode();
            map.put("productTypeId", t.getId());
            map.put("productType", code);
            map.put("productName", t.getName());
            List<ProcessFlow> processFlows = processFlowServiceFacade.queryFlowListByProductTypeCode(code);
            processFlows.stream().sorted((f1, f2) -> {
                String processCode = f1.getProcessCode();
                String nextProcessCode = f2.getNextProcessCode();
                if (StringUtils.isEmpty(nextProcessCode)) {
                    return -1;
                } else if (processCode.equalsIgnoreCase(nextProcessCode)) {
                    return 1;
                } else {
                    return -1;
                }
            });
            map.put("flowList", processFlows);
            data.add(map);
        });
        return new Page("200", "查询成功", pageData.getTotal(), data);
    }


    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    ModelAndView edit(Long productTypeId) {
        ModelAndView view = new ModelAndView();
        ProductType productType = productTypeServiceFacade.findProductTypeById(productTypeId);
        view.addObject("productType", productType);
        /*
        List<Process> processList = processServiceFacade.findValidProcess(0);
        view.addObject("processList", processList);
        List<Process> repairProcessList = processServiceFacade.findValidProcess(1);
        view.addObject("repairProcessList", repairProcessList);
        */
        List<Process> processList = processServiceFacade.findAll();
        view.addObject("processes", processList);
        Map<String, Process> processMap = new HashMap<>();
        view.addObject("processMap", processMap);
        processList.forEach(p->{processMap.put(p.getCode(),p);});
        List<ProcessFlow> flowList = processFlowServiceFacade.queryFlowListByProductTypeCode(productType.getCode());
        view.addObject("flows", flowList);
        return view;
    }

    /**
     * 保存用户，返还0成功，1不成功
     *
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    ResponseMessage save(@RequestBody ProcessFlow[] flowList) {
        ResponseMessage response = new ResponseMessage("200", "保存成功");
        if (flowList != null && flowList.length > 0) {
            String productTypeCode = flowList[0].getProductTypeCode();
            processFlowServiceFacade.deleteFlowByType(productTypeCode);
            processFlowServiceFacade.batchSaveFlow(Arrays.asList(flowList));
            response.setCode("200");
        } else {
            response.setCode("-1");
            response.setMsg("请添加流程工序");
        }
        return response;
    }
}
