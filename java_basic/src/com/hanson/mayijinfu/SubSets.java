package com.hanson.mayijinfu;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author 黄忠
 */
public class SubSets {


    public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(S == null){return res;}
        //Arrays.sort(S);
        int len = S.length;
        ArrayList<Integer> stack = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        for(int k = 1; k <= len; ++k){
            dfs(res, stack, S, 0, k, len);
        }
        return res;
    }

    private static void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> stack,
                            int[] S, int index, int k, int len){
        if(k == 0){
            res.add(new ArrayList<>(stack));
            return;
        }
        if(index >= len){return;}
        stack.add(S[index]);
        dfs(res, stack, S, index + 1, k - 1, len);
        stack.remove(stack.size() - 1);
        dfs(res, stack, S, index + 1, k, len);
    }

    public static void main(String[] args) {
        int[] S = {3,2,1};
        System.out.println("输入前数组"+Arrays.toString(S));

        System.out.println((subsets(S)));
    }


}
