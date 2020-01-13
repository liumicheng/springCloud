package com.bgg.xl;

import lombok.Synchronized;

/*
单例模式：饿汉、懒汉
 */
public class Singleton {
    //直接创建对象
    private static Singleton singleton = new Singleton();
    //私有化构造器
    private Singleton(){

    }
    //返回对象实例  为何为静态方法？ 因为外部没有对象，要用类名调用方法
    public static Singleton getSingleton(){
        return singleton;
    }
}

class Singleton1{
    //声明静态变量
    private static Singleton1 singleton1;
    //私有化构造器
    private Singleton1(){}
    public static Singleton1 getSingleton1(){
        //同步代码块  任意对象当锁
        synchronized(Singleton1.class){
            if (singleton1 == null){
                singleton1 = new Singleton1();
            }
        }
        return singleton1;
    }
}
