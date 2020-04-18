package pers.study.datastructure.stack;

/**
 * @author rookie
 */
public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    void  push(E e);
    E pop();
    E peek();
}
