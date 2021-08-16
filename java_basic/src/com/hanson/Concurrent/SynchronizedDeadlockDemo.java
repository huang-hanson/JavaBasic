package com.hanson.Concurrent;

public class SynchronizedDeadlockDemo {
    String lockA = "lockA";
    String lockB = "lockB";
    public static void main(String[] args) {
        final SynchronizedDeadlockDemo synchronizedDeadlockDemo = new SynchronizedDeadlockDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronizedDeadlockDemo.blockMethod1();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronizedDeadlockDemo.blockMethod2();
            }
        }).start();
    }
    //synchronized用于同步方法块，锁住的是在括号里面配置的对象
    public void blockMethod1() {
        try {
            synchronized (lockA){
                for (int i = 1; i < 3; i++) {
                    System.out.println("Method 1 execute");
                    Thread.sleep(3000);
                    synchronized (lockB){}
                }
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //synchronized用于同步方法块，锁住的是在括号里面配置的对象
    public void blockMethod2() {
        try {
            synchronized (lockB){
                for (int i = 1; i < 3; i++) {
                    System.out.println("Method 2 execute");
                    Thread.sleep(3000);
                    synchronized (lockA) {}
                }
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
