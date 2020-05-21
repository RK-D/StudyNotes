package pers.study.datastructure.linkedlist;

/**
 * @author rookie
 * @date 2020/4/8
 */


public class LinkedList<E> {
    //定义存储类型

    private class Node{
        public E e;
        public Node next;

        public  Node(E e,Node next){
            this.e = e;
            this.next = next;
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }
    //虚拟头结点，又称哑结点
    private Node dummyHead;
    //链表大小
    int size;

    //dummyHead方法实现 哑结点很重要
    public LinkedList(){
        dummyHead = new Node(null,null);
        size = 0;
    }
    //获取元素个数
    public int getSize(){
        return  size;
    }
    //查询链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }
    /** 向链表中间添加逻辑: (实际不常用)
     * index是位置，e是插入元素值
     * key:找到需要添加元素的前一个节点
     * 逻辑顺序不可以乱，必须先 node.next = prev.next 再  prev.next = node
     * 1.查询数组越界 --y (抛异常)
     * 2.当前Node的前一个结点设置为(哑结点) 这是链表头部的特殊处理 dummyHead不存在，用户不知道，知识写代码用
     * 3.依次遍历，找到插入的地方，
     *
     * */
    public void add(int index,E e){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("error");
        }
            //从dummyHead 开始寻找待插入结点
            Node prev = dummyHead;
            for (int i = 0; i < index; i++) {
                prev = prev.next;
            }
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;
            prev.next = new Node(e,prev.next);
            size++;
    }

    //头部添加元素
    public void addFirst(E e){
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
        add(0,e);
        size ++;
    }
    //末尾添加元素
    public void addLast(E e){
        add(size,e);
    }
    /**删除元素:
     *
     *
     * */
    public E remove(int index){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("error");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size --;
        return retNode.e;
    }
    public E removeFirst(){
        return remove(0);
    }
    //简单遍历，找到遍历的该节点，从头结点开始寻找，而不从哑结点开始，for的index条件相关
    public E get(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("error");
        }
        Node cur= dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }
    public E getFirst(){
        return get(0);
    }
    public E getLast(){
        return get(size - 1);
    }
    public void set(int index,E e){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("error");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }
    /**查询链表中是否有元素e*/
    public boolean contains(E e){
        Node cur = dummyHead.next;
        while (cur != null){
            if (cur.e.equals(e)){
                return  true;
            }
            cur =cur.next;
        }
        return false;
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
//        Node cur = dummyHead.next;
//        while (cur != null){
//            res.append(cur + "->");
//            cur = cur.next;
//        }
        for (Node cur = dummyHead.next;cur != null; cur = cur.next){
            res.append(cur + "->");
        }
        res.append("NULL");
        return res.toString();
    }
}
