package pers.study.datastructure.queue;


import pers.study.datastructure.array.Array;

/**
 * @author rookie
 * @date 2020/4/7
 */
public class ArrayQueue<E> implements Queue<E> {
    private Array<E> array;
    public ArrayQueue(int capacity){
        array = new Array<>(capacity);
    }
    public ArrayQueue(){
        array = new Array<>();
    }
    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public void add(E e) {
        array.addLast(e);
    }

    @Override
    public E remove() {
        return array.removeFirst();
    }

    @Override
    public E peek() {
        return array.getFirst();
    }

    @Override
    public int size() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue:");
        res.append("front[");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1){
                res.append(",");
            }

        }
        res.append("]tail");
        return res.toString();
    }
}
