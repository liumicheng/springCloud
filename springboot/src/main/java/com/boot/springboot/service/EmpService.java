package com.boot.springboot.service;


import com.boot.springboot.Entity.Emp;

import java.util.List;

public interface EmpService {
    List<Emp> getAll();
    boolean save(Emp emp);
    Emp getById(Integer id);
    boolean update(Emp emp);
    boolean delete(Integer id);
}
