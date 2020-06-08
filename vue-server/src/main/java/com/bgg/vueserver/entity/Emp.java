package com.bgg.vueserver.entity;

public class Emp {
    private int empId;
    private String empName;
    private String sex;
    private int age;

    public Emp(int empId, String empName, String sex, int age) {
        this.empId = empId;
        this.empName = empName;
        this.sex = sex;
        this.age = age;
    }

    public Emp() {
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
