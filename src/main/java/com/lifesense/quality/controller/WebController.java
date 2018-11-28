package com.lifesense.quality.controller;

import com.lifesense.quality.config.security.SecurityUser;
import com.lifesense.quality.domain.QaUser;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 赵春定 on 2017/8/8.
 */
@Controller
public class WebController {

    @RequestMapping("/")
    ModelAndView index() {
        return index("");
    }

    @RequestMapping("/login")
    String login() {
        return "login";
    }

    @RequestMapping("/index")
    ModelAndView index(String name) {
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal != null) {
            SecurityUser securityUser = (SecurityUser) principal;
            QaUser qaUser = securityUser.getUser();
            if (qaUser.getProcessSign() == 0) {
                //默认作业员
                model.setViewName("work");
            }
            model.addObject("user", qaUser);
        }
        return model;
    }

    @RequestMapping("/404")
    String error() {
        return "404";
    }

    @RequestMapping("/main")
    String main() {
        return "main";
    }


    @RequestMapping("/work")
    String work() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal != null) {
            SecurityUser securityUser = (SecurityUser) principal;
            QaUser qaUser = securityUser.getUser();
            if (qaUser.getProcessSign() != 0) {
                return "index";
            }
        }
        return "work";
    }

    @RequestMapping("/repair")
    ModelAndView repair(ModelAndView view) {
        SecurityUser userDetails = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        QaUser user = userDetails.getUser();
        view.setViewName("repair");
        view.addObject("user", user);
        return view;
    }


    @RequestMapping("/checkLogin")
    @ResponseBody
    String checkLogin() {
        return "";
    }




}
