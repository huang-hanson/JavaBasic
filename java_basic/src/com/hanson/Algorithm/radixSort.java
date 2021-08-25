package com.hanson.Algorithm;

/**
 * @author 黄忠
 */
public class radixSort {
    //array:数组    maxigit：数组最大位数
    public static int[] radixSort(int[] array,int maxDigit){
        //数组最大位数的数据上限，比如3位数的最大上限为1000
        double max= Math.pow(10,maxDigit+1);
        int n=1;//代表位数对应的数：1,10,100....
        int k=0;//保存每一个排序后的结果，将当前位上排序的结果相同的数字放在一同一个桶里
        int length = array.length;
        //bucket用于保存每次排序后的结果，将当前位上排序的结果相同的数字放在同一个桶里
        int[][] bucket = new int[10][length];
        int[] order =new int[length];//用于保存每个桶里有多少数字
        while (n<max){
            for(int num:array){
                int digit = (num/n)%10;
                bucket[digit][order[digit]]=num;
                order[digit]++;
            }
            //将前一个循环生成的桶里面的数据覆盖到原数组中，用于保存这一位的排序结果
            for (int i = 0; i < length; i++) {
                //在这个桶中的数据，从上到下遍历一遍并将数据保存在原数组当中
                if(order[i]!=0){
                    for (int j = 0; j <order[i] ; j++) {
                        array[k]=bucket[i][j];
                        k++;
                    }
                }
                order[i] = 0;//将桶中的数字设置为0，用于下一次排序
            }
            n*=10;
            k=0;//将k设置为0，用于保存下一次排序的结果
        }
        return array;
    }
    public static void main(String[] args) {
        int[] array = {
            2,6,1,55,37,967
        };
        radixSort(array,3);
        for (int i :
                array) {
            System.out.println(i);
        }
    }
}
