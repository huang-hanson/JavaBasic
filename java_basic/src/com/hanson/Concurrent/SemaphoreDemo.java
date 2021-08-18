package com.hanson.Concurrent;

import java.util.concurrent.Semaphore;

/**
 * @author 黄忠
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        int printNumber = 5;//step1:设线程数，即员工数量
        Semaphore semaphore = new Semaphore(2);//step2：设置并发数，即打印机的数量
        for (int i = 1; i < printNumber+1;i++){
            new Worker(i,semaphore).start();
        }
    }
    static class Worker extends Thread {
        private  int num;
        private Semaphore semaphore;
        public Worker(int num,Semaphore semaphore){
            this.num = num;
            this.semaphore = semaphore;
        }
        @Override
        public void run() {
            try {
                semaphore.acquire();//step3：线程申请资源，即员工申请打印机
                System.out.println("员工"+this.num+"占用一个打印机...");
                Thread.sleep(2000);
                System.out.println("员工"+this.num+"打印完成，释放打印机");
                semaphore.release();//释放资源
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
