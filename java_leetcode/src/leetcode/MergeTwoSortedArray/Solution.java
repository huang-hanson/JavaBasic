package leetcode.MergeTwoSortedArray;

import java.util.Arrays;

/**
 * @author 黄忠
 */
/*
*给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。

请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
输出：[1,2,2,3,5,6]
解释：需要合并 [1,2,3] 和 [2,5,6] 。
合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。

*
* */
public class Solution {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        for (int i = m; i < m+n; i++){
            nums1[i] = nums2[i-m];
        }

        Arrays.sort(nums1);
        for (int num:nums1){
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {
                1,2,3,0,0,0
        };
        int m =3,n=3;
        int[] nums2 = new int[] {
                2,5,6
        };
        merge(nums1,m, nums2,n);
    }
}
