package com.bgg.linkedList;

import com.sun.org.apache.regexp.internal.RE;
import javafx.stage.StageStyle;

//单向链表模拟
public class SingleLinkedListDemo{
    public static void main(String[] args) {
        HeroNode h1 = new HeroNode(100,"吕布","奉先");
        HeroNode h2 = new HeroNode(2,"关羽","云长");
        HeroNode h3 = new HeroNode(3,"赵云","子龙");
        HeroNode h4 = new HeroNode(50,"项籍","羽");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByNO(h1);
        singleLinkedList.addByNO(h3);
        singleLinkedList.addByNO(h2);
        singleLinkedList.update(h4);
        singleLinkedList.list();
        System.out.println("链表中共有数据："+singleLinkedList.size()+"条！");
        singleLinkedList.getKNode(1);
    }
}

//管理HeroNode
class SingleLinkedList {
    //先初始化一个头结点，头结点不要动，不存放具体的数据
    private static final HeroNode head = new HeroNode(0,"","");


    public void add(HeroNode heroNode){
        HeroNode temp = head;
        while(true){
            //找到链表的最后
            if(temp.next == null){
                break;
            }
            //将temp后移
            temp = temp.next;
        }
        //将最后一个节点指向新加的节点
        temp.next = heroNode;
    }
    //单链表按顺序插入
    public void addByNO(HeroNode heroNode){
        HeroNode temp = head;
        //编号是否存在
        boolean flag = true;
        while(true){
            //说明temp已到链表最后了
            if(temp.next == null){
                break;
            }
            //找到位置，在temp的后面添加
            if(temp.next.no > heroNode.no){
                break;
            }else if(temp.next.no == heroNode.no){
                System.out.println("位置: " + heroNode.no + ",已有信息，无法添加！");
                flag = false;
            }
            temp = temp.next;
        }
        if(flag){
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    public void delete(int no){
        HeroNode temp = head;
        boolean flag = true;
        while (true){
            if (temp.next == null || temp.no > no){
                System.out.println("无no:"+no+"信息，删除失败！");
                flag = false;
                break;
            }
            if(temp.next.no == no){
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.next = temp.next.next;
        }
    }

    public void update(HeroNode heroNode){
        HeroNode temp = head;
        boolean flag = true;
        while(true){
            if(temp.next == null || temp.no > heroNode.no){
                System.out.println("无此no："+heroNode.no+"信息，无法修改！");
                flag = false;
                break;
            }
            if(temp.next.no == heroNode.no){
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.next.name = heroNode.name;
            temp.next.nickName = heroNode.nickName;
        }
    }

    public int size(){
        HeroNode temp = head;
        int sum = 0;
        while(true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
            sum++;
        }
        return sum;
    }

    //查单链表中倒数第K个节点
    public HeroNode getKNode(int k){
        HeroNode temp = head;
        boolean flag = true;
        if(size() >= k && k > 0){
            for(int i = 0;i<size()-k+1;i++){
                temp = temp.next;
            }
            System.out.println("链表中倒数第"+k+"个节点："+temp);
            return temp;
        }else{
            System.out.println("链表中无此节点！");
            return null;
        }
    }

    public HeroNode reverse(){
        HeroNode temp = head;
        HeroNode temp1;
        HeroNode temp2;
        for(int i = 0;i<size()/2;i++){
            temp = temp.next;
            temp1 = temp;
            temp2 = getKNode(i+1);
            temp = temp2;
            temp2 = temp1;
            add(temp1);
            delete(i+1);
        }
        return temp;
    }

    public void list(){
        if(head.next == null){
            System.out.println("链表为空！");
        }else{
            HeroNode temp = head.next;
            while(true){
                //链表最后
                if(temp == null){
                    break;
                }
                System.out.println(temp);
                //后移
                temp = temp.next;
            }

        }
    }
}

//每个HeroNode对象就是一个节点
class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;//指向下一个节点

    public HeroNode(int no,String name,String nickName){
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "no: " + no + ",name: " + name + ",nickName: " + nickName;
    }
}
