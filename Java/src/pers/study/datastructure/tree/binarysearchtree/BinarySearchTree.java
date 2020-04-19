package pers.study.datastructure.tree.binarysearchtree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author rookie
 * @date 2020/4/10
 * @param <E>  要具有可比性，所以继承接口 Comparable <E>
 */
public class BinarySearchTree<E extends Comparable<E>> {
    private class Node{
        E e; //存元素值
        Node left;
        Node right;
        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;
    public BinarySearchTree(){
        root = null;
        size = 0;
    }
    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    /**查询元素e*/
    public boolean contains(E e){
        return contains(root, e);
    }

    private boolean contains(Node node, E e){

        if(node == null) {
            return false;
        }

        if(e.compareTo(node.e) == 0) {
            return true;
        } else if(e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else // e.compareTo(node.e) > 0
        {
            return contains(node.right, e);
        }
    }
    public  void add(E e){
        if (root == null){
            root = new Node(e);
            size ++;
        }
        else {
            add(root,e);
        }

    }

        /**添加元素*/
      private Node add(Node node, E e) {
        if(node == null){
            size ++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0){
            node.left = add(node.left,e);
        }
        else if (e.compareTo(node.e) > 0){
            node.right = add(node.right,e);
        }
        return node;
    }

    /**前序遍历*/
    public void preOrder(){
          preOrder(root);
    }

    private void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.e);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**中序遍历*/
    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.e);
        inOrder(root.right);
    }

    /**后序遍历*/
    public void postOder(){
        postOder(root);
    }

    private void postOder(Node root) {
        if (root == null) {
            return;
        }
        postOder(root.left);
        postOder(root.right);
        System.out.println(root.e);
    }

    /**非递归实现遍历*/
    public  void preOderNR(){
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(root);
        while (!nodeStack.isEmpty()){
            Node cur = nodeStack.pop();
            System.out.println(cur.e);
            if (cur.right != null) {
                nodeStack.push(cur.right);
            }
            if (cur.left != null) {
                nodeStack.push(cur.left);
            }
        }
    }

    /**广度优先遍历，层序遍历*/
    public void levelTraversal(){
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()){
            Node cur = nodeQueue.remove();
            System.out.println(cur.e);
            if (cur.left != null){
                nodeQueue.add(cur.left);
            }
            if (cur.right != null){
                nodeQueue.add(cur.right);
            }
        }
    }

    /**查找最小元素*/
    public  E min(){
        if (size == 0) {
            throw new IllegalArgumentException("empty");
        }
        return min(root).e;

    }

    private Node min(Node node) {
        if (node.right == null) {
            return node;
        }
        return min(node.left);
    }

    /**删除最小元素*/
    public E removeMin(){
        E ret = min();
        removeMin(root);
        return ret;
    }

    private Node removeMin(Node node) {
        if (node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**查找最大元素*/
    public E max(){
        if (size == 0) {
            throw new IllegalArgumentException("empty");
        }
        return max(root).e;
    }

    private Node max(Node node) {
        if (node.right == null) {
            return node;
        }
        return max(node.right);
    }
    /**删除最大元素*/
    public E removeMax(){
        E ret = max();
        removeMax(root);
        return  ret;
    }

    private Node removeMax(Node node) {
        if (node.right == null){
            Node rightNode = node.left;
            node.left = null;
            size --;
            return rightNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    /**删除任意结点*/
    public void remove(E e){
        remove(root, e);
    }

    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) < 0){
            node.left = remove(node.left, e);
            return node;
        }
        else if(e.compareTo(node.e) > 0){
            node.right = remove(node.right, e);
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
            Node successor = min(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return  successor;
        }

    }

    /**floor（小的最大） ceil（大的最小）rank（排名）
     * select（用排名查询在哪里，是哪个数） 维护size（结点有多少的子节点，包括自己）
     * depth（深度值） count（可重复二分搜索树）方法*/

    /**用于求解最短路径*/
    public int run(Node root) {
        if(root == null) {
            return 0;
        }

        if(root.left == null && root.right == null) {
            return 1;
        }

        if(root.left == null) {
            return run(root.right) + 1;
        }

        if(root.right == null) {
            return run(root.left) + 1;
        }

        return Math.min(run(root.left) , run(root.right)) + 1;
    }
}
