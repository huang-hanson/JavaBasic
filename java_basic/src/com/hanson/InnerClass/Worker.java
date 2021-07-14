package com.hanson.InnerClass;

/**
 * @author 黄忠
 */
public abstract class Worker {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public abstract int workTime();
}

class Test{
    public void test(Worker worker){
        System.out.println(worker.getName()+"工作时间："+worker.workTime());
    }

    public static void main(String[] args) {
        Test test = new Test();
        //在方法中定义并使用一个匿名内部类
        test.test(new Worker(){
            @Override
            public int workTime(){
                return 8;
            }
            @Override
            public String getName() {
                return "alex";
            }
        });
    }
}