package com.hanson.Concurrent;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

//step1:通过实现Callable接口创建一个MyCallable线程
public class MyCallable  implements Callable<String> {
    private String name;
    public MyCallable(String name){//通过构造函数为线程传递参数，以定义线程的名称
        this.name = name;
    }
    @Override
    public String call() throws Exception {//call方法内为线程实现的逻辑
        return name;
    }
    public static void main(String[] args) {
        //step2：创建一个固定大小为5的线程池
        ExecutorService pool = Executors.newFixedThreadPool(5);
        //step3:创建有多个返回值列表的任务列表list
       List<Future> list = new ArrayList<>();
       for (int i = 0; i < 5; i++) {
           //step4：创建一个有返回值类型的线程实例
           Callable c = new MyCallable(i + " ");
           //step5:提交线程，获取Future对象并将其保存在Future List中
           Future future = pool.submit(c);
           System.out.println("submit a callable thread:"+i);
           list.add(future);
       }
       //step6：关闭线程池，等待线程执行结束
       pool.shutdown();
       for (Future future : list){
           //step7：对象上获取任务的返回值，并将结果输出给控制台
           System.out.println("get the result from callable thread:"+future.toString());
       }
    }
}




