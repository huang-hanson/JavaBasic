package com.hanson.Algorithm;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author 黄忠
 */
public class bucketSort {
    public static int[] bucketSort(int[] arr){
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        for(int i = 0;i<arr.length; i++){
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        //创建桶
        int bucketNum = (max - min)/arr.length-1;
        ArrayList<ArrayList<Integer>> bucketArr= new ArrayList(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }
        //将每个元素都放入桶中
        for (int i = 0; i < arr.length; i++) {
            int num = (arr[i]-min)/(arr.length);
            bucketArr.get(num).add(arr[i]);
        }
        //对每一个桶进行排序
        for (int i = 0; i < bucketArr.size(); i++) {
            Collections.sort(bucketArr.get(i));
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {3,6,5,9,7,8};
        bucketSort(arr);
    }
}
