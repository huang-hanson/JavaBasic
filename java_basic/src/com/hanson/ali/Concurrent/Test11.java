package com.hanson.ali.Concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class Test11 {
    static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {

        reentrantLock.unlock();//阻塞加锁
        // 其他代码


        boolean result = reentrantLock.tryLock();//非阻塞，返回true  加到锁

        //自旋锁
        while (!reentrantLock.tryLock()){
            //其他的事情
        }
        //其他代码
    }
}
