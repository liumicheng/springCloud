package com.bgg.linkedList;
/*
双向链表
 */
public class DoubleLinkedList {
    public static void main(String[] args) {
        DoubleLinkedList dbl = new DoubleLinkedList();
        dbl.add(new Node(1,"周瑜","公瑾"));
        dbl.add(new Node(2,"诸葛亮","孔明"));
        dbl.add(new Node(3,"hh","h"));
        dbl.add(new Node(4,"z","z"));
        dbl.list();
        System.out.println("---------------------");
        dbl.del(3);
        dbl.list();

    }
    //设置头节点常量
    public static final Node HEAD = new Node(0,"","");


    //默认添加在最后
    public void add(Node node){
        Node temp = HEAD;
        while(true){
            if(temp.next == null){
                break;
            }
            //后移
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }

    //遍历
    public void list(){
        Node temp = HEAD;
        while(true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
            System.out.println("编号："+temp.no+",姓名："+temp.name+",字："+temp.nickName);
        }
    }

    //删除
    public void del(int no){
        Node temp = HEAD;
        boolean flag = false;
        while(true){
            if(temp.no == no){
                flag = true;
                break;
            }
            if(temp.next == null){
                System.out.println("链表为空或无此编号,无法删除！");
                break;
            }
            temp = temp.next;
        }
        if(flag){
           temp.pre.next = temp.next;
           //删除可能是最后一个节点
           if(temp.next != null){
               temp.next.pre = temp.pre;
           }
        }
    }
}



class Node{
    public int no;
    public String name;
    public String nickName;
    public Node next;//指向下一个节点
    public Node pre;//指向上一个节点

    public Node(int no,String name,String nickName){
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "no: " + no + ",name: " + name + ",nickName: " + nickName;
    }

}
