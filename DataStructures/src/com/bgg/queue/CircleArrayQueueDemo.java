package com.bgg.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(4); //设置为4，队列最大为3
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
                    circleArrayQueue.addQueue(val);
                    break;
                case 'b':
                    circleArrayQueue.getQueue();
                    break;
                case 'c':
                    circleArrayQueue.list();
                    break;
            }
        }


    }
}

//数组模拟环形队列
class CircleArrayQueue {
    private int maxSize;//最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//模拟队列

    public CircleArrayQueue(int arrmaxSize){
        maxSize = arrmaxSize;
        arr = new int[maxSize];
        front = 0;//调整后：指向队列头位置
        rear = 0;//调整后：指向队列尾的后一个位置，空出一个来
    }

    //判断队列是否满
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return front == rear;
    }
    //入队列
    public void addQueue(int data){
        if(!isFull()){
            arr[rear] = data;
            //rear后移，实现环形
            rear = (rear + 1) % maxSize;
        }else{
            System.out.println("队列已满！");
        }

    }
    //出队列
    public void getQueue(){
        if(!isEmpty()){
            System.out.println(arr[front]);
            //front后移，实现环形
            front = (front + 1) % maxSize;
        }else{
            System.out.println("队列为空,无数据！");
        }
    }
    //从front开始才有意义，前面已经出栈
    public void list(){
        if (!isEmpty()){
           for(int i = front;i< front+size(); i++){
                System.out.print("arr["+i%maxSize+"]:"+arr[i%maxSize]+",");
           }
           System.out.println();
        }else{
            System.out.println("队列为空,无数据！");
        }
    }

    //求队列中的有效个数
    public int size(){
        return (rear + maxSize - front)%maxSize;
    }
}
