package pers.study.datastructure.mapset;

import pers.study.datastructure.tree.avltree.BalancedBinaryTree;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/4/24 14:31
 *
 * 基于avl树的map简单设计
 */
public class AvlTreeMap<K extends Comparable<K>, V> implements Map<K,V> {

    private BalancedBinaryTree<K,V> balancedBinaryTree;

    public AvlTreeMap(){
        balancedBinaryTree = new BalancedBinaryTree<>();
    }

    @Override
    public void add(K key, V value) {
        balancedBinaryTree.add(key,value);
    }

    @Override
    public V remove(K key) {
        return balancedBinaryTree.remove(key);
    }

    @Override
    public boolean contains(K key) {
        return balancedBinaryTree.contains(key);
    }

    @Override
    public V get(K key) {
        return balancedBinaryTree.get(key);
    }

    @Override
    public void set(K key, V value) {
        balancedBinaryTree.set(key, value);
    }

    @Override
    public int size() {
        return balancedBinaryTree.size();
    }

    @Override
    public boolean isEmpty() {
        return balancedBinaryTree.isEmpty();
    }
}
