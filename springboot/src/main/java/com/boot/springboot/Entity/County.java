package com.boot.springboot.Entity;

public class County {
    private int countyID;
    private String name;
    private String personNum;
    private int cityID;

    public int getCountyID() {
        return countyID;
    }

    public void setCountyID(int countyID) {
        this.countyID = countyID;
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

    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    @Override
    public String toString() {
        return "County{" +
                "countyID=" + countyID +
                ", name='" + name + '\'' +
                ", personNum='" + personNum + '\'' +
                ", cityID=" + cityID +
                '}';
    }
}
