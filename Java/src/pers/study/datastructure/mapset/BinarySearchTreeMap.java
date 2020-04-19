package pers.study.datastructure.mapset;


/**
 * @author rookie
 * @date 2020/4/13
 */
public class BinarySearchTreeMap<K extends Comparable<K>, V> implements Map<K, V> {
    private class Node{
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node root;
    private  int size;
    public BinarySearchTreeMap(){
        root = null;
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        root = add(root,key, value);
    }
    /**映射，一一对应,默认同一个key进行重新赋值*/
    private Node add(Node node, K key, V value) {
        if (node == null){
            size ++;
            return new Node(key,value);
        }
        if (key.compareTo(node.key) < 0){
            node.left = add(node,key,value);
        }
        else if (key.compareTo(node.key) > 0){
            node.right = add(root,key,value);
        }
        else {
            node.value = value;
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



    @Override
    public boolean contains(K key) {
        return getNode(root,key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root,key);
        if (node == null){
            throw new IllegalArgumentException(key + "can`t set key is null");
        }
        node.value = newValue;
    }
    /**删除任意元素*/
    @Override
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
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
