package com.hanson.ali.Concurrent;

import java.util.concurrent.Semaphore;

public class Test13 {

    static Semaphore semaphore = new Semaphore(3);

    public static void main(String[] args) throws InterruptedException{

        //线程1
        semaphore.acquire();

        //线程2
        semaphore.acquire();

        //线程3
        semaphore.acquire();

        //线程4
        semaphore.acquire();//阻塞

        //线程1
        semaphore.release();
    }
}
