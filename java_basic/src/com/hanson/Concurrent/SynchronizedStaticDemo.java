package com.hanson.Concurrent;

public class SynchronizedStaticDemo {
    public static void main(String[] args) {
        final SynchronizedStaticDemo synchronizedStaticDemo = new SynchronizedStaticDemo();
        final SynchronizedStaticDemo synchronizedStaticDemo2 = new SynchronizedStaticDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronizedStaticDemo.generalMethod1();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronizedStaticDemo2.generalMethod2();
            }
        }).start();
    }
    //synchronized静态同步方法，锁住的是当前类的class对象
    public static synchronized  void generalMethod1() {
        try {
            for (int i = 1; i < 3; i++) {
                System.out.println("generalMethod1 execute "+i+" time");
                Thread.sleep(3000);
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //synchronized静态同步方法，锁住的是当前类的class对象
    public static synchronized  void generalMethod2() {
        try {
            for (int i = 1; i < 3; i++) {
                System.out.println("generalMethod2 execute "+i+" time");
                Thread.sleep(3000);
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
