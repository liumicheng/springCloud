package com.bgg.vueserver.controller;

import com.bgg.vueserver.entity.Emp;
import com.bgg.vueserver.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class EmpListController {
    @Autowired
    private EmpService service;

    @RequestMapping(value = "/empList" ,method = RequestMethod.GET)
    public List<Emp> empList(){
        return service.empList();
    }

    @RequestMapping(value = "/empDel/{empId}",method = RequestMethod.GET)
    public int empDel(@PathVariable("empId") int empId){
        System.out.println("接受到的参数："+empId);
        return service.empDel(empId);
    }

    @RequestMapping(value = "/empUpdate",method = RequestMethod.POST)
    public int empUpdate(Emp emp){
        return service.empUpdate(emp);
    }
    @RequestMapping(value = "/empQueryById",method = RequestMethod.GET)
    public Emp empQueryById(@RequestParam("empId") int empId){
        return service.empQueryById(empId);
    }

    @RequestMapping(value = "/empSave",method = RequestMethod.POST)
    public int empSave(Emp emp){
        return service.empSave(emp);
    }

}
