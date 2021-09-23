package com.hanson.ali.Concurrent.Volatile;

public class VolatileDemo2 {

    public static volatile boolean flag = true;

    public static void main(String[] args) {

        new Thread(()->{
            while (flag) {

            }
            System.out.println("=======end of Thread1============");
        }).start();
        try {
            Thread.sleep(100);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("turn flag off");
        flag=false;
    }
}
