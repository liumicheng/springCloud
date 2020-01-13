package com.bgg.xl;

import java.io.Serializable;

public class IoUser implements Serializable {//该接口只是个标识，（表示该类可序列化）
    private String name;
    private int age;

    public IoUser() {
    }

    public IoUser(String name, int age) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "IoUser{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
