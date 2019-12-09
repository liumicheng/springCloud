package com.boot.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class bootController_01 {

    @RequestMapping("/Login")
    public String login(){
        return "Login";
    }
    @PostMapping("/LoginMain")
    public String main(@RequestParam("userName") String userName, @RequestParam("passWord") String passWord, Map<String,String> map, HttpSession session){
        if(!StringUtils.isEmpty(userName) && userName.equals(passWord)){
            //用来判断是否登录
            session.setAttribute("LoginUser",userName);
            //登陆成功，防止表单重复提交，可以重定向到主页
            return "redirect:/main";
        }else{
            map.put("msg","用户名密码错误！");
            return "Login";
        }
    }
}
