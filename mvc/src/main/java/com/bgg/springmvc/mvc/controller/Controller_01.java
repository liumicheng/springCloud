package com.bgg.springmvc.mvc.controller;

import com.bgg.springmvc.mvc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
public class Controller_01 {
    @ModelAttribute //任何方法被调用时，都会先执行被@ModelAttribute修饰的方法
    public void modelAttribute(@RequestParam(value = "id") Integer id, Map<String,Object> map){

        System.out.println("AAAASDFFGGDDGGDFDDD");
        //模拟判断是否为修改操作
        if(id != null ){
            //模拟在数据库查表
            User user = new User(1,"bgg","男",23);
            System.out.println("修改前：    "+ user);
            map.put("user",user); //键的名字要和方法update（）参数类型的小写一样 也可以在User前面加@ModelAttribute("名")注解
        }

    }
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(@Valid User user){ //@Valid: 开启数据校验
        System.out.println("修改后：    " + user);
        return "success";
    }

}
