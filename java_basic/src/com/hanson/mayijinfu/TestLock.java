package com.hanson.mayijinfu;

import java.util.Calendar;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 黄忠
 */
public class TestLock {
    private ReentrantLock lock = null;
    public TestLock() {
        //创建一个自由竞争的可重入锁
        lock = new ReentrantLock();
    }

    public static void main(String[] args) {

        TestLock tester = new TestLock();

        try {
            // 测试可重入，方法testReentry() 在同一线程中,可重复获取锁,执行获取锁后，显示信息的功能
            tester.testReentry();
            // 能执行到这里而不阻塞，表示锁可重入
            tester.testReentry();
            // 再次重入
            tester.testReentry();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 释放重入测试的锁，要按重入的数量解锁，否则其他线程无法获取该锁。
            tester.getLock().unlock();
            tester.getLock().unlock();
            tester.getLock().unlock();
        }


    }
    public ReentrantLock getLock() {
        return lock;
    }

    public void testReentry(){
        lock.lock();

        Calendar now = Calendar.getInstance();

        System.out.println(now.getTime()+" "+Thread.currentThread().getName()+" get lock.");
    }
}
