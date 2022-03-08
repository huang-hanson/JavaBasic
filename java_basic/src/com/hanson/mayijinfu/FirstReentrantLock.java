package com.hanson.mayijinfu;


public class FirstReentrantLock {
    public static void main(String[] args) {
        Runnable runnable = new ReentrantLockThread();
        new Thread(runnable,"a").start();
        new Thread(runnable,"b").start();
    }
}
