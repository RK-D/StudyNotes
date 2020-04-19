package pers.study.datastructure.heap;

import pers.study.datastructure.array.Array;;

/**
 * @author rookie
 * 二叉堆-最大堆-基于array实现
 * 性质：自定向下，从大到小。
 *堆本质：完全二叉树
 * */
public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }

    public MaxHeap(){
        data = new Array<>();
    }


    /**返回堆中元素个数*/
    public int size(){
        return  data.getSize();
    }

    /**判断堆中是否为空*/
    public boolean isEmpty(){
        return data.isEmpty();
    }

    /**父亲结点索引，在完全二叉数组中的表示*/
    public int parent(int index){
        if(index == 0){
            throw new IllegalArgumentException("array[0] null");
        }
        return (index - 1) / 2;
    }

    /**左子结点索引，在完全二叉数组中的表示*/
    public  int leftChild(int index){
        return index * 2 + 1;
    }

    /**右子结点索引，在完全二叉数组中的表示*/
    public  int rightChild(int index){
        return index * 2 + 2;
    }

    /**添加元素
     * 因为之前的动态数组会自动扩容所以不必过多考虑其他问题*/
    public void  add(E e){
        data.addLast(e);
        //传入索引然后对最大堆进行siftUp，上浮，保证最大堆得性质
        siftUp(data.getSize() - 1);
    }
    /**上浮元素，（保证最大堆，自上而下的从大到小）
     * 1.传入索引 e ，索引从0开始必须大于0才符合要求（计算从数组的头开始，至少根节点已经占用一个了，根节点已经最高，没必要==0时还上浮）
     * 2.比较索引与与其父亲结点的值，去判断是否上浮
     * */
    private void siftUp(int e) {
        while (e > 0 && data.get(parent(e)).compareTo(data.get(e)) < 0){
            data.swap(e,parent(e));
            e = parent(e);
        }
    }

    /**查找醉倒元素*/
    public E findMax(){
        if (data.getSize() == 0){
            throw new IllegalArgumentException("heap is empty,can`t operation it");
        }
        return data.get(0);
    }
    /**取出元素
     * 先将最小的结点替换根节点，然后下沉元素*/
    public E extractMax(){
        E ret = findMax();
        data.swap(0,data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }
    /**下沉元素
     * 传入索引 e ,选择左右孩子中最大的孩子结点比较，若小于孩子结点，交换元素
     * 极端: e为叶子结点，不必下沉（while进行判断，左孩子索引已经越界）*/
    public void siftDown(int e){
        while (leftChild(e) < data.getSize()){
            //e索引的左孩子赋值给 y
            int y = leftChild(e);
            //y+1右孩子 < size ---> 右孩子存在，比较左右孩子的值大小
            if (y + 1 < data.getSize() && data.get(y + 1).compareTo(data.get(y)) > 0){
                //data[y] 是 leftChild、 rightChild 的Max
                y = rightChild(e);
            }
            //比较传入的索引 e 的值是否比，左右孩子结点值大
            if(data.get(e).compareTo(data.get(y)) >= 0){
                break;
            }else {
                //交换，并重新赋值参数，进行递归验证
                data.swap(e,y);
                e = y;
            }
        }
    }

    /**replace操作： 取出最大元素后，放入一个新元素
     * 实现：
     * 1. 实现extractMax ，再add ，两次O（log n）
     * 2.实现直接将堆顶元素替换以后siftDown ，一次 O（log n）
     * */
    public E replace(E e){
        E result = findMax();
        data.set(0,e);
        siftDown(0);
        return result;
    }

    /**heapIfy操作： 将任意数组整理成堆形状（合理交换数据顺序）
     * 将n个元素插入到一个空堆中，复杂度O(n log n)
     * heapIfy 仅O(n)
     * 实现：
     * 1. 首先把数组看做完全二叉树（暂时不满足堆性质）
     * 2.从最后一个非叶子结点（结点K）进行计算,
     * 假设在数组（索引从0 开始，从1 开始后面index不用- 1，还有这事int类型除法，取整）中（求索引，最后一个结点的索引，求其父节点，调用parent（size - 1）即 （index - 1）/2 ）是不是很简单？
     * 3.比较k和他的叶子结点，是否需要siftDown ，（和最大的子节点交换一下就行）
     * */
    public MaxHeap(E[] arr){
        data = new Array<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }
}
