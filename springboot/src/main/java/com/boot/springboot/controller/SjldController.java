package com.boot.springboot.controller;

import com.boot.springboot.Entity.City;
import com.boot.springboot.Entity.County;
import com.boot.springboot.Entity.Province;
import com.boot.springboot.service.SjldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

//三级联动的Controller
@RestController  //全发json
public class SjldController {
    @Autowired
    private SjldService service;
    @GetMapping("/queryProvince")
    public List<Province> toSjldHtml(){
        List<Province> list = service.queryProvince();
        return list;
    }
    @GetMapping("/queryCity/{provinceID}")
    public List<City> queryCity(@PathVariable("provinceID") Integer provinceID){
        return service.queryCity(provinceID);
    }
    @GetMapping("/queryCounty/{cityID}")
    public List<County> queryCounty(@PathVariable("cityID") Integer cityID){
        return service.queryCounty(cityID);
    }
    @GetMapping("queryCountyById/{countyID}")
    public County queryCountyById(@PathVariable("countyID") Integer countyID){
       return service.queryCountyById(countyID);
    }
}
