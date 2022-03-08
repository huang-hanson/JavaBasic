package com.hanson.mayijinfu;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        final Service service = new Service(false);  //改为false就为非公平锁了
        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println("**线程： " + Thread.currentThread().getName()
                        +  " 运行了 " );
                service.serviceMethod();
            }
        };

        Thread[] threadArray = new Thread[10];

        for (int i=0; i<10; i++) {
            threadArray[i] = new Thread(runnable);
        }
        for (int i=0; i<10; i++) {
            threadArray[i].start();
        }
    }
}
