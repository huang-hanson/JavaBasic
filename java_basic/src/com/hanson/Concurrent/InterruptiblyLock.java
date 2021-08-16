package com.hanson.Concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 黄忠
 */
public class InterruptiblyLock {
    public ReentrantLock lock1 = new ReentrantLock();//step1：第一把锁lock1
    public ReentrantLock lock2 = new ReentrantLock();//step2：第二把锁lock2
    public Thread lock1(){
        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    lock1.lockInterruptibly();//step3.1:如果当前线程未被终端，则获取锁
                    try {
                        Thread.sleep(500);//step3.2：sleep 500ms，这里执行具体的业务逻辑
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock2.lockInterruptibly();
                    System.out.println(Thread.currentThread().getName() + "执行完毕！");
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    //step5.1:在业务逻辑执行以后，检查当前线程是否有该锁，如果持有锁则释放该锁
                    if(lock1.isHeldByCurrentThread()){
                        lock1.unlock();
                    }
                    if (lock2.isHeldByCurrentThread()){
                        lock2.unlock();
                    }
                    System.out.println(Thread.currentThread().getName() + "退出。");
                }
            }
        });
        t.start();
        return t;
    }
    public Thread lock2(){
        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    lock2.lockInterruptibly();//step3.1:如果当前线程未被终端，则获取锁
                    try {
                        Thread.sleep(500);//step3.2：sleep 500ms，这里执行具体的业务逻辑
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock1.lockInterruptibly();
                    System.out.println(Thread.currentThread().getName() + "执行完毕！");
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    //step5.1:在业务逻辑执行以后，检查当前线程是否有该锁，如果持有锁则释放该锁
                    if(lock1.isHeldByCurrentThread()){
                        lock1.unlock();
                    }
                    if (lock2.isHeldByCurrentThread()){
                        lock2.unlock();
                    }
                    System.out.println(Thread.currentThread().getName() + "退出。");
                }
            }
        });
        t.start();
        return t;
    }

    public static void main(String[] args) throws InterruptedException {
        long time = System.currentTimeMillis();
        InterruptiblyLock interruptiblyLock = new InterruptiblyLock();
        Thread thread1 = interruptiblyLock.lock1();
        Thread thread2 = interruptiblyLock.lock2();
        //自旋一段时间，如果等待时间过长，则可能发生了死锁等问题，主动中断并释放锁
        while(true){
            if (System.currentTimeMillis() - time >= 3000){
                thread2.interrupt();//中断线程1
            }
        }
    }
}

