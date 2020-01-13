package com.bgg.vueserver.controller;

import com.bgg.vueserver.entity.User;
import com.bgg.vueserver.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    LoginService service;
    @ResponseBody
    @RequestMapping(value = "/MyLogin",method = RequestMethod.POST)
    public Map<String,String> login(@RequestBody User user){
        Map<String,String> map = new HashMap<>();
        System.out.println("用户名："+ user.getUserName());
        System.out.println("密码："+user.getPassWord());
//        if(user != null && user.getUserName() != null && !"".equals(user.getUserName())){
//            map.put("pashName","TestAjax");//添加跳转组件名
//            map.put("flag","true");
//        }else{
//            map.put("pashName","MyLogin");//添加跳转组件名
//            map.put("flag","false");
//        }
        int sate = service.get(user);
        if(sate > 0){
            map.put("pashName","EmpList");//添加跳转组件名
            map.put("flag","true");
        }else{
            map.put("flag","false");
    }

        return map;
    }
    @ResponseBody
    @RequestMapping(value = "/addUserLogin",method = RequestMethod.POST)
    public Map<String, Boolean>  addUserLogin(@RequestBody User user){
        Map<String, Boolean> map = new HashMap<>();
        if(service.getUserName(user) <= 0){
            service.add(user);
            map.put("repetition",false);
        }else{
            map.put("repetition",true);
        }
        return map;
    }
}
