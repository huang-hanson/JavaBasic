package closestValue;

import java.util.Arrays;

/**
 * @author 黄忠
 */
public class Solution {
    public static int closestValue(int[] array, int target) {
        // write code here
        int size = array.length;
        if (size < 2) {
            return -1;
        }
        Arrays.sort(array);
        int left = 0,right = size - 1,diff = Integer.MAX_VALUE;
        while (left < right) {
            int sum = array[left]+array[right];
            if (sum>target){
                right--;
            }else {
                diff=Math.min(diff,target-sum);
                left++;
            }
        }
        return diff ==Integer.MAX_VALUE ?-1:target-diff;
    }

    public static void main(String[] args) {
        int[] array={-1,-3,-5,-7,-9};
        int target = 5;
        int i = closestValue(array, target);
        System.out.println(i);
    }
}
