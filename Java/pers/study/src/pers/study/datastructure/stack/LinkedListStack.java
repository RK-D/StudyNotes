package pers.study.datastructure.stack;


import pers.study.datastructure.linkedlist.LinkedList;

/**
 * @author rookie
 * @date 2020/4/9
 */
public class LinkedListStack<E> implements Stack<E> {
    private LinkedList<E> linkedList;
    public LinkedListStack(){
        linkedList = new LinkedList<>();
    }
    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("stack : top ");
        res.append(linkedList);
        return res.toString();
    }
}
