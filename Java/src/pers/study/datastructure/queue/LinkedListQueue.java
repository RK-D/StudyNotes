package pers.study.datastructure.queue;

/**
 * @author rookie
 * @date 2020/4/9
 */
public class LinkedListQueue<E> implements Queue<E> {
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
    private Node head, tail;
    private int size;

    public LinkedListQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void add(E e){
        if(tail == null){
            //此处e不要漏否则报错
            tail = new Node(e);
            head = tail;
        }
        else{
            tail.next = new Node(e);
            tail = tail.next;
        }
        size ++;
    }
    @Override
    public E remove() {
        if (isEmpty()){
            throw new IllegalArgumentException("cannot dequeue from an empty queue");
        }
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        if (head == null){
            tail = null;

        }
        size --;
        return retNode.e;
    }

    @Override
    public E peek() {
        if (isEmpty()){
            throw new IllegalArgumentException(" queue is empty");
        }
        return head.e;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue:front ");
        Node cur = head;
        while(cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }
}
