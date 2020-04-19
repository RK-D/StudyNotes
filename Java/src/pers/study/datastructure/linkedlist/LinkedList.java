package pers.study.datastructure.linkedlist;

/**
 * @author rookie
 * @date 2020/4/8
 */
public class LinkedList<E> {
    private class Node{
        public E e;
        public Node next;
        public  Node(E e,Node next){
            this.e = e;
            this.next = next;
        }
        public Node(E e){
            this(e,null);
        }
        public Node(){
            this(null,null);
        }
        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node dummyHead;
    int size;
    public LinkedList(){
        dummyHead = new Node(null,null);
        size = 0;
    }
    public int getSize(){
        return  size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public void add(int index,E e){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("error");
        }
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
    public void addFirst(E e){
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
        add(0,e);
        size ++;
    }
    public void addLast(E e){
        add(size,e);
    }
    /**删除元素*/
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
