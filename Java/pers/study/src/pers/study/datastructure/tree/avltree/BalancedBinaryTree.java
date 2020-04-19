package pers.study.datastructure.tree.avltree;

import pers.study.datastructure.array.Array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author yd
 * @version 1.0
 * @date 2020/4/17 14:16
 *  满二叉树：出叶子结点外，都有左右孩子的二叉树（所以就是树填满了，家家都不是独生子女）
 *  完全二叉树：存在非叶子结点有孩子为空的存在，并且叶子结点们的深度值，相差<=1。（空缺在右下方）
 *  平衡二叉树：左右子树的高度差<=1,所以可能不是完全二叉树，存在倾斜可能，但不严重。
 *  AVL Tree: 平衡二叉树，基于二分搜索树修改，为了让树达到自平衡，添加height变量进行操作，为了保证
 */
public class BalancedBinaryTree<K extends Comparable<K>, V>{
    private class Node{
        public K key;
        public V value;
        public Node left, right;
        public int height;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            height = 1;
        }
    }

    private Node root;
    private  int size;
    public BalancedBinaryTree(){
        root = null;
        size = 0;
    }

    /***判断是否是一颗二分搜索树，
     * 利用前序遍历，判断是否升序*/
    public boolean isBinarySearchTree(){
        ArrayList<K> key = new ArrayList<>();
        inOrder(root,key);
        for (int i = 0; i < size-1; i++) {
            if (key.get(i).compareTo(key.get(i + 1)) > 0){
                return false;
            }
        }
        /**升序返回true，证明是二分搜索树*/
        return true;
    }

    /**中序遍历，递增*/
    private void inOrder(Node node, ArrayList<K> key) {
        if (node == null){
            return;
        }
        inOrder(node.left,key);
        key.add(node.key);
        inOrder(node.right,key);
    }
    /**获取结点高度，后期求结点平衡值使用*/
    private int getHeight(Node node){
        if (node == null){
            return 0;
        }
        return node.height;
    }
    /**获取平衡值（比较左右子树高度差，不能超过1） 后面用来判断是否是平衡二叉树用*/
    private int getBalanceTreeVal(Node node){
        if (node == null){
            return 0;
        }
//        return Math.abs(getHeight(node.left) - getHeight(node.right));
// 这里不使用 abs 后续判断左右倾斜有用，直接返回abs，影响后期判断倾斜方向，和本应该的左右旋转操作
        return getHeight(node.left) - getHeight(node.right);
    }
    /**判断是否是一颗平衡二叉树*/
    public boolean isBalancedTree(){
        return isBalancedTree(root);
    }

    /**考虑递归实现，从简单到容易，想递归到底，特殊然后到一半情况*/
    private boolean isBalancedTree(Node node){
        if (node == null){
            return true;
        }
        int balanceTreeVal = Math.abs(getBalanceTreeVal(node));
        /**1.当前节点的左右字数平衡值是否大于1 ，大于1不平衡
         * 2.否则，递归调用左右子节点，看子节点的子节点是否满足，层层递归，向下调用即可
         *
         * */
        if (balanceTreeVal > 1){
            return false;
        }
        else {
            return isBalancedTree(node.left) && isBalancedTree(node.right);
        }
    }

    public void add(K key, V value) {
        root = add(root,key, value);
    }
    /**映射，一一对应,默认同一个key进行重新赋值*/
    private Node add(Node node, K key, V value) {
        if (node == null){
            size ++;
            return new Node(key,value);
        }
        //下面两个递归add，调用后面的平衡操作，然后return node给下方的add，最终实现整棵树的平衡
        if (key.compareTo(node.key) < 0){
            node.left = add(node,key,value);
        }
        else if (key.compareTo(node.key) > 0){
            node.right = add(root,key,value);
        }
        else {
            node.value = value;
        }
        //更新node的height,在平衡值最大的子结点基础上加1 变成本省结点额平衡值
        node.height = 1 + Math.max(getHeight(node.left),getHeight(node.right));

        //计算平衡值 ，挑出大一遍的孩子记录，左孩子L 右孩子R
        //LL RR属于简单的单向倾斜，因此可以简单操作解决
        int balanceTreeVal = getBalanceTreeVal(node);
        if (Math.abs(balanceTreeVal) > 1){
            System.out.println("不平衡" + balanceTreeVal);
        }
        //LL:左孩子高度大于右孩子，左孩子的左孩子大于右孩子
        if (balanceTreeVal > 1 && getBalanceTreeVal(node.left) >= 0) {
            //做倾斜，右旋转
            return rightRotate(node);
        }
        //RR:右孩子大于最孩子高度，右孩子的左孩子又小于右孩子
        if (balanceTreeVal < -1 && getBalanceTreeVal(node.right) <= 0){
            return leftRotate(node);
        }

        //LR:左孩子高度大于右孩子，左孩子的左孩子小于右孩子
        if (balanceTreeVal > 1 && getBalanceTreeVal(node.left) < 0){
            //先左孩子，左旋转（把孩子的R变成L），链接上node的左孩子，变成 LL，然后node自身右旋转
            node.left = leftRotate(node.left);
            return  rightRotate(node);
        }
        //RL:右孩子大于最孩子高度，右孩子的左孩子又大于右孩子
        if (balanceTreeVal < -1 && getBalanceTreeVal(node.right) > 0){
            //先右孩子，右旋转（把孩子的L变成R），链接上node的right，变成RR，然后node自身左旋转
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    public Node getNode(Node node, K key){
        if (node == null) {
            return null;
        }
        if (key.compareTo(key) == 0){
            return node;
        }
        else if (key.compareTo(key) < 0){
            return getNode(node.left,key);
        }
        else {
            return getNode(node.right,key);
        }
    }




    public boolean contains(K key) {
        return getNode(root,key) != null;
    }


    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }


    public void set(K key, V newValue) {
        Node node = getNode(root,key);
        if (node == null){
            throw new IllegalArgumentException(key + "can`t set key is null");
        }
        node.value = newValue;
    }
    /**删除任意元素*/

    public V remove(K key) {
        Node node = getNode(root,key);
        if (node != null){
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K key) {
        if (node == null){
            return  null;
        }
        if (key.compareTo(node.key) < 0){
            node.left = remove(node.left, key);
            return node;
        }
        else if(key.compareTo(node.key) > 0){
            node.right = remove(node.right, key);
            return node;
        }
        else {
            if (node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }
            if (node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }
            Node successor = Min(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return  successor;
        }
    }

    private Node Min(Node node){
        if (node.left == null){
            return node;
        }
        return Min(node.left);
    }
    private Node removeMin(Node node){
        if (node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
        }else {
            node.left = removeMin(node.left);
        }
        return node;
    }


    private Node Max(Node node){
        if (node.right == null){
            return node;
        }
        return Max(node.right);
    }

    private Node removeMax(Node node){
        if (node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size --;
        }else {
            node.right = removeMax(node.right);
        }
        return node;
    }

    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }



    /**左倾斜，右旋转(在左子树连线上【3个根节点为例】，一般平衡值只要宜大于1 就平衡即 2时就旋转,无论怎么变，必须符合性质
     * 这里根据二分搜索树的性质：
     *  e1 < node2 < e2 < node1 < right2 < node < right1
     *               node                                   node1
     *             /     \                                /      \
     *          node1   right1                       node2        node
     *          /  \             ---->              /   \        /    \
     *      node2  right2                         e1     e2   right2  right1
     *     /   \
     *    e1    e2
     * 取中间的结点(node)和它的右子树(right2)，拆开，
     * node1 做新的根节点，node做node1的右孩子，node1右孩子right2做node左孩子)
     * 代码：
     * node1.right = node；
     * node.left = right2;
     * */
    private Node rightRotate(Node node){
        Node node1 = node.left;
        Node right2 = node1.right;
        //右旋转
        node1.right = node;
        node.left = right2;
        //更新高度，e1 e2 right1 right2本身都是叶子结点，所以不更新，只更新node 和node1，即右旋转的根节点和右孩子
        //PS：这里顺序是由将就的，自下而上，先更新右孩子，再更新根
        node.height = Math.max(getHeight(node.left),getHeight(node.right));
        node1.height = Math.max(getHeight(node.left),getHeight(node.right));
        return node1;
    }

    /**右倾斜，左旋转 与右旋转完全对立，参考右旋转
     * left1 < node < left2 < node1 < e1 < node2 < e2
     *        node                                      node1
     *       /    \                                    /     \
     *   left1   node1            向左旋转 (y)        node     node2
     *          /     \          - - - - - - - ->  /    \    /    \
     *        left2   node2                    left1 left2  e1    e2
     *                /    \
     *              e1     e2
     *代码：
     * node1.left = node;
     * node.right = left2;
     * */
    private Node leftRotate(Node node){
        Node node1 = node.right;
        Node left2 = node1.left;
        //右旋转
        node1.left = node;
        node.right = left2;
        //更新高度，e1 e2 right1 right2本身都是叶子结点，所以不更新，只更新node 和node1，即右旋转的根节点和右孩子
        //PS：这里顺序是由将就的，自下而上，先更新右孩子，再更新根
        node.height = Math.max(getHeight(node.left),getHeight(node.right));
        node1.height = Math.max(getHeight(node.left),getHeight(node.right));
        return node1;
    }
}
