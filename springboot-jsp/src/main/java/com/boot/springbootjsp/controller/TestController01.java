package com.boot.springbootjsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController01 {
    @GetMapping("/abc")
    public String abc(Model model){
        model.addAttribute("msg","哈哈");
        return "abc";
    }
    @GetMapping("/HelloAjax")
    public String helloAjax(){
        return "ajax/HelloAjax";
    }
    @GetMapping("/htmlAjax")
    public String htmlAjax(){
        return "html/htmlAjax";
    }
}
