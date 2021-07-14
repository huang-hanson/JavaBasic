package com.hanson.Generic;

import java.util.Random;

/**
 * @author 黄忠
 */
//定义一个泛型接口
public interface IGeneral<T> {
    public T getId();
}

//定义泛型接口的实现类
class GeneralIntegerUmpl implements IGeneral<Integer>{

    @Override
    public Integer getId() {
        Random random = new Random();
        return random.nextInt(100);
    }

    public static void main(String[] args) {
        //使用泛型
        GeneralIntegerUmpl gen = new GeneralIntegerUmpl();
        System.out.println(gen.getId());
    }
}
