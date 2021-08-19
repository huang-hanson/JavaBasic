package com.hanson.DataStructure;

/**
 * @author 黄忠
 */
public class SingleLinkedList {
    private int length;//链表节点个数
    private Node head;//头节点
    public SingleLinkedList(){
        int size = 0;
        head = null;
    }
    //链表每一个节点的数据结构描述类
    private class Node {
        private Object data;
        private Node next;
        public Node(Object data){
            this.data = data;
        }
    }
    //在链表头添加元素
    public  Object addHead(Object object){
        Node newHead = new Node(object);//step1：定义新节点
        if(length == 0){//step2:如果链表为空，则将该节点设置为头部节点
            head = newHead;
        }else {//step3：设置当前节点为头部节点，并将当前节点的下一个节点指向原来的头部节点
            head = newHead;
        }
        length ++;//step4:链表长度+1
        return object;
    }
    //删除指定元素，删除成功则返回true
    public boolean delete(Object value) {
        if (length == 0) {
            return false;
        }
        Node current =head;
        Node previous = head;
        while (current.data != value) {
            if (current.next == null) {
                return false;
            }
            else {
                previous = current;
                current = current.next;
            }
        }
        //如果删除的是头节点
        if (current == head){
            head = current.next;
            length --;
        }else {
            previous.next = current.next;
            length--;
        }
        return true;
    }

    //查找指定的元素，若找到了返回节点Node，找不到则返回null；
    public Node find(Object obj){
        Node current = head;
        int tempSize = length;
        while (tempSize > 0){
            if (obj.equals(current.data)){
                return current;
            }else {
                current = current.next;
            }
            tempSize--;
        }
        return null;
    }
}
