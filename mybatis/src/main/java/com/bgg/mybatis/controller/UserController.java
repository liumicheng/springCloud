package com.bgg.mybatis.controller;

import com.alibaba.fastjson.JSON;
import com.bgg.mybatis.entity.User;
import com.bgg.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService service;
    @ResponseBody
    @RequestMapping(value = "/getUserList", method = RequestMethod.GET)
    public List<User> getUserList(){
        return service.getUserList();
    }

    @ResponseBody
    @RequestMapping(value = "/getUserAndDept", method = RequestMethod.POST)
    public List<User> getUserAndDept(@RequestBody Map<String,Object> map){
        return service.getUserAndDept((Integer) map.get("deptId"));
    }
    @ResponseBody
    @RequestMapping(value = "/queryStep",method = RequestMethod.POST)
    public List<User> queryStep(@RequestBody Map<String,Object> map){
        return service.queryStep((Integer) map.get("deptId"));
    }
    @ResponseBody
    @RequestMapping(value = "/getUserByUser",method = RequestMethod.POST)
    public List<User> getUserByUser(@RequestBody User user){
        System.out.println("请求成功："+user);
        return service.getUserByUser(user);
    }
    @ResponseBody
    @RequestMapping(value = "/getUserByChoose", method = RequestMethod.POST)
    public List<User> getUserByChoose(@RequestBody User user){
        return service.getUserByChoose(user);
    }
    @ResponseBody
    @RequestMapping(value = "/updateUserBySet",method = RequestMethod.POST)
    public boolean updateUserBySet(@RequestBody User user){
        System.out.println("请求成功："+user);
        return service.updateUserBySet(user);
    }

    /*
        sql中使用in  传入一个集合作为in中的条件
     */
    @ResponseBody
    @RequestMapping(value = "/queryByItem",method = RequestMethod.POST)
    public List<User> queryByItem(@RequestBody List<Integer> userIds){
        System.out.println("List：");
        for(int i : userIds){
            System.out.print(i);
        }
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        System.out.println(JSON.toJSONString(list));
        return service.queryByItem(userIds);
    }
    @ResponseBody
    @RequestMapping(value = "/saveUserByItem",method = RequestMethod.POST)
    public boolean saveUserByItem(@RequestBody List<User> list){
        System.out.print("List：");
        for(User user : list){
            System.out.print(user);
        }
        return service.saveUserByItem(list);
    }
}
