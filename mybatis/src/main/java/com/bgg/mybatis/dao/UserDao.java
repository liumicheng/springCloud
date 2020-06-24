package com.bgg.mybatis.dao;


import com.bgg.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    List<User> getUserList();
    List<User> getUserAndDept(Integer deptId);
    //分步查询
    List<User> queryStep(Integer deptId);
    //动态sql
    List<User> getUserByUser(User user);
    List<User> getUserByChoose(User user);
    boolean updateUserBySet(User user);
    List<User> queryByItem(List<Integer> userIds);
    boolean saveUserByItem(List<User> list);
}
