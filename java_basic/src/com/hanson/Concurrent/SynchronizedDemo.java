package com.hanson.Concurrent;

/**
 * @author 黄忠
 */
public class SynchronizedDemo {
    public static void main(String[] args) {
        final SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronizedDemo.generalMethod1();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronizedDemo.generalMethod2();
            }
        }).start();
    }
    //synchronized修饰普通的同步方法，锁住当前的实例对象
    public synchronized void generalMethod1() {
        try {
            for (int i = 1; i < 3; i++) {
                System.out.println("generalMethod1 execute "+i+" time");
                Thread.sleep(3000);
            }

        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //synchronized修饰普通的同步方法，锁住当前的实例对象
    public synchronized void generalMethod2() {
        try {
            for (int i = 1; i < 3; i++) {
                System.out.println("generalMethod2 execute " + i + " time");
                Thread.sleep(3000);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("-----------------------------");
        final SynchronizedDemo synchronizedDemo1 = new SynchronizedDemo();
        final SynchronizedDemo synchronizedDemo2 = new SynchronizedDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronizedDemo1.generalMethod1();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronizedDemo2.generalMethod2();
            }
        }).start();

    }
}
