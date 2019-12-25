package com.bgg.springcloud.service;

import com.bgg.springcloud.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
//@FeignClient(value = "springCloud-dept") //服务熔断
@FeignClient(value = "springCloud-dept",fallbackFactory = DeptClientServiceFallbackFactory.class) //服务降级
public interface DeptClientService {
    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public boolean add(Dept dept);
    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id);
    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public List<Dept> list();
}
