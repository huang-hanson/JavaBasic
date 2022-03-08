package com.hanson.niuke;

import java.util.*;
public class Printer {

    /**
     *  Description:二维数组（N*N），沿对角线方向，从右上角打印到左下角
     *  @author liuwei  DateTime 2014-5-27 下午4:13:56
     *  @param args
     */
    public static void main(String[] args) {


        int[][] a = {{1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}};
//		int[][] a = {{1,2,3},
//				{4,5,6},
//				{7,8,9}};
        int size = a.length;
        int len = 2*a.length-1;//一共生成几行结果
        for(int k=0;k<len;k++){
            //规律是第 K的 列号-行号=size-1-k
            for(int i=0;i<size;i++){
                for(int j=0;j<size;j++){
                    if(j-i == size-1-k){
                        System.out.print(a[i][j]+" ");
                    }
                }
            }
            System.out.println("");
        }
    }
}
