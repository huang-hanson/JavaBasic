package com.hanson.ali.Concurrent;


/**
 * @author 黄忠
 */
public class OrderThread2 {

    static volatile int ticket = 1;

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            while (true) {
                if (ticket==1){
                    try {
                        Thread.sleep(100);
                        for (int i = 0; i < 10; i++) {
                            System.out.println("a"+i);
                        }
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ticket = 2;
                    return;
                }
            }
        });

        Thread t2 = new Thread(()->{
            while (true) {
                if (ticket==2){
                    try {
                        Thread.sleep(100);
                        for (int i = 0; i < 10; i++) {
                            System.out.println("b"+i);
                        }
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ticket = 3;
                    return;
                }
            }
        });

        Thread t3 = new Thread(()->{
            while (true) {
                if (ticket==3){
                    try {
                        Thread.sleep(100);
                        for (int i = 0; i < 10; i++) {
                            System.out.println("c"+i);
                        }
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ticket = 1;
                    return;
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
