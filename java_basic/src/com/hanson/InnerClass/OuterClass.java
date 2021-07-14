package com.hanson.InnerClass;

import java.io.OutputStreamWriter;

/**
 * @author 黄忠
 */
public class OuterClass {
    private static  String className = "staticInnerClass";
    private static int a;
    private int b;
    //定义一个静态的内部类
    public static class StaticInnerClass{
        public void getClassName(){
            System.out.println("className:"+className);
        }
    }

    //定义一个成员内部类
    public class MemberInnerClass{
        public void print(){
            System.out.println(a);
            System.out.println(b);
        }
    }

    public void partClassTest(final int c){
        final int d = 1;//局部内部类访问局部变量必须用final修饰
        //在partClassTest方法中定义一个局部内部类PastClass
        class PastClass{
            public void print(){
                System.out.println(c);
                System.out.println(d);
            }
        }
        PastClass pastClass = new PastClass();
        pastClass.print();
    }

    //定义一个匿名内部类

    public static void main(String[] args) {
        //调用静态内部类
        //StaticInnerClass staticInnerClass = new StaticInnerClass();
        OuterClass.StaticInnerClass staticInnerClass = new OuterClass.StaticInnerClass();
        //通过“外部内.静态内部类”方法进行调用
        staticInnerClass.getClassName();

        //调用成员内部类
        MemberInnerClass memberInnerClass = new OuterClass().new MemberInnerClass();
        memberInnerClass.print();

        //调用局部内部类
        OuterClass out = new OuterClass();
        out.partClassTest(3);
    }
}
