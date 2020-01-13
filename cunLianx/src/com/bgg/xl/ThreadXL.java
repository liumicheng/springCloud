package com.bgg.xl;
/*
关于多线程的练习
 */
public class ThreadXL {
    public static void main(String[] args) {
        //创建线程方法一
        new Thread(){
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        //创建线程方法二
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName());
                }
            }
        }).start();
    }
}

class ThreadXL11 extends Thread{
    @Override
    public void run() {
        while (true){
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ThreadXL11 threadXL11 = new ThreadXL11();
        threadXL11.start();
    }
}

class ThreadXL12 implements Runnable{

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //创建线程的两种方式，extends Thread类和implements Runnable接口
    public static void main(String[] args) {
        ThreadXL11 threadXL11 = new ThreadXL11();
        threadXL11.start();
        ThreadXL12 threadXL12 = new ThreadXL12();
        new Thread(threadXL12).start();
    }
}
