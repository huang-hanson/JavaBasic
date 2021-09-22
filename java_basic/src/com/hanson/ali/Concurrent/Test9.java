package com.hanson.ali.Concurrent;

public class Test9 {

    private static ThreadLocal<String> s= new ThreadLocal<>();

    public static void main(String[] args) {

        s.set("Hanson");
        String s1 = Test9.s.get();

    }
}
