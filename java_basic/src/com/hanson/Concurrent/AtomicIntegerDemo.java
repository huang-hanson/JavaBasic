package com.hanson.Concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 黄忠
 */
class AtomicIntegerDemo implements Runnable{

    //step1:定义一个原子操作数
    static AtomicInteger safeCounter = new AtomicInteger(0);
    @Override
    public void run() {
        for (int m = 0; m < 1000000; m++) {
            safeCounter.getAndIncrement();//step2:对原子操作数执行自增操作
        }
    }
}

class AtomicIntegerDemoTest{
    public static void main(String[] args) throws InterruptedException{
        AtomicIntegerDemo mt = new AtomicIntegerDemo();
        Thread t1 = new Thread(mt);
        Thread t2 = new Thread(mt);
        t1.start();
        t2.start();
        Thread.sleep(500);
        System.out.println(mt.safeCounter.get());

    }
}
