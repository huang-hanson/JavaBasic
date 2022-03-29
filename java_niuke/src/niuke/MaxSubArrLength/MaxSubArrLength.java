package niuke.MaxSubArrLength;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author 黄忠
 */
public class MaxSubArrLength {

    public static int maxSubArrLength(int[] arr) {
        // write code here
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        int left = 0;
        int right = 0;
        while (right < arr.length) {
            if (!set.contains(arr[right])){
                set.add(arr[right]);
                right++;
                if (set.size()>res){
                    res = set.size();
                }
            }else {
                set.remove(arr[right]);
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {
                -1,0,1,2,-1,-4
        };
        int i = maxSubArrLength(arr);
        System.out.println(i);
    }
}
