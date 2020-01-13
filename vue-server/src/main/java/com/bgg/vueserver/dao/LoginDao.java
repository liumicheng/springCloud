package com.bgg.vueserver.dao;

import com.bgg.vueserver.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginDao {
    int get(User user);
    int add(User user);
    int getUserName(User user);
}

