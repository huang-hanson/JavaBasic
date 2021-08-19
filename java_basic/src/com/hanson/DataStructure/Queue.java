package com.hanson.DataStructure;

/**
 * @author 黄忠
 */
public class Queue<E>{
    private Object[] data = null;
    private int maxSize;//队列的容量
    private int front;//队列头，允许删除
    private int rear;//队列尾，允许插入
    //构造函数，默认的队列大小为10
    public Queue(){
        this(10);
    }
    public Queue(int initialSize){
        if (initialSize >= 0) {
            this.maxSize = initialSize;
            data = new Object[initialSize];
            front = rear = 0;
        }else {
            throw new RuntimeException("初始化大小不能小于0："+initialSize);
        }
    }
    //在队列的尾部插入数据
    public boolean add(E e){
        if(rear == maxSize){
            throw new RuntimeException("队列已满，无法插入新元素！");
        }else {
            data[rear++]=e;
            return true;
        }
    }
    //删除头部的元素，出列
    public E poll(){
        if(front == rear){
          throw new RuntimeException("空队列异常！");
        }else {
            E value = (E) data[front];
            data[front++] = null;
            return value;
        }
    }
    //取出队列头部元素，但是不能删除
    public E peek() {
        if (front == rear){
            throw new RuntimeException("空队列异常!");
        }else {
            return (E) data[front];
        }
    }
}
