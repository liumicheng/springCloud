package com.bgg.vueserver.dao;

import com.bgg.vueserver.entity.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface EmpDao {
    List<Emp> empList();
    int empDel(int empId);
    int empUpdate(Emp emp);
    Emp empQueryById(int empId);
    int empSave(Emp emp);
}
