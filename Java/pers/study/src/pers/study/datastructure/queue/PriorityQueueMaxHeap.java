package pers.study.datastructure.queue;


import pers.study.datastructure.heap.MaxHeap;

/**
 * @author rookie
 * @date 2020/4/14
 * 优先队列-最大堆实现
 * java原先实现的是 最小堆不是最大堆
 */
public class PriorityQueueMaxHeap<E extends Comparable<E>> implements Queue<E> {
    private MaxHeap<E> maxHeap;
    public PriorityQueueMaxHeap(){
        maxHeap = new MaxHeap<>();
    }

    @Override
    public void add(E e) {
        maxHeap.add(e);
    }

    @Override
    public E remove() {
        return maxHeap.extractMax();
    }
    /**maxHeap 堆顶，队列头元素*/
    @Override
    public E peek() {
        return maxHeap.findMax();
    }

    @Override
    public int size() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }
}
