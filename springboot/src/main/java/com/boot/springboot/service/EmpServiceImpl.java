package com.boot.springboot.service;

import com.boot.springboot.Dao.EmpDao;
import com.boot.springboot.Entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpDao dao;
    public List<Emp> getAll(){
        return dao.getAll();
    }

    @Override
    public boolean save(Emp emp) {
        return dao.save(emp);
    }

    @Override
    public Emp getById(Integer id) {
        return dao.getById(id);
    }

    @Override
    public boolean update(Emp emp) {
        return dao.update(emp);
    }

    @Override
    public boolean delete(Integer id) {
        return dao.delete(id);
    }
}
