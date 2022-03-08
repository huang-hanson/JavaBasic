package com.hanson.niuke;

/**
 * @author 黄忠
 */
public class TestInner {
    int a = 2;
    static  int b =3;
    private String s;
    private static String d;
    class Inner1{
        void test(){
            System.out.println(a);
            System.out.println(b);
            System.out.println(s);
            System.out.println(d);
        }
    }
    static class Inner2{
        void test(){
            //System.out.println(a);//不可以访问非静态数据
            System.out.println(b);
            //System.out.println(s);//不可以访问非静态数据
            System.out.println(d);
        }
    }

}
