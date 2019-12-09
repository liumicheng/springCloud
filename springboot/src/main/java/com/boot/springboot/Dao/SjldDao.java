package com.boot.springboot.Dao;

import com.boot.springboot.Entity.City;
import com.boot.springboot.Entity.County;
import com.boot.springboot.Entity.Province;
import org.apache.ibatis.annotations.Mapper;

import javax.management.Query;
import java.util.List;

@Mapper
public interface SjldDao {
    List<Province> queryProvince();
    List<City> queryCity(Integer provinceID);
    List<County> queryCounty(Integer cityID);
    County queryCountyById(Integer countyID);
}
