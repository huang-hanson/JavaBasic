package com.hanson.niuke;

import java.util.concurrent.CountDownLatch;

public class TestStringBuilderAndStringBuffer {
    public static void main(String[] args) {
        //证明StringBuffer线程安全，StringBuilder线程不安全
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();
        CountDownLatch latch1 = new CountDownLatch(1000);
        CountDownLatch latch2 = new CountDownLatch(1000);
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        stringBuilder.append(1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        latch1.countDown();
                    }
                }
            }).start();
        }
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        stringBuffer.append(1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        latch2.countDown();
                    }

                }
            }).start();
        }
        try {
            latch1.await();
            System.out.println(stringBuilder.length());
            latch2.await();
            System.out.println(stringBuffer.length());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
