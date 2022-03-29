package leetcode.IsValid;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class isValid {
    /* Write Code Here */
    public int isValid(String str_str) {
        HashMap<Character,Character> map = new HashMap(){{
            put('[',']');
            put('(',')');
            put('{','}');
        }};

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i <str_str.length(); i++){
            char s = str_str.charAt(i);
            if (map.containsKey(s)){
                stack.push(s);
            }else {
                if (stack.isEmpty()){
                    return 0;
                }
                if (map.get(stack.pop())!=s){
                    return 0;
                }
            }
        }
        return  1;
    }



    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        String str_str;
        try {
            str_str = in.nextLine();
        } catch (Exception e) {
            str_str = null;
        }

        res = new isValid().isValid(str_str);
        System.out.println(String.valueOf(res));

    }
}
