package com.bgg.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
    后缀表达式 （逆波兰表达式）
 */
public class PolandNotation {
    public static void main(String[] args) {
        //先定义逆波兰表达式
        //(3+4)*5-6
       // String str = "3 4 + 5 * 6 - ";//为了方便，空格隔开
        //System.out.println(getList(str).toString());
        //System.out.println("结果："+ calculate(getList(str)));

        List<String> list = indixList("1+(1+2)*3/5-1");
        System.out.println(list.toString());
        List<String> list1 = suffixList(list);
        System.out.println(list1.toString());

    }
    //将逆波兰表达式依次放入ArrayList中
    public static List<String> getList(String str){
        //以空格分割成字符数组
        String[] strs = str.split(" ");
        List<String> list = new ArrayList<>();
        for(String s : strs){
            list.add(s);
        }
        return list;
    }
    //对表达式的计算
    public static int calculate(List<String> list){
        //创一个栈，只需一个即可
        Stack<String> stack = new Stack<>();
        int res = 0;
        for(String s : list){
            if (s.matches("\\d+")){//匹配一位或多位数
                stack.push(s);
            }else{//运算符
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                switch (s){
                    case "+" :
                        res =  num1 + num2;
                        break;
                    case  "-":
                        res = num2 - num1;
                        break;
                    case "*" :
                        res = num1 * num2;
                        break;
                    case "/" :
                        res = num2 / num1;
                        break;
                    default:
                        throw new RuntimeException("无效运算符！");
                }
                stack.push(res +"");
            }
        }
        return res;
    }


    //将中缀表达式放入List中
    public static  List<String> indixList(String s){
        int index = 0;//指针，用于遍历
        List<String> list = new ArrayList<>();
        String str = "";//拼接多位数
        char c = ' ';
        do {
            if(s.charAt(index) < 48 || s.charAt(index) > 57){ //非数字
                list.add(s.charAt(index) + "");
                index++;
            }else{
                str =""; //先清空
                while (index <s.length() && s.charAt(index) >= 48 && s.charAt(index) <= 57){
                    str += s.charAt(index);
                    index++;
                }
                list.add(str);
            }
        }while (index < s.length());

        return list;
    }
    //将中缀表达式的list转换成后缀表达式
    public static List<String> suffixList(List<String> list){
        Stack<String> s1 = new Stack<>();//运算符
        //因为s2这个栈，没有pop操作，逆序输出才是对应的逆波兰表达式，所以这里直接用List来简化
       // Stack<String> stack2 = new Stack<>();//中间结果
        List<String> s2 = new ArrayList<>();
        for(String s : list){
            if(s.matches("\\d+")){ //如果是一个数，加入s2
                s2.add(s);
            }else if(s.equals("(")){
                s1.push(s);
            }else if(s.equals(")")){
                while(!s1.peek().equals("(")){//peek():只查看栈顶，不出栈
                    s2.add(s1.pop());
                }
                s1.pop(); //将 “（”弹出 消除小括号
            }else{
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(s)){
                    s2.add(s1.pop());
                }
                s1.push(s);
            }
        }
        while (s1.size() !=0){
            s2.add(s1.pop());
        }
        return s2;
    }

}

class Operation{
    //定义加减乘除常量优先级
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    //返回优先级
    static int getValue(String operation){
        int res = 0;
        switch (operation){
            case "+":
                res = ADD;
                break;
            case "-":
                res = SUB;
                break;
            case "*":
                res = MUL;
                break;
            case "/":
                res = DIV;
                break;
            default:
                System.out.println("不存在该运算符！");
                break;
        }
        return res;
    }
}
