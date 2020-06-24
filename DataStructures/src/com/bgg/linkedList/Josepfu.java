package com.bgg.linkedList;
/*
N个人围成一圈，从第一个开始报数，第M个将被杀掉，最后剩下一个，其余人都将被杀掉。
约瑟夫问题，使用单向环形链表
 */
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleList csl = new CircleSingleList();
//        csl.addBoy(5);
//        csl.list();
        csl.countBoy(3,3,10);
    }
}

//环形单向链表
class CircleSingleList{
    private Boy frist;

    public void addBoy(int nums){
        Boy curBoy = null;
        if(nums <1){
            System.out.println("错误：数量不能小于1！");
            return;
        }
        for(int i = 1;i<=nums;i++){
            Boy boy = new Boy(i);
            if(i == 1){
                frist = boy;
                frist.setNext(frist);
                curBoy = frist;
            }else{
                curBoy.setNext(boy);
                boy.setNext(frist);
                curBoy = boy;
            }
        }
    }

    //遍历
    public void list(){
        Boy curBoy = frist;
        if (frist == null){
            System.out.println("链表为空！");
            return;
        }
        while (true){
            System.out.println(curBoy.getNo()+"号小朋友");
            if (curBoy.getNext()== frist){
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    /*
        根据用户输入，计算小孩出圈顺序
        1.startNo:开始的位置
        2.count：数到几
        3.nums：初始圈的人数
     */
    public void countBoy(int startNo,int count,int nums){
        addBoy(nums);
        Boy temp = frist;
        if(frist == null || startNo < 1 || startNo > nums){
            System.out.println("输入参数有误！");
            return;
        }
        //先把辅助节点移到链表的最后
        while(true){
            if (temp.getNext() == frist){
                break;
            }
            temp = temp.getNext();
        }
        //先让frist和temp都移动startNo-1步
        for(int i = 0;i<startNo-1;i++){
            temp = temp.getNext();
            frist = frist.getNext();
        }
        while (true){
            if(temp == frist){
                System.out.println(temp.getNo()+"号小朋友最后一个出圈！");
                break;
            }
            //同时移动nums-1步,此时frist指向的就是要出圈的节点
            for(int i = 0;i<count-1;i++){
                temp = temp.getNext();
                frist = frist.getNext();
            }
            System.out.println(frist.getNo()+"号小朋友出圈！");
            //frist指向出圈后的一位
            frist = frist.getNext();
            //最后一位的next指向frist
            temp.setNext(frist);
        }
    }
}

class Boy{
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}
