package com.hanson.ali.Concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {

        Thread t1 = new Thread(()->{
         lock.lock();
         try {
             System.out.println("t1 started");
             Thread.sleep(5000);

             System.out.println("t1 completed");
         }catch (InterruptedException e) {
             e.printStackTrace();
         }finally {
             lock.unlock();
         }
        });


        Thread t2 = new Thread(()->{
            System.out.println("t1 started");
            while (lock.isLocked()){

            }
            System.out.println("t2 completed");
        });

        t2.start();
        t1.start();
    }
}
