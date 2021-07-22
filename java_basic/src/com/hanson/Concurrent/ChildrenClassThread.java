package com.hanson.Concurrent;

public class ChildrenClassThread implements Runnable  {
    //step1:通过实现Runnable接口方式来创建ChildrenClassThread线程
    @Override
    public void run() {
        System.out.println("create a thread by implements Runnable");
    }

    public static void main(String[] args) {
        //step2：实现一个ChildrenClassThread对象
        ChildrenClassThread childrenClassThread = new ChildrenClassThread();
        //step3：创建一个线程对象并将其传入已经实例化好的ChildrenThread实例
        Thread thread = new Thread(childrenClassThread);
        //step4：调用start方法启动一个线程
        thread.start();
    }
}
