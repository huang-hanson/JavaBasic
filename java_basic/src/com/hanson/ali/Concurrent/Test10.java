package com.hanson.ali.Concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class Test10 {


    static ReentrantLock reentrantLock = new ReentrantLock();


    public static void main(String[] args) {



        reentrantLock.lock();

        reentrantLock.lock();

        reentrantLock.unlock();

        reentrantLock.unlock();
    }
}
