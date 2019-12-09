package com.bgg.springmvc.mvc.controller;

import com.bgg.springmvc.mvc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Controller
public class Controller_02 {
    @RequestMapping("/TestJson")
    @ResponseBody //返回的不是界面是json
    public User TestJson(){
        return new User(2,"liu","男",17);
    }
    @RequestMapping(value = "/TestFile",method = RequestMethod.POST)
    @ResponseBody
    public String TestFile(@RequestBody String file){
        System.out.println("FIle:   "+ file);
        return "Time" + new Date();
    }

    //处理异常
    @RequestMapping("/TestExceptionHandler")
    @ExceptionHandler(Exception.class)
    public ModelAndView ExceptionHandler(Exception ex,@RequestParam("id") Integer id){
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("Exception",ex);
        id /= 0;
        System.out.println("id:" + id);
        return modelAndView;
    }
}
