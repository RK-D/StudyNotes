package pers.study.datastructure.mapset;


import pers.study.datastructure.tree.binarysearchtree.BinarySearchTree;

/**
 * @author rookie
 * @date 2020/4/12
 */
public class BinarySearchTreeSet<E extends Comparable<E>> implements Set<E> {
    private BinarySearchTree<E> binarySearchTree;

    public BinarySearchTreeSet() {
        binarySearchTree = new BinarySearchTree<>();
    }

    /**去重*/
    @Override
    public void add(E e) {
        binarySearchTree.add(e);
    }

    @Override
    public void remove(E e) {
        binarySearchTree.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return binarySearchTree.contains(e);
    }

    @Override
    public int size() {
        return binarySearchTree.size();
    }

    @Override
    public boolean isEmpty() {
        return binarySearchTree.isEmpty();
    }
}
