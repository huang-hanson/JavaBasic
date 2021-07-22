package com.hanson.Concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newCachedThreadPool();//创建一个可缓存的线程池。
        for (int i = 0; i < 20; i++) {
            final int no=i;
            Runnable task=new Runnable() {
                @Override
                public void run() {
                    try{
                        System.out.println("into "+no);
                        Thread.sleep(10001L);
                        System.out.println("end "+no);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            };
            executorService.execute(task);
        }
        System.out.println("main thread have terminate");
        executorService.shutdown();
    }
}