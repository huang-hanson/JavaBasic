package com.hanson.Algorithm;

/**
 * @author 黄忠
 */
public class shellSort {

    public static int[] shellSort(int[] arr){
        int dk = arr.length/3+1;
        while (dk==1){
            ShellInsertSort(arr,dk);
            dk=dk/3+1;
        }
        return arr;
    }
    public static void ShellInsertSort(int[] a, int dk){
        //类似于插入排序算法，但插入排序的算法增量都是1，这里的增量是dk，将1换成dk即可
        for (int i = dk;i<a.length; i++){
            if(a[i]<a[i-dk]){
                int j;
                int x = a[i];//x为待插入的元素
                a[i] = a[i-dk];
                for (j=i-dk; j >= 0&&x < a[j]; j=j-dk){
                    //通过循环，逐渐后移一位找到要插入的元素
                    a[j+dk]=a[j];
                }
                a[j+dk]=x;//将数据插入对应的位置
            }
        }
    }

    public static void main(String[] args) {
        int[] arr ={3,5,1,2,5,8};
        shellSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
