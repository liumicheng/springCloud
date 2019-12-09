package com.redis.springbootredis.controller;

import com.redis.springbootredis.entity.User;
import com.redis.springbootredis.utils.RedisUtil;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class RedisController {
    @Resource
    private RedisUtil util;
    @PostMapping(value = "set",produces = "application/json;charset=UTF-8")
    public boolean setRedis(@RequestBody User user){

        System.out.println("key:  " + user.getName());
        return util.set("name",user.getName());
    }
    @GetMapping("get")
    public Object getRedis(String key){
        System.out.println("Key: " + key);
        return util.get(key);
    }
}
