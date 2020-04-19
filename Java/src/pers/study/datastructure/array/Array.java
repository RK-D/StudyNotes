package pers.study.datastructure.array;

/**
 * @author rookie
 */
public class Array<E> {
    private  E[] data;
    private  int size;

    public Array (int capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }
    public Array(E[] arr){
        data = (E [])new Object[arr.length];
        for (int i = 0; i < arr.length; i++){
            data[i] = arr[i];
        }
        size = arr.length;
    }
    public Array(){
        this(10);
    }
    public  int getSize(){
        return size;
    }
    public int getCapacity(){
        return data.length;
    }
    public  boolean isEmpty(){
        return size == 0;
    }
    public void addLast(E e){
        add(size, e);
    }
    public void addFirst(E e){
        add(0,e);

    }

    /**添加元素*/
    public void add(int index,E e){

        if (index < 0 || index > size){
            throw  new IllegalArgumentException("error require index > 0");
        }
        if(size == data.length) {
            resize(2 * data.length);
        }

        for (int i = size - 1;i >= index; i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size ++;
    }

    /**获取元素*/
    public E get(int index){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("get error1");
        }
        return data[index];
    }

    /**获取头元素*/
    public E getLast(){
        return get(size - 1);
    }

    /**获取尾元素*/
    public E getFirst(){
        return get(0);
    }

    /**设置/更新元素*/
    public void set(int index,E e){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("get error2");
        }
        data[index] = e;
    }

    /**查找数组中元素e所在的索引，如果不存在元素e，则返回-1*/
    public int find(E e){
        for(int i = 0 ; i < size ; i ++){
            if(data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }
    /**查找数组中是否有元素e*/
    public boolean contains(E e){
        for(int i = 0 ; i < size ; i ++){
            if(data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }
    /**动态扩容*/
    private void resize(int newCapacity){

        E[] newData = (E[])new Object[newCapacity];
        for(int i = 0 ; i < size ; i ++)
            newData[i] = data[i];
        data = newData;
    }

    /**删除任意元素*/
    public E remove(int index){
        if (index < 0|| index >= size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }
        E ret = data[index];
        for(int i = index + 1 ; i < size ; i ++) {
            data[i - 1] = data[i];
        }
        size --;
        data[size] = null;


        if(size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    /**删除头元素*/
    public E removeFirst(){
        return remove(0);
    }

    /**删除尾元素*/
    public E removeLast(){
        return remove(size-1);
    }

  /**从数组中删除元素e*/
    public void removeElement(E e){
        int index = find(e);
        if(index != -1) {
            remove(index);
        }
    }

    /**交换元素*
     * 1.判断数是否越界 ？ x,y 是索引 : 索引范围在 0-size之间
     * 2.普通的交换数据，不区分x y索引的具体值谁大谁小
     */
    public void swap(int x, int y){
        if (x < 0 || x >= size || y < 0 || y  > size){
            throw new IllegalArgumentException(" Illegal cross-border");
        }
        E tmp = data[x];
        data[x] = data[y];
        data[y] = tmp;
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++){
            res.append(data[i]);
            if (i != size - 1){
                res.append(",");
            }
        }
        res.append(']');
        return res.toString();
    }
}
