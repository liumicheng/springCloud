package com.bgg.vueserver.service;

import com.bgg.vueserver.dao.EmpDao;
import com.bgg.vueserver.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmpDao dao;
    @Override
    public List<Emp> empList() {
        return dao.empList();
    }

    @Override
    public int empDel(int empId) {
        return dao.empDel(empId);
    }

    @Override
    public int empUpdate(Emp emp) {
        return dao.empUpdate(emp);
    }

    @Override
    public Emp empQueryById(int empId) {
        return dao.empQueryById(empId);
    }

    @Override
    public int empSave(Emp emp) {
        return dao.empSave(emp);
    }
}
