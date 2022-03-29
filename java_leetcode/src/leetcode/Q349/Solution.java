package leetcode.Q349;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 黄忠
 */
public class Solution {
    public int[] intersection (int[] nums1, int[] nums2) {
        // write code here
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num:nums1){
            set1.add(num);
        }
        for (int num:nums2){
            set2.add(num);
        }
        return getIntersection(set1,set2);
    }

    public int[] getIntersection(Set<Integer> set1,Set<Integer> set2){
        if (set1.size()>set2.size()){
            return getIntersection(set2,set1);
        }
        Set<Integer> intersectionSet = new HashSet<>();
        for (int num:set1){
            if (set2.contains(num)){
                intersectionSet.add(num);
            }
        }
        int[] intersection = new int[intersectionSet.size()];
        int index = 0;
        for (int num:intersectionSet){
            intersection[index++]=num;
        }
        return intersection;
    }
}
