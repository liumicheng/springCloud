package com.bgg.vueserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TestAxiosController {

    @RequestMapping(value = "/TestAjax",method = RequestMethod.GET,produces="application/json;charset=UTF-8")
    @ResponseBody()
    public Map<String,String> testAjax(){
        Map<String,String> map = new HashMap<>();
        map.put("url","www.baidui.com");
        map.put("name","百度");
        return map;
    }
}
