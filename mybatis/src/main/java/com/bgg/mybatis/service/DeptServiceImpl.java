package com.bgg.mybatis.service;

import com.bgg.mybatis.dao.DeptDao;
import com.bgg.mybatis.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptServiceImpl implements DeptService{
    @Autowired
    private DeptDao dao;
    @Override
    public Dept getDept(Integer deptId) {
        return dao.getDept(deptId);
    }
}
