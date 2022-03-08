package com.hanson.mayijinfu;

import java.util.Arrays;

/**
 * @author 黄忠
 */
public class QuickSort {

    private static  int partition(int[] arr,int left,int right){
        int key =arr[left];
        while (left < right){
            while (left < right && arr[right]>=key){
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= key) {
                left++;
            }
            arr[right]=arr[left];
        }
        arr[left] = key;
        return left;
    }

    public static void quickSort(int[] arr, int left, int right){
        int pivot =0;
        if (left < right) {
            pivot=partition(arr, left, right);
            quickSort(arr,left,pivot-1);
            quickSort(arr,pivot+1,right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {
            65,24,56,62,86,11,15,76,89,23,17
        };
        System.out.printf("排序前"+ Arrays.toString(arr));
        quickSort(arr,0,arr.length - 1);
        System.out.println("排序后"+Arrays.toString(arr));
    }
}
