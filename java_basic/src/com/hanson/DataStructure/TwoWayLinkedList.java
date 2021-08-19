package com.hanson.DataStructure;

import org.w3c.dom.Node;

/**
 * @author 黄忠
 */
public class TwoWayLinkedList {
    private Node head;//表示链表头
    private Node tail;//表示链表尾
    private int length;//表示链表的长度
    private class Node {
        private Object data;
        private Node next;
        private Node prev;
        public Node(Object data){
            this.data = data;
        }
    }
    public TwoWayLinkedList(){
        int size = 0;
        head = null;
        tail = null;
    }
    //在表头增加节点
    public void addHead(Object value){
        Node newNode = new Node(value);
        if (length==0){
            head = newNode;
            tail = newNode;
            length++;
        }else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
            length++;
        }
    }
    //在链表尾增加节点
    public void addTail(Object value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
            length++;
        }else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
            length++;
        }
    }

    //删除链表的头部节点
    public Node deleteHead() {
        Node temp = head;
        if (length != 0){
            head = head.next;
            head.prev = null;
            length--;
            return temp;
        }else {
            return null;
        }
    }
    //删除链表的尾部节点
    public Node deleteTail() {
        Node temp = tail;
        if (length != 0) {
            tail = tail.prev;
            tail.next = null;
            length--;
            return temp;
        }
        else {
            return null;
        }
    }
}
