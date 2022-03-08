package com.hanson.niuke;

/**
 * @author 黄忠
 */
public class Intern {
    public static void main(String[] args) {


        String yesB = new String("aaa")+new String("bbb");
        String yesC = yesB.intern();
        String yesA = "aaabbb";
        System.out.println(yesA == yesB);
        System.out.println(yesA == yesC);
    }
}
