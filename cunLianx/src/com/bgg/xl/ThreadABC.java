package com.bgg.xl;

import java.util.concurrent.Semaphore;

/*
解决：三个线程 a、b、c 并发运行，b,c 需要 a 线程的数据怎么实现？

 * 定义一个信号量，该类内部维持了多个线程锁，可以阻塞多个线程，释放多个线程
 * 线程的阻塞和释放是通过 permit 概念来实现
 * 线程通过 semaphore.acquire()方法获取 permit，如果当前 semaphore 有 permit 则分配给该线程
 * 如果没有则阻塞该线程直到 semaphore 调用 release（）方法释放 permit。
 * 构造函数中参数：permit（允许） 个数
 */
public class ThreadABC {
    private static int sum;
    private static Semaphore semaphore = new Semaphore(0);
    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                //模拟线程初始化耗时
                try {
                    Thread.sleep(1000);
                    sum++;
                    //初始化完参数后释放两个 permit
                    semaphore.release(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //获取 permit，如果 semaphore 没有可用的 permit 则等待，如果有则消耗一个
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Thread.currentThread().setName("ThreadB");
                System.out.println(Thread.currentThread().getName()+": "+sum);
            }
        });

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //获取 permit，如果 semaphore 没有可用的 permit 则等待，如果有则消耗一个
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Thread.currentThread().setName("ThreadC");
                System.out.println(Thread.currentThread().getName()+": "+sum);
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
    }
}
