package com.vue.springbootvue.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class VueController {
    @GetMapping("/vue")
    public Map<String,Object> vue01(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","bgg");
        map.put("age",17);
        map.put("url","http://localhost:8002/vue");
        return map;
    }
}
