package com.hanson.ali;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class Test {

    public static void main(String[] args) {
/*
        ArrayList arrayList = new ArrayList();
        arrayList.get(1);//查询
        arrayList.add(1);//扩容
        arrayList.add(1,1);

        LinkedList linkedList = new LinkedList();
        linkedList.get(1);//查询
        linkedList.getFirst();
        linkedList.getLast();
        linkedList.add(1);
        linkedList.add(1,1);//遍历找到对应的下标


        HashMap hashMap = new HashMap();
        hashMap.put(1,1);
*/

        //ThreadLocal
        Person person = new Person();

        new Thread(new Runnable() {

            @Override
            public void run() {
                person.setName("Hanson");
                try {
                    TimeUnit.SECONDS.sleep(3);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程1==="+person.getName());
            }
        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                person.setName("HuangZhong");
                try {
                    TimeUnit.SECONDS.sleep(3);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程2==="+person.getName());
            }
        }).start();


    }
}
