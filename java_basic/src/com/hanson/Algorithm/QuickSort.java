package com.hanson.Algorithm;

public class QuickSort {

    static int[] arr = new int[]{3,2,1,5,6,4};

    public static void main(String[] args) {
        QuickSort(arr,0,arr.length-1);
        for (int i : arr){
            System.out.println(i);//{1,2,2,3,3,4,5,5,6}
        }
        //System.out.println(arr[arr.length-2]);
    }

    public static void QuickSort(int[] arr,int left,int right){

        if (arr == null || arr.length == 0) {
            return;
        }
        if(left > right){
            return;
        }
        int key = arr[left];
        int l = left;
        int r = right;
        while (l != r) {
            while (arr[r]>=key && l < r) {
                r--;
            }
            while (arr[l] <= key && l < r) {
                l++;
            }
            if(l < r){
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }

        }
        arr[left] = arr[l];
        arr[l]=key;

        QuickSort(arr,left,l-1);
        QuickSort(arr,l+1,right);

    }
}