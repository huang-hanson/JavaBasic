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
}
