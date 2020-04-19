package pers.study.datastructure.mapset;

/**
 * @author rookie
 * @date 2020/4/13
 */
public interface Map<K, V> {

    void add(K key, V value);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    void set(K key, V value);

    int size();

    boolean isEmpty();
}
