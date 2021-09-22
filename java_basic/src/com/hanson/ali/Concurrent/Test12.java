package com.hanson.ali.Concurrent;

import java.util.concurrent.CountDownLatch;

public class Test12 {
    static CountDownLatch countDownLatch = new CountDownLatch(3);

    public static void main(String[] args) throws InterruptedException {

        //线程1
        countDownLatch.await();
        //线程5
        countDownLatch.await();

        //线程2
        countDownLatch.countDown();

        //线程3
        countDownLatch.countDown();

        //线程4
        countDownLatch.countDown();
    }
}
