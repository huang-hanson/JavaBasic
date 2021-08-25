package com.hanson.Algorithm;

/**
 * @author 黄忠
 */
public class bubbleSort {
    public static int[] bubbleSort(int[] arr){
        //外循环控制循环的趟数
        for(int i = 0; i < arr.length-1; i++){
            //内循环控制每一趟排序多少次
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = {4,5,6,3,2,1};
        bubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
