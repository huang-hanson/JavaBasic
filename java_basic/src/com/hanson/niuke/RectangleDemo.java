package com.hanson.niuke;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class RectangleDemo {
    private Integer width;
    private Integer height;
    public RectangleDemo(){
        width = 20;
        height = 10;
    }

    public RectangleDemo(Integer width, Integer height){
        this.width = width;
        this.height = height;
    }

    public static void main(String[] args) throws SecurityException,
            NoSuchMethodException,IllegalArgumentException,
            InstantiationException,IllegalAccessException,
            InvocationTargetException {
        Class c = RectangleDemo.class; //获取类的Class对象
        //下面代码使用无参的构造方法RectangleDemo()创建对象
        Constructor constructor1 = c.getConstructor(); //通过Class对象获得构造对象
        RectangleDemo rect1 = (RectangleDemo) constructor1.newInstance(); //创建类的实例
        System.out.println("宽和高分别是："+rect1.width + ","+rect1.height); //输出通过反射获得的信息
        //下面代码使用有参的构造方法RectangleDemo(Integer width, Integer height)创建对象
        Constructor constructor2 = c.getConstructor(Integer.class, Integer.class); //获得构造器对象
        RectangleDemo rect2 = (RectangleDemo) constructor2.newInstance(80,50); //创建类的实例
        System.out.println("宽和高分别是："+rect2.width + ","+rect2.height); //输出对象的信息
    }
}
