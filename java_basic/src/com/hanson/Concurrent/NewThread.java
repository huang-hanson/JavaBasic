package com.hanson.Concurrent;

/**
 * @author 黄忠
 */
//step:1通过继承一个Thread类创建NewThread线程
public class NewThread extends Thread{

    @Override
    public void run() {
        System.out.println("create a thread by extends Thread");
    }

    public static void main(String[] args) {
        //step 2：实例化一个NewThread线程对象
        NewThread newThread = new NewThread();

        //step 3:调用start方法启动NewThread线程
        newThread.start();
    }
}

