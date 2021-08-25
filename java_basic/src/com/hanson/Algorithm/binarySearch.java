package com.hanson.Algorithm;

/**
 * @author 黄忠
 */
public class binarySearch {
    public static int binarySearch(int[] array,int a){
        int low = 0;
        int high = array.length-1;
        int mid;
        while (low <= high) {
            mid = (low+high)/2;//中间位置
            if (array[mid] ==a){
                return mid;
            }else if (a>array[mid]){//向右查找
                low = mid+1;
            }else {
                //向左查找
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        binarySearch binarySearch = new binarySearch();
        int[] array = {3,4,6,20,40,45,51,62,70,99,110};
        System.out.println("查找数的索引下标："+binarySearch(array,120));
    }
}


