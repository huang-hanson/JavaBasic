package com.hanson.DataStructure;

/**
 * @author 黄忠
 */
public class Node {
    private int value;
    private Node left;
    private Node right;
    private Node root;

    public Node(){

    }
    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
    public Node(int value){
        this(value,null,null);
    }
    public Node getLeft(){
        return this.left;
    }
    public void setLeft(Node left) {
        this.left = left;
    }
    public Node getRight() {
        return this.right;
    }
    public void setRight(Node right) {
        this.right = right;
    }
    public int getValue() {
        return this.value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    /*向二叉树中插入节点*/
    public void insertBST(int key) {
        Node p = root;
        /*记录查找节点的前一个节点*/
        Node prev = null;
        /*一直查找下去，直到到达满足条件的节点为止*/
        while (p != null) {
            prev = p;
            if (key < p.getValue()){
                p = p.getLeft();
            }else if (key > p.getValue()){
                p = p.getRight();
            }else {
                return;
            }
        }
        /*prev是待插入节点的父节点，根据节点值的大小，被插入相应的位置*/
        if (root == null){
            root = new Node(key);
        }else if (key < p.getValue()){
            prev.setLeft(new Node(key));
        }else {
            prev.setRight(new Node(key));
        }
    }
    /*
    * 删除二叉排序当中的节点
    * 分为三种情况：（删除节点*p，其父节点为*f）
    * （1）要删除*p节点为叶子节点，只需要修改他的双亲节点的指针为空
    * （2）若*p只有左子树或者只有右子树，则直接让左子树或右子树代替*p
    * （3）若*p既有左子树，又有右子树
    *       则用p左子树中的最大值（即最右端s）代替p，删除s，重接其左子树。
    * */
    public void deleteBST(int key){
        deleteBST(root,key);
    }
    private boolean deleteBST(Node node, int key){
        if (node == null) {
            return false;
        }else {
            if (key == node.getValue()){
                return  delete(node);
            }else if (key < node.getValue()){
                return deleteBST(node.getLeft(),key);
            }else {
                return deleteBST(node.getRight(), key);
            }
        }
    }
    private boolean delete(Node node) {
        Node temp = null;
        /*右子树空，只需要重接他的左子树
            如果是叶子节点，则在这里把叶子节点也删除了
        * */
        if (node.getRight()==null){
            temp = node;
            node = node.getLeft();
        }
        /*左子树空，重新接它的右子树*/
        else if (node.getLeft()==null){
            temp = node;
            node = node.getRight();
        }
        /*左右子数均不为空*/
        else {
            temp = null;
            Node s = node.getRight();
            /*转向左叶子数 然后向右走到尽头*/
            s = s.getLeft();
            while (s.getRight() != null){
                temp = s;
                s = s.getRight();
            }
            node.setValue(s.getValue());
            if (temp != node){
                temp.setRight(s.getLeft());
            }else {
                temp.setLeft(s.getLeft());
            }
        }
        return true;
    }

    /*
    * 查找二叉排序树中是否有key的值
    * */
    public boolean searchBST(int key){
        Node current = root;
        while (current != null) {
            /*等于当前值则查找成功，返回*/
            if (key == current.getValue()){
                return true;
                //比当前值小，进入做左叶子数中查找
            }else if (key < current.getValue()){
                current = current.getLeft();
            }else {
                //比当前值大，进入右叶子树中查找
                current = current.getRight();
            }
        }
        return false;
    }
}
