package com.hanson.Concurrent;


public class SynchronizedBlockDemo {
    String lockA = "lockA";
    public static void main(String[] args) {
        SynchronizedBlockDemo synchronizedBlockDemo = new SynchronizedBlockDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronizedBlockDemo.blockMethod1();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronizedBlockDemo.blockMethod2();
            }
        }).start();
    }
    //synchronized用于方法块，锁住的是在括号里面配置的对象
    public void blockMethod1() {
        try {
            synchronized (lockA){
                for (int i = 1; i < 3; i++) {
                    System.out.println("Method 1 execute");
                    Thread.sleep(3000);
                }
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //synchronized用于方法块，锁住的是在括号里面配置的对象
    public void blockMethod2() {
        try {
            synchronized (lockA){
                for (int i = 1; i < 3; i++) {
                    System.out.println("Method 2 execute");
                    Thread.sleep(3000);
                }
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
