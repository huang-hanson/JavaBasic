package com.hanson.Concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo implements Runnable {

    //step1:定义一个ReentrantLock
    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 10; j++) {
            lock.lock();//step2：加锁
            //lock.lock();//可重入锁
            try {
                i++;
            }finally {
                lock.unlock();//step3:释放锁
                //lock.unlock();//可重入锁
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockDemo reentrantLock = new ReentrantLockDemo();
        Thread t1 = new Thread(reentrantLock);
        t1.start();
        t1.join();
        System.out.println(i);
    }
}
