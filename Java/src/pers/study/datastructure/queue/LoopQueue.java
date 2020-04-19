package pers.study.datastructure.queue;

/**
 * @author rookie
 * @date 2020/4/7
 */
public class LoopQueue<E> implements Queue<E>{
    public E[] data;
    public int front,tail;
    private int size;
    public LoopQueue(int capacity){
        data = (E[])new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }
    public LoopQueue(){
        this(10);
    }
    public int getCapacity(){
        return data.length - 1;
    }

    @Override
    public void add(E e) {
        if ((tail + 1) % data.length == front){
            resize(getCapacity()*2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }



    @Override
    public E remove() {
        if (isEmpty()){
            throw new IllegalArgumentException("ERROR");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0){
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E peek() {
        if (isEmpty()){
            throw new IllegalArgumentException("error empty");
        }

        return data[front];
    }

    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front[");
        for (int i = 0; i != tail; i = (i+1) % data.length){
            res.append(data[i]);
            if ((i + 1) % data.length != tail){
                res.append(",");
            }
        }
        res.append("]tail");
        return res.toString();
    }
}
