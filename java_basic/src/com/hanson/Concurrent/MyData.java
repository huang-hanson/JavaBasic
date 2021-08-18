package com.hanson.Concurrent;

/**
 * @author 黄忠
 */
public class MyData {
    //step1:将数据抽象成MyData类，并将数据的操作（add、dec等）作为类的方法
    private int j = 0;
    public synchronized void add(){
        j++;
        System.out.println("线程"+Thread.currentThread().getName()+"j为:"+j);
    }
    public synchronized void dec() {
        j--;
        System.out.println("线程"+Thread.currentThread().getName()+"j为:"+j);
    }
    public int getData() {
        return j;
    }
    public static void main(String[] args) {
        MyData myData = new MyData();
        AddRunnable addRunnable = new AddRunnable(myData);
        DecRunnable decRunnable = new DecRunnable(myData);
        for (int i = 0; i < 2;i++){
            new Thread(addRunnable).start();
            new Thread(decRunnable).start();
        }
    }
}

class AddRunnable implements Runnable {
    MyData data;
    //step2：线程使用该类的对象并调用类的方法对数据进行操作
    public AddRunnable(MyData data){
        this.data = data;
    }
    @Override
    public void run() {
        data.add();
    }
}

class DecRunnable implements Runnable {
    MyData data;
    //step2：线程使用该类的对象并调用类的方法对数据进行操作/./
    public DecRunnable(MyData data){
        this.data = data;
    }
    @Override
    public void run() {
        data.dec();
    }
}
class TestThread{
    public static void main(String[] args) {
        final MyData data = new MyData();
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    data.add();
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    data.dec();
                }
            }).start();
        }
    }
}

