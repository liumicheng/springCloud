package com.bgg.xl;

public class MianShiTi {
    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        operator(a,b);
        System.out.println(a+","+b);

        System.out.println(foo(5));


    }
    public static void operator(StringBuffer x,StringBuffer y){
        x.append(y);
        y=x;
    }

    static int foo(int n){
        if(n<2)
            return n;
        return foo(n-1)+foo(n-2);
    }


}

class EHan{
    private static EHan eHan = new EHan();
    private EHan(){
    }
    public  static  EHan getEHan(){
        return eHan;
    }
}

class LHan{
    private static LHan lHan;
    private LHan(){

    }
    public static LHan getLHan(){
        synchronized (LHan.class){
            if(lHan == null){
                lHan = new LHan();
            }
            return lHan;
        }

    }

}
