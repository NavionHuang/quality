package com.lifesense.quality.controller;

import com.github.pagehelper.PageInfo;
import com.lifesense.quality.config.security.SecurityUser;
import com.lifesense.quality.domain.Process;
import com.lifesense.quality.domain.ProductLine;
import com.lifesense.quality.domain.QaUser;
import com.lifesense.quality.facade.ProcessServiceFacadeImpl;
import com.lifesense.quality.facade.ProductLineServiceFacadeImpl;
import com.lifesense.quality.facade.QaUserServiceFacadeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by 赵春定 on 2017/8/30.
 */
@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private QaUserServiceFacadeImpl qaUserServiceFacade;

    @Autowired
    private ProcessServiceFacadeImpl processServiceFacade;

    @Autowired
    private ProductLineServiceFacadeImpl productLineServiceFacade;

    @Autowired
    private Md5PasswordEncoder passwordEncoder;


    /**
     * 用户列表页面
     *
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    ModelAndView userList() {
        ModelAndView view = new ModelAndView();
        List<Process> processList = processServiceFacade.findValidProcess(0);
        view.addObject("processList", processList);
        return view;
    }

    /**
     * 用户列表数据
     *
     * @return
     */
    @RequestMapping(value = "/list_data", method = RequestMethod.POST)
    @ResponseBody
    Page listData(@RequestParam(name = "page", defaultValue = "1") int page, @RequestParam(name = "limit", defaultValue = "10") int limit, QaUser entity) {
        SecurityUser userDetails = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (userDetails.getUser() != null) {
            QaUser user = userDetails.getUser();
            if (user.getProcessSign()!=0) {
                entity.setCreateUserId(user.getId());
            }
        }
        PageInfo<QaUser> pageData = qaUserServiceFacade.getPageData(entity, page, limit);
        return new Page("200", "查询成功", pageData.getTotal(), pageData.getList());
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    ModelAndView addUser() {
        ModelAndView view = new ModelAndView();
        List<Process> processList = processServiceFacade.findValidProcess(0);
        SecurityUser userDetails = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        QaUser user = userDetails.getUser();
        List<ProductLine> lines = null;
        if (3 == user.getProcessSign()) {
            //组长
            ProductLine line = productLineServiceFacade.findProductLineByCode(user.getLineCode());
            lines = Arrays.asList(line);
        } else {
            lines = productLineServiceFacade.findAll();
        }
        view.addObject("lines", lines);
        //List<Process> repairProcessList = processServiceFacade.findValidProcess(1);
        view.addObject("processList", processList);
        //view.addObject("repairProcessList", repairProcessList);
        return view;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    ModelAndView editUser(Long id) {
        ModelAndView view = new ModelAndView();
        //查找用户
        SecurityUser userDetails = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        QaUser user = userDetails.getUser();
        List<ProductLine> lines = null;
        if (3 == user.getProcessSign()) {
            //组长
            ProductLine line = productLineServiceFacade.findProductLineByCode(user.getLineCode());
            lines = Arrays.asList(line);
        } else {
            lines = productLineServiceFacade.findAll();
        }
        view.addObject("lines", lines);
        QaUser qaUser = qaUserServiceFacade.findQaUserById(id);
        view.addObject("user", qaUser);
        List<Process> processList = processServiceFacade.findValidProcess(0);
        // List<Process> repairProcessList = processServiceFacade.findValidProcess(1);
        view.addObject("processList", processList);
        // view.addObject("repairProcessList", repairProcessList);
        return view;
    }

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ResponseBody
    ResponseMessage delUser(Long id) {
        QaUser qaUser = new QaUser();
        qaUser.setId(id);
        qaUser.setValid(1);
        qaUser.setModifyTime(new Date());
        int i = qaUserServiceFacade.saveOrUpdate(qaUser);
        return i > 0 ? new ResponseMessage("200", "删除成功") : new ResponseMessage("-1", "删除失败");
    }

    /**
     * 保存用户，返还0成功，1不成功
     *
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    ResponseMessage saveUser(QaUser qaUser) {
        if (qaUser.getId() == null) {
            if (StringUtils.isEmpty(qaUser.getCode())) {
                return new ResponseMessage("-1", "请输入工号");
            }
            String code = qaUser.getCode();
            QaUser oldUser = qaUserServiceFacade.findQaUserByCode(code);
            if (oldUser != null && oldUser.getValid() == 0) {
                return new ResponseMessage("-1", "工号已存在");
            } else if (oldUser != null) {
                qaUser.setId(oldUser.getId());
            }
            if (qaUser.getProcessSign() == 0 && StringUtils.isEmpty(qaUser.getProcessCode())) {
                return new ResponseMessage("-1", "请选择站别");
            } else if (qaUser.getProcessSign() != 0 ){
                qaUser.setProcessCode(null);
            }
            if (qaUser.getProcessSign() != 1 && StringUtils.isEmpty(qaUser.getLineCode())) {
                return new ResponseMessage("-1", "请选择产线");
            }
            SecurityUser userDetails = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            qaUser.setCreateUserId(userDetails.getUser().getId());
            //新增
            qaUser.setAccount(qaUser.getCode());
            qaUser.setCreateTime(new Date());
            qaUser.setModifyTime(new Date());
            String defaultPassword = "123456";
            qaUser.setPassword(passwordEncoder.encodePassword(defaultPassword, null));
        } else {
            Long id = qaUser.getId();
            QaUser user = qaUserServiceFacade.findQaUserById(id);
            if (qaUser.getPassword() != null) {
                qaUser.setPassword(passwordEncoder.encodePassword(qaUser.getPassword(), null));
            }
            if (qaUser.getProcessSign() == 0 && StringUtils.isEmpty(qaUser.getProcessCode())) {
                return new ResponseMessage("-1", "请选择站别");
            } else if (qaUser.getProcessSign() != 0 ){
                qaUser.setProcessCode(null);
            }
            if (qaUser.getProcessSign() != 1 && StringUtils.isEmpty(qaUser.getLineCode())) {
                return new ResponseMessage("-1", "请选择产线");
            }
            qaUser.setModifyTime(new Date());
        }
        int result = qaUserServiceFacade.saveOrUpdate(qaUser);
        return new ResponseMessage("200", "保存成功");
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.GET)
    ModelAndView changePassword() {
        ModelAndView view = new ModelAndView();
        return view;
    }


    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    @ResponseBody
    ResponseMessage changePassword(String oldPassword, String password) {
        SecurityUser user = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user == null) {
            return new ResponseMessage("-1", "用户未登陆");
        }
        QaUser qaUser = user.getUser();
        if (oldPassword == null || "".equals(oldPassword)) {
            return new ResponseMessage("-1", "原密码不能未空");
        } else {
            String encodeOldPassword = passwordEncoder.encodePassword(oldPassword, null);
            if (!qaUser.getPassword().equals(encodeOldPassword)) {
                return new ResponseMessage("-1", "原密码不正确");
            } else if (oldPassword.equals(password)) {
                return new ResponseMessage("-1", "新密码不能等于原密码");
            } else {
                qaUser.setPassword(passwordEncoder.encodePassword(password, null));
                qaUser.setModifyTime(new Date());
                qaUserServiceFacade.saveOrUpdate(qaUser);
                return new ResponseMessage("200", "修改成功");
            }
        }
    }


    @RequestMapping(value = "/info", method = RequestMethod.GET)
    ModelAndView info() {
        ModelAndView view = new ModelAndView();
        return view;
    }

}
