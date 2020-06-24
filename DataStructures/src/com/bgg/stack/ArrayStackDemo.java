package com.bgg.stack;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Stack;

/*
    数组模拟栈,实现计算器功能
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        String expression = "45+2*6-2/2";
        //创建两个栈
        ArrayStack numStack = new ArrayStack(20);
        ArrayStack operStack = new ArrayStack(20);
        //相关变量
        int index = 0;//用户扫描
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char c = ' ';//将每次扫描得到的char保存
        String strNum = ""; //处理多位数
        while (true){
           c = expression.substring(index,index+1).charAt(0);
           if(operStack.isOper(c)){ //运算符
               //如果为空直接入栈
               if(operStack.isEmpty()){
                   operStack.push(c);
               }else{
                    if (operStack.priority(c) <= operStack.priority(operStack.getStackTop())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = operStack.cal(num1,num2,(char)oper);
                        numStack.push(res);
                    }
                   operStack.push(c); //等同于else  因为if 和else中都要
               }
           }else{ //数字
               // numStack.push(c - 48); //不能直接存,字符'1' -48 =int 1
               strNum += c;
               //判断是不是最后一位
               if (index == expression.length()-1){
                   numStack.push(Integer.parseInt(strNum));
               }else{
                   //判断下一位是否为运算符
                   if (operStack.isOper(expression.substring(index+1,index+2).charAt(0))){
                       numStack.push(Integer.parseInt(strNum));
                       //要清空
                       strNum = "";
                   }
               }
           }
           index++;
           if(index == expression.length()){
               break;
           }

        }
        System.out.println("数栈--------");
        numStack.list();
        System.out.println("运算符栈--------");
        operStack.list();
        while (true){
            //要用operStack
            if (operStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = operStack.cal(num1,num2,(char)oper);
            numStack.push(res);
        }
        System.out.println("-----");
        System.out.println(expression+"="+res);
    }
}

class ArrayStack{
    private int maxSize;//栈的容量
    private int[] stack;//数组模拟栈
    private int top = -1;//栈顶,初始化为-1

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
    }
    //栈满
    public boolean isfull(){
        return top == maxSize-1;
    }
    //栈空
    public boolean isEmpty(){
        return top == -1;
    }
    //入栈
    public void push(int value){
        if(isfull()){
            System.out.println("栈已满，无法入栈！");
        }else{
            top++;
            stack[top] = value;
        }
    }
    //出栈
    public int pop(){
        if(isEmpty()){
            //Runtime 运行时异常,可以不用捕获 直接抛出
            throw new RuntimeException("栈为空，无法出栈！");
        }else{
            return stack[top--];
        }
    }

    //查看top 栈顶
    public int getStackTop(){
        if(isEmpty()){
            //Runtime 运行时异常,可以不用捕获 直接抛出
            throw new RuntimeException("栈为空！");
        }else{
            return stack[top];
        }
    }

    //遍历,从栈顶开始显示
    public void list(){
        int temp = top;
        if(isEmpty()){
            System.out.println("栈为空！");
            return;
        }
        while(true){
            System.out.println(stack[temp--]);
            if (temp == -1){
                break;
            }
        }
    }

    //返回运算优先级
    public int priority(int oper){
        if (oper == '*'||oper == '/'){
            return 1;
        }else if(oper == '+' ||oper == '-'){
            return 0;
        }else{
            return -1;
        }
    }
    //判断是否为运算符
    public boolean isOper(char val){
        return val == '*' || val =='/' || val == '+' || val == '-';
    }

    //计算方法
    public int cal(int num1,int num2,char c){
        int res = 0;
        switch (c){
            case '+':
                res = num2 + num1;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num2 * num1;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }

}
