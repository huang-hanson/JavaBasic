package com.hanson.Generic;

/**
 * @author 黄忠
 */
public class GeneralClass<T> {
    public static void main(String[] args) {
        //根据需求初始化不同的类型
        GeneralClass<Integer> genInt = new GeneralClass<Integer>();
        genInt.add(1);
        GeneralClass<String> genStr = new GeneralClass<>();
        genStr.add("2");
    }
    private T t;
    public void add(T t){
        this.t = t;
    }
    public T get() {
        return t;
    }
}
