package com.boot.springboot.controller;

import com.boot.springboot.Entity.Emp;
import com.boot.springboot.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.text.normalizer.NormalizerBase;

import java.util.List;

@Controller
public class EmpController {
    @Autowired
    private EmpService service;
    //查询所有
    @GetMapping("/emps") //rest风格，用请求来区分CURD
    public String get(Model model){
        List<Emp> list = service.getAll();
        model.addAttribute("emps",list);
        return "emp/list";
    }
    //添加
    @PostMapping("/emp")
    public String save(Emp emp){
        boolean b = service.save(emp);
        // redirect: 重定向到一个地址 /表示当前项目路径
        //forward：转发到一个地址
        return "redirect:/emps";
    }
    //跳转添加页面
    @GetMapping("/emp")
    public String toSavePage(){
        return "emp/save";
    }
    //跳转修改页面
    @GetMapping("/emp/{id}")
    public String  toUpdatePage(@PathVariable("id") Integer id,Model model){
        Emp emp = service.getById(id);
        model.addAttribute("emp",emp);
        return "emp/update";
    }
    //修改
    @PutMapping("/emp")
    public String update(Emp emp){
        service.update(emp);
        return "redirect:/emps";
    }
    @DeleteMapping("/emp/{id}")
    public String delete(@PathVariable("id") Integer id){
        service.delete(id);
        return "redirect:/emps";
    }
}
