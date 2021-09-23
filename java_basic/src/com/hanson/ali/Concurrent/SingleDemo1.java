package com.hanson.ali.Concurrent;

public class SingleDemo1 {

    //private static SingleDemo1 singleDemo1 = new SingleDemo1();
    private static SingleDemo1 singleDemo1;
    private SingleDemo1() {

    }

    public static SingleDemo1 getInstance() {
        if (singleDemo1 == null) {
            synchronized (SingleDemo1.class){
                if (singleDemo1 == null) {
                    singleDemo1 = new SingleDemo1();
                }
            }
            //
        }
        return singleDemo1;
    }
}
