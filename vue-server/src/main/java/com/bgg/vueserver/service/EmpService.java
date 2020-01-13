package com.bgg.vueserver.service;

import com.bgg.vueserver.entity.Emp;
import java.util.List;
public interface EmpService {
    List<Emp> empList();
    int empDel(int empId);
    int empUpdate(Emp emp);
    Emp empQueryById(int empId);
    int empSave(Emp emp);
}
