package com.hanson.niuke;

import java.util.concurrent.TimeUnit;

public class WaitNotifyCase {
    public static void main(String[] args) {
        final Object lock = new Object();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程A等待获取锁");
                synchronized (lock){
                    try {
                        System.out.println("线程A得到锁");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("线程A等待方法");
                        lock.wait();
                        System.out.println("等待结束");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程B等待获取锁");
                synchronized (lock){
                    System.out.println("线程B得到锁");
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.notify();
                    System.out.println("线程B唤醒方法");
                }
            }
        }).start();
    }
}
