package com.hanson.mayijinfu;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) {
        Set set=new HashSet();
        set.add("abc");
        set.add("cba");
        set.add("abc");//故意重复　
        set.add(123);
        set.add(true);
        System.out.println("集合元素个数:"+set.size());
        Iterator it=set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}

