package com.hanson.ali.Concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @author 黄忠
 * @Date:created in 2021/9/22
 * @description:三个线程同时执行
 * CountDownLatch、CylicBarrier、Semaphore
 */
public class ThreadSafeDemo {

    public int count= 0;

    public void add(){count++;}

    public static void main(String[] args) throws InterruptedException{
        int size = 3;

        ThreadSafeDemo threadSafeDemo = new ThreadSafeDemo();

        CountDownLatch countDownLatch = new CountDownLatch(1);

        for (int i = 0; i < size; i++) {
            new Thread(()->{
                try {
                    countDownLatch.await();
                    System.out.println(System.currentTimeMillis());
                    //Thread.sleep(100);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        Thread.sleep(100);
        countDownLatch.countDown();

    }
}
