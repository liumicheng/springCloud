package com.boot.springboot.Dao;

import com.boot.springboot.Entity.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface EmpDao {
    List<Emp> getAll();
    boolean save(Emp emp);
    Emp getById(Integer id);
    boolean update(Emp emp);
    boolean delete(Integer id);
}
