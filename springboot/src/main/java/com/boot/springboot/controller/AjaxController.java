package com.boot.springboot.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.boot.springboot.Entity.Book;
import com.boot.springboot.Entity.Emp;
import com.boot.springboot.Entity.ShoppingCar;
import com.boot.springboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AjaxController {
    @Autowired
    BookService service;
    //购物车的集合
    Map<String, ShoppingCar> map = new HashMap<>();

    @GetMapping("/htmlAjax")
    public String htmlAjax(){
        return "ajax/htmlAjax";
    }
    @GetMapping("/aHtml")
    public String a(){
        return "ajax/files/a";
    }
    @GetMapping("/bHtml")
    public String b(){
        return "ajax/files/b";
    }


    @GetMapping("/xmlAjax")
    public String xmlAjax(){
        return "xml/xmlAjax";
    }

    @GetMapping("/jQueryAjax_A")
    @ResponseBody
    public Emp jQueryAjax_A(){
        Emp emp = new Emp();
        emp.setName("AAAAAAAA");
        return emp;
    }

    @GetMapping("/jQueryAjax_B")
    @ResponseBody
    public Emp jQueryAjax_B(){
        Emp emp = new Emp();
        emp.setName("BBBBBBB");
        return emp;
    }

    @GetMapping("/jQuery-ajax")
    public String jQueryAjax(){
        return "jQuery-ajax/jQuery-ajax";
    }


    //用户名是否存在
    @PostMapping("/ajaxJiaoYan")
    @ResponseBody
    public Map<String,Object> ajaxJiaoYan(@RequestBody Map<String,Object> map){
        String name = (String)map.get("name");
        System.out.println("NAMENSMENSEMNAME::::::" + name);
        List<String> list = Arrays.asList("11","22","33");
        Map<String,Object> map1 = new HashMap<>();
        if (list.contains(name)){
            map1.put("state", true);
            return map1;
        }else{
            map1.put("state", false);
            return map1;
        }
    }


    //购物车添加
    @GetMapping("/shoppingCar")
    @ResponseBody
    public Map<String,Object> shoppingCarSave(String bookName,Double price){

        if(map.containsKey(bookName)){
            ShoppingCar car = map.get(bookName);
            car.setBookSum(car.getBookSum() + 1);
            car.setPrice(car.getPrice() + price);
        }else{
            ShoppingCar car = new ShoppingCar();
            car.setPrice(price);
            car.setBookSum(1);
            car.setBookName(bookName);
            map.put(bookName,car);
        }
        Map<String,Object> map1 = new HashMap<>();
        map1.put("bookName",bookName);
        int bookSum = 0;
        double priceSum = 0;
        for(ShoppingCar car : map.values()){
            bookSum += car.getBookSum();
            priceSum += car.getPrice();
        }
        map1.put("bookSum",bookSum);
        map1.put("price",priceSum);
        return map1;
    }
}
