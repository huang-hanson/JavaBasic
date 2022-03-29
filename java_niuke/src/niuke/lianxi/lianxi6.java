package niuke.lianxi;

import java.util.Scanner;

public class lianxi6 {
    /*
    题目：利用条件运算符的嵌套来完成此题：学习成绩> =90分的同学用A表示，60-89分之间的用B表示，60分以下的用C表示。
    * */
    public static void main(String[] args) {
        int x;
        char grade;
        Scanner sc = new Scanner(System.in);
        System.out.println("输入一个成绩：");
        x = sc.nextInt();
        if (x >=90){
            System.out.println("等级为："+"A");
        }else if (x >= 60){
            System.out.println("等级为："+"B");
        }else {
            System.out.println("等级为："+"C");
        }
    }
}
