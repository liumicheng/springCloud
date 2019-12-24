package com.example.provider.controller;

import com.bgg.springcloud.entities.Dept;
import com.example.provider.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//返回json的控制器
public class DeptController {
    @Autowired
    private DeptService service;
    //根据id查询
    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    //一旦条用服务方法失败并抛出错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("id") Long id){
        Dept dept = service.get(id);
        if(null == dept){
            throw new RuntimeException("id:"+id+",没有对应信息！ ");
        }
        return service.get(id);
    }
    //全部查询
    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public List<Dept> list(){
        return service.list();
    }
    //添加
    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept){
        return service.add(dept);
    }

    //fallbackMethod
    public Dept processHystrix_Get(@PathVariable("id") Long id)
    {
        return new Dept().setDeptno(id)
                .setDname("该ID："+id+",没有对应的信息,null--@HystrixCommand")
                .setDb_source("no this database in MySQL");
    }
}
