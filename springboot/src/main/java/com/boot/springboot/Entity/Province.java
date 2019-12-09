package com.boot.springboot.Entity;

/**
 * 省份
 */
public class Province {
    private int provinceID;
    private String name;
    private String personNum;


    public int getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(int provinceID) {
        this.provinceID = provinceID;
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

    public void setPersonNum(String  personNum) {
        this.personNum = personNum;
    }
    @Override
    public String toString() {
        return "Province{" +
                "provinceID=" + provinceID +
                ", name='" + name + '\'' +
                ", personNum=" + personNum +
                '}';
    }
}
