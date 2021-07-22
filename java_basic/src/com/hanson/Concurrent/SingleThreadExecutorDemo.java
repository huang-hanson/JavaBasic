package com.hanson.Concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorDemo {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newSingleThreadExecutor();//创建一个单线程的线程池。
        for (int i = 0; i < 10; i++) {
            final int no=i;
            Runnable task=new Runnable() {

                @Override
                public void run() {
                    try{
                        System.out.println("into "+no);
                        Thread.sleep(10000L);
                        System.out.println("end "+no);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            };
            //交由线程池处理任务
            executorService.execute(task);
        }
        executorService.shutdown();
        System.out.println("main thread have terminate");
    }
}