package com.example.provider.service;

import com.bgg.springcloud.entities.Dept;;
import com.example.provider.Dao.DeptDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired(required = false)//设置允许为null 属性就不会有红色警告了
    private DeptDao dao;
    @Override
    public boolean add(Dept dept) {
        return dao.addDept(dept);
    }

    @Override
    public Dept get(Long id) {
        return dao.queryById(id);
    }

    @Override
    public List<Dept> list() {
        return dao.queryAll();
    }
}
