package com.bgg.mybatis.service;

import com.bgg.mybatis.entity.User;

import java.util.List;

public interface UserService {
    List<User> getUserList();
    List<User> getUserAndDept(Integer deptId);
    List<User> queryStep(Integer deptId);
    List<User> getUserByUser(User user);
    List<User> getUserByChoose(User user);
    boolean updateUserBySet(User user);
    List<User> queryByItem(List<Integer> userIds);
    boolean saveUserByItem(List<User> list);
}
