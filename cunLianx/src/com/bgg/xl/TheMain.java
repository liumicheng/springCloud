package com.bgg.xl;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TheMain {
    public static void main(String[] args) throws IOException {
        LianLs lianLs = new LianLs();
        LianLs lianLs1 = new ZOne();
        lianLs.ffOne();
        lianLs1.ffOne();
        lianLs.ffTwo();
        System.out.println(lianLs.toString());
        try {
            lianLs.lxthrows();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println("finally");
        }
        lianLs.time();

        lianLs.lxzh();

        try {
            lianLs.io();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        int[] arr = {2,0,2,1,1,0};
        List<Integer> list = new ArrayList<>();
        for(int a : arr){
            list.add(a);
        }
        lianLs.shuZuTi1(list);


        lianLs.sortColors(arr);

    }

}
