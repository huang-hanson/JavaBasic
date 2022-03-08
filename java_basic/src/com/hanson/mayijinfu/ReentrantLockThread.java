package com.hanson.mayijinfu;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockThread implements Runnable{
/*    @Override
    public void run() {
        for (int i = 0 ;i < 3;i++){
            System.out.println(Thread.currentThread().getName() + "输出了"+i);
        }
    }*/

    //创建一个ReentrantLock对象

    ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        try {
            //使用lock（）方法
            lock.lock();
            for (int i = 0 ;i < 3;i++){
                System.out.println(Thread.currentThread().getName() + "输出了"+i);
            }
        }finally {
            //别忘掉了执行unlock()方法释放锁
            lock.unlock();
        }

    }
}
