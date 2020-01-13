package com.bgg.xl;

public class GongShi {
    //IF(AND(A17>0,A17<=$D$8),IF($C$2<=40,IF($C$2+A17-1<18,$C$5*MIN(A17,$C$7),IF(A17<$C$7,MAX(160%*$C$5*MIN(A17,$C$7),100%*$C$5*$C$7),IF($C$2+A17-1<80,160%*$C$5*$C$7+$C$5*$C$7*1%*A17,F16))),IF(A17<$C$7,MAX(140%*$C$5*MIN(A17,$C$7),100%*$C$5*$C$7),IF($C$2+A17-1<80,140%*$C$5*$C$7+$C$5*$C$7*1%*A17,F16))),0)
    private double A17,C2,D8,C5,C7,F16,sum;

    public void gg1(){
        if (A17>0 && A17 <= D8){
            if(C2<=40){
                if(C2+A17-1<18){
                    sum = C5*Math.min(A17,C7);
                } else {
                    if (A17<C7){
                        sum = Math.max(1.6*C5*Math.min(A17,C7),C5*C7);
                    }else{
                        if(C2+A17-1<80){
                            sum = 1.6*C5*C7+C5*C7*0.01*A17;
                        }else{
                            sum = F16;
                        }
                    }
                }
            }else{
                if(A17<C7){
                    sum = Math.max(1.4*C5*Math.min(A17,C7),C5*C7);
                }else {
                    if (C2+A17-1<80){
                        sum = 1.4*C5*C7+C5*C7*0.01*A17;
                    }else{
                        sum = F16;
                    }
                }
            }
        } else{
            sum = 0;
        }
    }

//    public void gg(){
//        if(AND(A17>0,A17<=D8),
//            if(C2<=40,
//                if(C2+A17-1<18,
//                    C5*MIN(A17,C7),
//                    if(A17<C7,
//                        MAX(160%*C5*MIN(A17,C7), 100%*C5*C7),
//                        if(C2+A17-1<80,160%*C5*C7+C5*C7*1%*A17,F16)
//                    )
//                ),
//                if(A17<C7,
//                    MAX(140%*C5*MIN(A17,C7),100%*C5*C7),
//                    if(C2+A17-1<80,140%*C5*C7+C5*C7*1%*A17,F16)
//                )
//            ),
//        0);
//    }

}

