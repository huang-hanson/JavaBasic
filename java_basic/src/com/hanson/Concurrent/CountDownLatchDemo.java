package com.hanson.Concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) {
        //step1：定义一个大小为2的CountDownLatch
        final CountDownLatch latch = new CountDownLatch(2);
        new Thread(){public void run() {
                try {
                    System.out.println("子线程1"+"正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程1"+"执行完毕");
                    latch.countDown();//step2.1：在子线程1执行完毕后调用countdown方法
                }catch (Exception e) {
                    e.printStackTrace();
                }}}.start();

        new Thread(){public void run() {
            try {
                System.out.println("子线程2"+"正在执行");
                Thread.sleep(3000);
                System.out.println("子线程2"+"执行完毕");
                latch.countDown();//step2.2：在子线程2执行完毕后调用countdown方法
            }catch (Exception e) {
                e.printStackTrace();
            }}}.start();
        try {
            System.out.println("等待两个子线程执行完毕...");
            latch.await();//step3：在countdown上等待子线程执行完毕。
            //step4:子线程执行完毕，开始执行主线程
            System.out.println("两个子线程已经执行完毕，继续执行主线程");
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
