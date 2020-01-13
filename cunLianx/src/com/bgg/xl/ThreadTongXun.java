package com.bgg.xl;

import sun.applet.Main;

public class ThreadTongXun {
    private  boolean flag;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public static void main(String[] args) {
        //同一个对象
        final ThreadTongXun threadTongXun = new ThreadTongXun();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadTongXun.setFlag(false);
            }
        });
        thread1.start();
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //等待线程1完成然后取值
                    thread1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
              System.out.println("--:"+threadTongXun.isFlag());
            }
        });
        thread2.start();
    }
}
