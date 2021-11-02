package com.hanson.niuke;

public class MessageDemo {
    private String message; //类的成员变量
    public String getMessage() { //成员变量的getMessage()方法
        return message;
    }
    public MessageDemo(){  //无形参的构造方法
        message = "在构造方法中初始化成员变量";  //初始化成员变量
    }

    public static void main(String[] args) throws InstantiationException,IllegalAccessException {
        MessageDemo demo1 = new MessageDemo(); //使用构造方法创建一个实例demo1
        Class c = demo1.getClass(); //通过demo1获得类的Class对象
        //通过Class对象调用newInstance()方法，创建Demo2
        MessageDemo demo2 = (MessageDemo) c.newInstance();
        String info = demo2.getMessage(); //通过反射创建对象，获得类的信息
        System.out.println(info);
    }
}
