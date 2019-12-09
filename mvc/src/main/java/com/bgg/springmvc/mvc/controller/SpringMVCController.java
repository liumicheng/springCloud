package com.bgg.springmvc.mvc.controller;

import com.bgg.springmvc.mvc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.awt.SunHints;

import java.sql.SQLOutput;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/bgg")
public class SpringMVCController {
    public static final String SUCCESS = "success";

    @RequestMapping(value = "/testPost",method = RequestMethod.POST)
    public String testPost(){
        return SUCCESS;
    }

    @RequestMapping(value = "/Login",method = RequestMethod.GET)
    public String login(){
        return "Login";
    }

    @RequestMapping(value = "/param")
    public String param(User user){
        System.out.println(user);
        return SUCCESS;
    }
    @RequestMapping("/TestModelAndView")
    public ModelAndView TestModelAndView(){
        ModelAndView modelAndView = new ModelAndView(SUCCESS);
        modelAndView.addObject("time",new Date());
        return modelAndView;
    }


}
