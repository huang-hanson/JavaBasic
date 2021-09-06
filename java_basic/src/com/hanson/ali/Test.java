package com.hanson.ali;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Test {

    public static void main(String[] args) {
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
        hashMap.put();
    }
}
