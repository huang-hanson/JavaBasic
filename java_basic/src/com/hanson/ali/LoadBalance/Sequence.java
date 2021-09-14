package com.hanson.ali.LoadBalance;
//获取编号的工具
public class Sequence {
    public static Integer num = 0;
    public static Integer getAndIncrement() {
        return ++num;
    }
}
