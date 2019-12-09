package com.boot.springboot.service;

import com.boot.springboot.Entity.City;
import com.boot.springboot.Entity.County;
import com.boot.springboot.Entity.Province;

import java.util.List;

public interface SjldService {
    List<Province> queryProvince();
    List<City> queryCity(Integer provinceID);
    List<County> queryCounty(Integer cityID);
    County queryCountyById(Integer countyID);
}
