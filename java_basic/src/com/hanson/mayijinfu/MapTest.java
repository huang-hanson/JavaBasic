package com.hanson.mayijinfu;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest {

    public static void main(String[] args) {//实例化一个集合对象
        Map map=new HashMap(); //添加数据 　　　　　　
        map.put("P01", "zhangSan");
        map.put("P02", "Lucy");
        map.put("PSex", "男");
        map.put("PAge", "39");
        map.put("PAge", "22");//key,重复会被后面的覆盖  　　　　　　//判断是否有一个key为PSex 　　　　　　

        if(map.containsKey("PSex")){
            System.out.println("存在");
        }
        System.out.println("集合大小:"+map.size());
        System.out.println("输出key为PAge的值:"+map.get("PAge"));

        //遍历出Map集合中所有数据　　　　　　
        Iterator it=map.keySet().iterator();
        while(it.hasNext()){
            String key=it.next().toString();
            System.out.println("key="+key+",value="+map.get(key));
        }

//        Set set=map.keySet();//取出map中所有的key并封装到set集合中　　　　　　
//        Iterator it=set.iterator();
//        while(it.hasNext()){
//            String key=it.next().toString();
//            System.out.println("key="+key+",value="+map.get(key));
//        }
    }
}