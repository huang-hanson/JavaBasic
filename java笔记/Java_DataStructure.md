### 1.1、栈及其java实现

- push（）：向栈中压入一个数据，先入栈的数据在最下面。
- pop（）：弹出栈顶数据，即移除栈顶数据。
- peek（）：返回当前的栈顶数据。

```java
package com.hanson.DataStructure;

/**
 * @author 黄忠
 * 基于数组实现顺序栈
 * @param<E>
 */
public class Stack<E>{
    private Object[] data =null;
    private int maxSize =0;//栈的容量
    private int top = -1;//栈顶指针
    //构造函数：根据指定的size初始化栈
    Stack() {
        this(10);//默认的栈大小为10
    }
    Stack(int initialSize){
        if (initialSize >= 0) {
            this.maxSize = initialSize;
            data = new Object[initialSize];
            top = -1;
        }else {
            throw new RuntimeException("初始化大小不能为0："+initialSize);
        }
    }
    //进栈，第一个元素top=0；
    public boolean push(E e) {
        if(top ==maxSize-1){
            throw new RuntimeException("栈已经满了，无法将元素入栈！");
        }else {
            data[++top]=e;
            return true;
        }
    }
    //弹出栈顶元素
    public E pop(){
        if(top == -1){
            throw new RuntimeException("栈为空1");
        }else {
            return (E)data[top--];
        }
    }
    //查看栈顶元素但是不能移除
    public E peek() {
        if (top == -1) {
            throw new RuntimeException("栈为空1");
        }else {
            return (E) data[top];
        }
    }
}
```

### 1.2、队列及其Java实现

- add（）：向队列的尾部加入一个元素（入栈），先入队列的元素在最前面。
- poll（）：删除队列头部的元素
- peek（）：取出队列头部的元素

```java
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
        if(empty()){
          throw new RuntimeException("空队列异常！");
        }else {
            E value = (E) data[front];
            data[front++] = null;
            return value;
        }
    }
    //取出队列头部元素，但是不能删除
    public E peek() {
        if (empty()){
            throw new RuntimeException("空队列异常1");
        }else {
            return (E) data[front];
        }
    }
}
```

### 1.3、链表

#### 1.3.1、单向链表

```java
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
```

#### 1.3.2、双向链表及其Java实现

### 二叉排序树

- 若左子树不为空，则左子树上的节点值均小于它的跟节点值；
- 若右子树不为空，则右子树上的节点值均大于或等于它的跟节点值；
- 左右叶子树也分别为二叉排序树

```java
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
```