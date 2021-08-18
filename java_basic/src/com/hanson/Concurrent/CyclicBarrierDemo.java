package com.hanson.Concurrent;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author 黄忠
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        int N = 4;
        //step1:定义CyclicBarrier
        CyclicBarrier barrier = new CyclicBarrier(N);
        for (int i = 0; i < N; i++) {
            new BusinessThread(barrier).start();
        }
    }
    //step2:定义业务线程
    static class BusinessThread extends Thread {
        private CyclicBarrier cyclicBarrier;
        //通过构造函数向线程传入cyclicBarrier
        public BusinessThread(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }
        @Override
        public void run() {
            try {
                //step3：执行业务线程逻辑，这里sleep 5s
                Thread.sleep(5000);
                System.out.println("线程执行前准备工作完成，等待其他线程准备工作完成");
                //step3:业务逻辑完成，等待其他线程也成为Barrier状态
                cyclicBarrier.await();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            //step4；所有线程已经成为barrier状态，开始执行下一项任务
            System.out.println("所有线程准备工作完成，执行下一项任务");
            //这里写需要并发执行的下一阶段的工作代码
        }
    }
}
