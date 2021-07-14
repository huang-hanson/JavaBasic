package com.hanson.Serialization;

import java.io.*;

/**
 * @author 黄忠
 */
//通过实现Serializable接口可序列化的Worker类
public class Worker implements Serializable {
    //定义序列化的ID
    private static final long serialVersionUID = 123456789L;
    //name属性将被序列化
    private String name;
    //transient修饰的属性将不被序列化
    private transient int salary;
    //静态变量属于类信息，不属于对象的状态，因此不会被序列化
    static  int age = 100;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws Exception{
        //序列化数据到磁盘
        FileOutputStream fos = new FileOutputStream("worker.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Worker testObject = new Worker();
        testObject.setName("Hanson");
        oos.writeObject(testObject);
        oos.flush();
        oos.close();
        //反序列化磁盘数据并解析数据状态
        FileInputStream fis = new FileInputStream("worker.out");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Worker deTest =(Worker) ois.readObject();
        System.out.println(deTest.getName());
    }

}
