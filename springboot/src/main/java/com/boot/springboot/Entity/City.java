package com.boot.springboot.Entity;

public class City {
    private int CityID;
    private String name;
    private String personNum;
    private int provinceID;

    public int getCityID() {
        return CityID;
    }

    public void setCityID(int cityID) {
        CityID = cityID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonNum() {
        return personNum;
    }

    public void setPersonNum(String personNum) {
        this.personNum = personNum;
    }

    public int getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(int provinceID) {
        this.provinceID = provinceID;
    }

    @Override
    public String toString() {
        return "City{" +
                "CityID=" + CityID +
                ", name='" + name + '\'' +
                ", personNum='" + personNum + '\'' +
                ", provinceID=" + provinceID +
                '}';
    }
}
