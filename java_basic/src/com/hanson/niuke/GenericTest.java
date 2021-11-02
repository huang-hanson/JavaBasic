package com.hanson.niuke;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {

    public static void main(String[] args) {
          /*
          List list = new ArrayList();
          list.add("qqyumidi");
          list.add("corn");
          list.add(100);
          */

        List<String> list = new ArrayList<String>();
        list.add("qqyumidi");
        list.add("corn");
        //list.add(100);   // 1  提示编译错误

        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i); // 2
            System.out.println("name:" + name);
        }
    }
}