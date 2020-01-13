package com.bgg.vueserver.service;

import com.bgg.vueserver.entity.User;

public interface LoginService {
    int get(User user);
    int add(User user);
    int getUserName(User user);
}
