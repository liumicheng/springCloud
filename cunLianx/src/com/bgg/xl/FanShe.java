package com.bgg.xl;

public class FanShe {
    private String name;
    public void setName(String name){
        this.name = name;
    }
    public static void main(String[] args) {
        //获取字节码三种方式
        try {
            Class c1 = Class.forName("com.bgg.xl.FanShe");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Class c2 = new FanShe().getClass();
        final Class<FanShe> c3 = FanShe.class;
    }
}
