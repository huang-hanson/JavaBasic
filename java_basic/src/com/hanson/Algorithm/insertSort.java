package com.hanson.Algorithm;

/**
 * @author 黄忠
 */
public class insertSort {
    public static int[] insertSort(int[] arr){
       for (int i = 1; i < arr.length; i++) {
           //插入的数
           int insertVal = arr[i];
           //被插入的位置(准备和前一个数进行比较)
           int index = i-1;
           while (index >=0&&insertVal<arr[index]) {
               //则将arr[index]向后移
               arr[index+1]=arr[index];
               //将index向前移动;
           }
           //将插入的数放入合适的位置
           arr[index+1]=insertVal;
       }
       return arr;
    }
    public static void main(String[] args) {
     int[] arr = {6,2,5,7,8};
     insertSort(arr);
     for (int i = 0; i <arr.length ; i++) {
         System.out.println(arr[i]);
        }
    }
}
