package com.bgg.queue;

import com.sun.xml.internal.ws.developer.UsesJAXBContext;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag){
            System.out.println("a:入队 b:出队 c:列表");
            key = scanner.next().charAt(0);//接收一个字符
            switch(key){
                case 'a':
                    System.out.println("请输入一个数：");
                    int val = scanner.nextInt();
                    arrayQueue.addQueue(val);
                    break;
                case 'b':
                    arrayQueue.getQueue();
                    break;
                case 'c':
                    arrayQueue.list();
            }
        }


    }
}
//使用数组模拟队列
class ArrayQueue {
    private int maxSize;//最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//模拟队列

    public ArrayQueue(int arrmaxSize){
        maxSize = arrmaxSize;
        arr = new int[maxSize];
        front = -1;//指向队列头的前一个位置
        rear = -1;//指向队列尾的数据（即就是队列最后一个数据）
    }


    //判断队列是否满
    public boolean isFull(){
        return rear == maxSize - 1;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return front == rear;
    }
    //入队列
    public void addQueue(int data){
        if(!isFull()){
            rear++;
            arr[rear] = data;
        }else{
            System.out.println("队列已满！");
        }

    }
    //出队列
    public void getQueue(){
        if(!isEmpty()){
            front++;
            System.out.println(arr[front]);
        }else{
            System.out.println("队列为空,无数据！");
        }
    }

    public void list(){
        if (!isEmpty()){
            for(int a : arr){
                System.out.print(a+",");
            }
        }else{
            System.out.println("队列为空,无数据！");
        }
    }
}
