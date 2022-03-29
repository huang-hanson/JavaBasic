package leetcode.IargestPerimeter;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 黄忠
 */
public class largestPerimeter {

    public int getCode(int[] nums) {
        int l = nums.length,temp = l-1;
        if(l < 3){
            return 0;
        }
        Arrays.sort(nums);
        while(temp -2 > 1){
            if(nums[temp]<nums[temp-1]+nums[temp-2]){
                return nums[temp]+nums[temp-1]+nums[temp-2];
            }
            --temp;

        }
        return 0;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int nums_size = 0;
        nums_size = in.nextInt();
        int[] nums = new int[nums_size];
        for(int nums_i = 0; nums_i < nums_size; nums_i++) {
            nums[nums_i] = in.nextInt();
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }

        res = new largestPerimeter().getCode(nums);
        System.out.println(String.valueOf(res));

    }
}
