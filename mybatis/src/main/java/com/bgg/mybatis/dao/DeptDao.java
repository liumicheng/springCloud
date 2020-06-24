package com.bgg.mybatis.dao;

import com.bgg.mybatis.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptDao {
    Dept queryById(Integer deptId);
    Dept getDept(Integer deptId);
}
