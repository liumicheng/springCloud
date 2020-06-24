package com.bgg.mybatis.service;

import com.bgg.mybatis.dao.UserDao;
import com.bgg.mybatis.entity.Dept;
import com.bgg.mybatis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao dao;
    @Override
    public List<User> getUserList() {
        return dao.getUserList();
    }

    @Override
    public List<User> getUserAndDept(Integer deptId) {
        return dao.getUserAndDept(deptId);
    }

    @Override
    public List<User> queryStep(Integer deptId) {
        return dao.queryStep(deptId);
    }

    @Override
    public List<User> getUserByUser(User user) {
        return dao.getUserByUser(user);
    }

    @Override
    public List<User> getUserByChoose(User user) {
        return dao.getUserByChoose(user);
    }

    @Override
    public boolean updateUserBySet(User user) {
        return dao.updateUserBySet(user);
    }

    @Override
    public List<User> queryByItem(List<Integer> userIds) {
        return dao.queryByItem(userIds);
    }

    @Override
    public boolean saveUserByItem(List<User> list) {
        return dao.saveUserByItem(list);
    }


}
