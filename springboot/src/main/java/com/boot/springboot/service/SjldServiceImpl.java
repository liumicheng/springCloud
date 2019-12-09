package com.boot.springboot.service;

import com.boot.springboot.Dao.SjldDao;
import com.boot.springboot.Entity.City;
import com.boot.springboot.Entity.County;
import com.boot.springboot.Entity.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SjldServiceImpl implements SjldService {
    @Autowired
    private SjldDao dao;
    @Override
    public List<Province> queryProvince() {
        return dao.queryProvince();
    }

    @Override
    public List<City> queryCity(Integer provinceID) {
        return dao.queryCity(provinceID);
    }

    @Override
    public List<County> queryCounty(Integer cityID) {
        return dao.queryCounty(cityID);
    }

    @Override
    public County queryCountyById(Integer countyID) {
        return dao.queryCountyById(countyID);
    }
}
