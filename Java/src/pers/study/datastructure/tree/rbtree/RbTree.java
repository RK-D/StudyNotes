package pers.study.datastructure.tree.rbtree;

 /**
 * @author rookie
 * @date 2020/2/10
  * 红黑树
  * @TODO 删除节点，左倾红黑树（本例），右倾红黑树， SplayTree（伸展树，局部性原理），基于红黑树的map set，其他优秀的红黑树实现
  *
 */
public class RbTree<K extends Comparable<K>, V> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node{
        public K key;
        public V value;
        public Node left, right;
        public boolean color;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            //染色
            color = RED;
        }
    }

    private Node root;
    private int size;

    public RbTree(){
        root = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    /**判断节点node的颜色*/
    private boolean isRed(Node node){
        if(node == null) {
            return BLACK;
        }
        return node.color;
    }

    /**向二分搜索树中添加新的元素(key, value)
     *rbTree 根节点为黑色
     *
     *
     * */
    public void add(K key, V value){
        root = add(root, key, value);
        root.color = BLACK;
    }

    /** 向以node为根的二分搜索树中插入元素(key, value)，
     * 递归算法,返回插入新节点后二分搜索树的根
     * 添加元素一个逻辑：（三节点，二节点适用于右倾）
     * 1左旋转:插入新得红结点，是红色结点的右孩子
     * 2右旋转:两个左倾的红结点，对黑界结点右旋转
     * 3颜色翻转:对两个红结点的一个黑结点都进行颜色翻转
     * 最后添加节点后，回溯向上维护
     */
    private Node add(Node node, K key, V value){

        if(node == null){
            size ++;
            return new Node(key, value);
        }

        if(key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if(key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else // key.compareTo(node.key) == 0
        {
            node.value = value;
        }
        //判断是否需要右旋转，左孩子黑，右孩子红
        if (isRed(node.right) && !isRed(node.left)){
            node = leftRotate(node);
        }
        //是否右旋转，左孩子红，左孩子的左孩子也红
        if(isRed(node.right) && isRed(node.left.left)){
            node = rightRotate(node);
        }
        if (isRed(node.left) && isRed(node.right)){
            flipColors(node);
        }
        return node;
    }


     /**返回以node为根节点的二分搜索树中，key所在的节点*/
    private Node getNode(Node node, K key){

        if(node == null) {
            return null;
        }

        if(key.equals(node.key)) {
            return node;
        } else if(key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else // if(key.compareTo(node.key) > 0)
        {
            return getNode(node.right, key);
        }
    }

    public boolean contains(K key){
        return getNode(root, key) != null;
    }

    public V get(K key){

        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    public void set(K key, V newValue){
        Node node = getNode(root, key);
        if(node == null) {
            throw new IllegalArgumentException(key + " doesn't exist!");
        }

        node.value = newValue;
    }

    /**返回以node为根的二分搜索树的最小值所在的节点*/
    private Node minimum(Node node){
        if(node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    /**删除掉以node为根的二分搜索树中的最小节点
     *
     * 返回删除节点后新的二分搜索树的根*/
    private Node removeMin(Node node){

        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    /**从二分搜索树中删除键为key的节点*/
    public V remove(K key){

        Node node = getNode(root, key);
        if(node != null){
            root = remove(root, key);
            return node.value;
        }
        return null;
    }
    /***/
    private Node remove(Node node, K key){

        if( node == null ) {
            return null;
        }

        if( key.compareTo(node.key) < 0 ){
            node.left = remove(node.left , key);
            return node;
        }
        else if(key.compareTo(node.key) > 0 ){
            node.right = remove(node.right, key);
            return node;
        }
        else{   // key.compareTo(node.key) == 0

            // 待删除节点左子树为空的情况
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }

            // 待删除节点右子树为空的情况
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }

            // 待删除节点左右子树均不为空的情况

            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;
        }
    }

    /**前序遍历，中后序稍改即可*/
    public void preOrder(){
        preOrder(root);
    }
    public void preOrder(Node node){
//       if (node==null)
//           return;
        /**第二种写法*/
        if (node!=null){
            System.out.println(node.key);
            preOrder(node.left);
            preOrder(node.right);
        }

    }
    /**改变原输出格式*/
    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        generateRBString(root,0,res);
        return res.toString();
    }

    private void generateRBString(Node node, int depth, StringBuilder res) {
        if (node==null){
            res.append(generateDepthString(depth)+"null\n");
            return;
        }
        res.append(generateDepthString(depth)+node.key+"\n");
        generateRBString(node.left,depth+1,res);
        generateRBString(node.right,depth+1,res);

    }

    private String generateDepthString(int depth) {
        StringBuilder res=new StringBuilder();
        for (int i=0 ; i < depth ;i++) {
            res.append("--");
        }
        return res.toString();
    }

    /**左旋转
     * node.right = x.left
     * x.left = node
     * x.color = node.color
     * node.color = RED
     * */
    private Node  leftRotate(Node node){
        Node x = node.right;
        //左旋转
        node.right = x.left;
        x.left = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    /**右旋转*/
    private Node rightRotate(Node node) {
        Node x = node.left;
        //右旋转
        node.left = x.right;
        x.right = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    /**颜色翻转*/
    private void flipColors(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }
}

