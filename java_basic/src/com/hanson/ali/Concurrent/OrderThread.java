package com.hanson.ali.Concurrent;

import java.util.concurrent.Semaphore;

/**
 * @author 黄忠
 */
public class OrderThread {
    //利用信后来限制
    private static Semaphore s1 = new Semaphore(1);
    private static Semaphore s2 = new Semaphore(1);
    private static Semaphore s3 = new Semaphore(1);

    public static void main(String[] args) {

        try {
            //首先调用s2为acquire状态
            s1.acquire();
            s2.acquire();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            while (true) {
                try {
                    s1.acquire();
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("A");
                s2.release();
            }
        }).start();

        new Thread(()->{
            while (true) {
                try {
                    s2.acquire();
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("B");
                s3.release();
            }
        }).start();

        new Thread(()->{
            while (true) {
                try {
                    s3.acquire();
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("C");
                s1.release();
            }
        }).start();
    }
}
