package com.bgg.xl;
/*
商品 生产者 消费者 问题
 */
public class Resource {
    private String name = "商品";
    private int num = 1;
    private boolean flag = false;
    public synchronized void set(){
        while (flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        name = "数量:" + num++;
        System.out.println(name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        notify();
    }
    public synchronized void out(){
        while (!flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        name = "数量:"+ num--;
        System.out.println(name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = false;
        notify();
    }
}
class Producer implements Runnable{
    private Resource resource;
    Producer(Resource resource){
        this.resource = resource;
    }
    @Override
    public void run() {
        while (true){
            resource.set();
        }
    }
}

class Consumer implements Runnable{
    private Resource resource;
    Consumer(Resource resource){
        this.resource = resource;
    }
    @Override
    public void run() {
        while (true){
            resource.out();
        }
    }
}

class ZMain{
    public static void main(String[] args) {
        Resource resource = new Resource();
        Producer producer = new Producer(resource);
        Consumer consumer = new Consumer(resource);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
