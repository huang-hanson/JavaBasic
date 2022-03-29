package leetcode.RotateArray;

/**
 * @author 黄忠
 */
/*
* 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
*输入: nums = [1,2,3,4,5,6,7], k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右轮转 1 步: [7,1,2,3,4,5,6]
向右轮转 2 步: [6,7,1,2,3,4,5]
向右轮转 3 步: [5,6,7,1,2,3,4]
* */
public class Solution {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[(i+k)%n] = nums[i];
        }
        System.arraycopy(h, 0, nums, 0,n);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums, k);
    }

}
