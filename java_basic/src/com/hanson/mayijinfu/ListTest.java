package com.hanson.mayijinfu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListTest {
    //ArrayList 　　　　
    static void testOne(){
        List list=new ArrayList(); //添加数据 　　　　　　
        list.add("abc");
        list.add("cba");
        list.add(123);
        list.add(0,"fist");
        //查看集合长度
        System.out.println("存放"+list.size()+"个元素");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        list.remove(0);//删除第一个元素 　　　　　　
        // 查看集合中是否包含cba 　　　　　　
        if(list.contains("cba")){
            System.out.println("包含元素cba");
        }  //取出集合中第二个元素 　　　　　　
        System.out.println("第二个元素是:"+list.get(1));  //取出集合中所有元素 　　　　　　
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    } //LinkedList　　　　　　
         static void testTwo(){
        LinkedList list=new LinkedList();//添加元素　　　　　　
        list.add("aaaa");
        list.add(123123);
        list.addFirst("1111111");
        list.addLast("2222222");
        list.add("33333333");
        System.out.println("元素个数:"+list.size());//取出第三个元素　　　　　　
        System.out.println("第三个元素是:"+list.get(2));//第一个元素　　　　　　
        System.out.println("第一个元素:"+list.getFirst());
        System.out.println("最后一个元素:"+list.getLast()); //删除第一个元素　　　　　　
        list.removeFirst();
        for (Object object : list) {
             System.out.println(object);
        }
    }
    public static void main(String[] args) {
        //testOne();
        testTwo();
    }
}