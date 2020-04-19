package pers.study.datastructure.mapset;

/**
 * @author Dongfanger
 * @date 2020/4/12
 */
public interface Set<E extends Comparable<E>> {

    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int size();

    boolean isEmpty();
}
