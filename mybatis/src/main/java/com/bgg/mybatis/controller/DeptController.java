package com.bgg.mybatis.controller;

import com.bgg.mybatis.entity.Dept;
import com.bgg.mybatis.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DeptController {
    @Autowired
    private DeptService service;
    @RequestMapping(value = "/getDept", method = RequestMethod.GET)
    public Dept getDept(@RequestBody Map<String,Object> map){
        System.out.println("请求成功："+ map.get("deptId"));
        return service.getDept((Integer) map.get("deptId"));
    }
}
