package com.bgg.vueserver.service;

import com.bgg.vueserver.dao.LoginDao;
import com.bgg.vueserver.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginDao dao;
    @Override
    public int get(User user) {
        return dao.get(user);
    }

    @Override
    public int add(User user) {
        return dao.add(user);
    }

    @Override
    public int getUserName(User user) {
        return dao.getUserName(user);
    }
}
