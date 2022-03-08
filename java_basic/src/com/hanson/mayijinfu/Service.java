package com.hanson.mayijinfu;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 黄忠
 */
public class Service {

    private ReentrantLock lock;

    public Service(boolean isFair) {
        lock = new ReentrantLock(isFair);
    }

    public void serviceMethod(){
        try {
            lock.lock();
            System.out.println("ThreadName=" + Thread.currentThread().getName()
                    + " 获得锁定");
        }finally {
            lock.unlock();
        }
    }
}
