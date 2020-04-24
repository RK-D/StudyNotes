package pers.study.datastructure.queue;

/**
 * @author rookie
 * @date 2020/4/7
 */
public interface Queue<E> {

    void add(E e);

    E remove();

    E peek();

    int size();

    boolean isEmpty();
}
