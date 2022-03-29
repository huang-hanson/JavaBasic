package niuke.between;

import java.sql.SQLOutput;

/**
 * @author 黄忠
 */
public class Between {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 从给定字符集中，找出满足题目中between算法的字符串
     * @param chars string字符串 候选字符集
     * @param id1 string字符串
     * @param id2 string字符串
     * @return string字符串
     */
    public static String between(String chars, String id1, String id2) {
        // write code here
        if (chars.length()<2 || id1 == null || id2 == null) {
            return "Impossible";
        }
        StringBuilder res = new StringBuilder();
        res.append(id1);
        int middle = (chars.length()-1)/2;
        for (int i = 0; i < chars.length(); i++) {
            if (i == middle){
                res.append(chars.charAt(i));
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String chars = "";
        String id1 = "";
        String id2 = "";
        String b = between(chars, id1, id2);
        System.out.println(b);
    }
}
