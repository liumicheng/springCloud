package com.example.provider.service;

import com.bgg.springcloud.entities.Dept;


import java.util.List;
public interface DeptService {
    boolean add(Dept dept);
    Dept get(Long id);
    List<Dept> list();
}
