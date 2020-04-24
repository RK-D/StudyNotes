package pers.study.datastructure.mapset;

/**
 * @author rookie
 * @date 2020/4/13
 */
public class LinkedListMap<K, V> implements Map<K,V> {
    private class Node{
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
           this.key = key;
           this.value = value;
           this.next = next;
        }
        public Node(K key){
            this(key,null,null);
        }
        public Node(){
            this(null,null,null);
        }
        @Override
        public String toString(){
            return key.toString() + ":" + value.toString();
        }
    }


    public Node dummyHead;
    private int size;


    public LinkedListMap(){
        dummyHead = new Node();
        size = 0;
    }

    /**遍历寻找Key 是否存在*/
    private Node getNode(K key){
        Node cur = dummyHead.next;
        while (cur != null){
            if (cur.key.equals(key)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
    /**添加元素*/
    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (node == null){
            dummyHead.next = new Node(key,value,dummyHead.next);
            size ++;
        }
        else {
            node.value = value;
        }

    }

    @Override
    public V remove(K key) {
        Node prev = dummyHead;
        while (prev.next != null){
            if (prev.next.key.equals(key)) {
                break;
            }
            prev = prev.next;
        }
        if (prev.next != null){
            Node deleteNode = prev.next;
            prev.next = deleteNode.next;
            deleteNode.next = null;
            return deleteNode.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);

        return node == null ? null : node.value;
    }

    /**设置/ 更新元素*/
    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if (node == null){
            throw new IllegalArgumentException(key + "can`t set null key");
        }
        node.value = newValue;
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
