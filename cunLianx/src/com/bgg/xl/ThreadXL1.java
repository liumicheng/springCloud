package com.bgg.xl;

public class ThreadXL1 {
    private boolean flag;
    public static void main(String[] args) {
        ThreadXL1 threadXL1 = new ThreadXL1();
        //子线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i < 3;i++){
                    threadXL1.ff1();
                }
            }
        }).start();

        //主线程
        for(int i=0;i<3;i++){
            threadXL1.ff2();
        }
    }

    public synchronized void ff1(){
        while(flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("子线程");
        flag = true;
        notify();

    }

    public synchronized void ff2(){
        while (!flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程");
        flag = false;
        notify();
    }
}
