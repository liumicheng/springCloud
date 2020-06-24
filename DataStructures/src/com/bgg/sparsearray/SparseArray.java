package com.bgg.sparsearray;
//稀疏数组
public class SparseArray {
    public static void main(String[] args) {
        //创建一个原始二维数组 11*11
        //0:表示没有棋子，1：表示黑子 2：表示蓝子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        for(int[] row : chessArr1 ){
            for (int data : row){
                System.out.print(data+" ");
            }
            System.out.println();
        }
        //将二维数组转为稀疏数组
        //1.非零个数
        int sum = 0;
        for(int i = 0; i<11; i++ ){
            for(int j = 0; j<11; j++){
                if(chessArr1[i][j] != 0){
                    sum++;
                }
            }
        }
        System.out.println("sum:"+sum);
        //2.创建对应的稀疏数组
        int sparseArr[][] = new int[sum+1][3];
        //行，列，有效个数
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        int count = 0;
        for(int i = 0; i<11; i++ ){
            for(int j = 0; j<11; j++){
                if(chessArr1[i][j] != 0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        //遍历稀疏数组
        for(int[] row : sparseArr ){
            for (int data : row){
                System.out.print(data + " ");
            }
            System.out.println();
        }

        //将稀疏数组转为二维数组
        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        for(int i = 1;i<sparseArr.length;i++){
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        for(int[] row : chessArr2 ){
            for (int data : row){
                System.out.print(data + " ");
            }
            System.out.println();
        }
    }
}
