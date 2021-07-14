package com.hanson.Generic;

import com.hanson.InnerClass.Worker;

import java.util.Date;

/**
 * @author 黄忠
 */
public class Generic {
    public static void main(String[] args) {
        generalMethod("1",2, new Worker() {
            @Override
            public int workTime() {
                return 0;
            }
        });
    }

    public static <T> void generalMethod(T ... inputArray){
        for (T element : inputArray){
            if (element instanceof Integer){
                System.out.println("处理Integer中的类型...");
            }else if (element instanceof String){
                System.out.println("处理String中的类型...");
            }else if (element instanceof Double){
                System.out.println("处理Double中的类型...");
            }else if (element instanceof Float){
                System.out.println("处理Float中的类型...");
            }else if (element instanceof Long){
                System.out.println("处理Long中的类型...");
            }else if (element instanceof Boolean){
                System.out.println("处理Boolean中的类型...");
            }else if (element instanceof Date){
                System.out.println("处理Date中的类型...");
            }else if (element instanceof Worker){
                System.out.println("处理Worker中的类型...");
            }
        }
    }
}
