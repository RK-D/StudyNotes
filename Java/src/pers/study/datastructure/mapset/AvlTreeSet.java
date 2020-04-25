package pers.study.datastructure.mapset;

import pers.study.datastructure.tree.avltree.BalancedBinaryTree;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/4/24 14:31
 *
 * 基于avl树的set简单设计
 */
public class AvlTreeSet<E extends Comparable<E>> implements Set<E> {
    private BalancedBinaryTree<E, Object> balancedBinaryTree;

    public AvlTreeSet(){
        balancedBinaryTree = new BalancedBinaryTree<>();
    }

    @Override
    public void add(E e) {
        balancedBinaryTree.add(e, null);
    }

    @Override
    public void remove(E e) {
        balancedBinaryTree.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return balancedBinaryTree.contains(e);
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
