package com.bgg.xl;

import org.junit.Test;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

public class LianLs {
    private String name;
    private char sex;
    private int age;
    private char zw = '中';

    public void  ffOne(){
        System.out.println("fufufufufu");
    }

    public void ffTwo(){
        for(int i = 1; i <= 9;i++){
           for(int j = 1; j <= i; j++){
                System.out.print(j+"*"+i+"="+i*j+" ");
            }
            System.out.println();
        }
        byte b = 1;
        switch (b){
            case 1:
                System.out.println("1");
                break;
        }

    }

    public void lxthrows() throws Exception{
        int i = 1/0;
    }

    public void lxthrow(){
        try {
            throw new Exception("手动throw抛出异常");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void time(){
        SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        System.out.println(sdf.format(date));
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
    }

    //String和其它基本类型转换
    public void lxzh(){
        int i = Integer.parseInt("1");
        boolean c = Boolean.parseBoolean("true");
        String str = String.valueOf('A');
        System.out.println(i+","+c+","+str);
    }

    public void io() throws IOException, ClassNotFoundException {
        IoUser user = new IoUser("张三",20);
        //对象序列化
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("C:\\Users\\dell\\Desktop\\io\\User")));
        objectOutputStream.writeObject(user);
        objectOutputStream.close();
        //读取
        ObjectInputStream objectInputStream  = new ObjectInputStream(new FileInputStream(new File("C:\\Users\\dell\\Desktop\\io\\User")));
        System.out.println("读出："+(IoUser)objectInputStream.readObject());

    }
    //给hashMap排序
   public void  hashMapPx(HashMap<Integer,IoUser> map){
        //entrySet:一般用来遍历map集合的方法
       Set<Map.Entry<Integer,IoUser>> entrySet = map.entrySet();
       //set转换成List
       List<Map.Entry<Integer,IoUser>> list = new ArrayList<>(entrySet);

   }
    //该方法获取集合中数字出现的次数，并按照次数排序
   public void shuZuTi1(List<Integer> list){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<list.size();i++){
            int shu = 0;
            int sum = 1;
            //避免重复覆盖
            for(int a = i; a>=0;a--){
                if(a>0){
                    if (list.get(i) == list.get(a-1)){
                        break;
                    }
                } else{
                    for(int j = i+1;j<list.size();j++){
                        if(list.get(i) == list.get(j)){
                            sum++;
                        }
                    }
                    shu = list.get(i);
                    map.put(shu,sum);
                }
            }
        }
        //map集合的entrySet集合转换成list
        List<Map.Entry<Integer,Integer>> entryList = new ArrayList<>(map.entrySet());
       //通过比较器来实现排序
       Collections.sort(entryList,new Comparator<Map.Entry<Integer,Integer>>() {
           @Override
           public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
               return o2.getValue().compareTo(o1.getValue());
           }
       });
       for(Map.Entry<Integer,Integer> mapping :entryList){
           System.out.println(mapping.getKey()+" 出现："+mapping.getValue()+"次");
       }
   }

   //排序算法--冒泡
    public void sortColors(int[] nums) {
        int temp;
        for(int i = 0;i<nums.length/2;i++){
            for(int j = nums.length-1; j>i;j--){
                if(nums[j]<nums[j-1]){
                    temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }
            }
        }
        for(int a : nums){
            System.out.print(a+" ");
        }
    }


    @Override
    public String toString() {
        return "LianLs{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", zw=" + zw +
                '}';
    }
}
