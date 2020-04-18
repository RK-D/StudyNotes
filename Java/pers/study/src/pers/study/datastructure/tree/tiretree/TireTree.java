package pers.study.datastructure.tree.tiretree;

import java.util.TreeMap;

/**
 * @author yd
 * @version 1.0
 * @date 2020/4/16 0:32
 * 字典树，一种专门用于处理字符串的树，快速（N叉树）

 * n个条目情况下，使用树结构
 *                      字典                          Tire
 * 时间复杂度          O(log n)                    O(W) W为查询单词长度，与查询条目多少无关
 *
 * 这儿简单实现，不适用泛型，泛型分词依据不足
 * TireTree<C>
 *
 *     原则上这样实现的：
 *     根据一个单词，拆分然后一个个字母存储数据到节点中，然后对最后一个字母的isWord 标记为true 这样实现存储一个单词，
 *     同时可以快速查询，同时根节点不插入元素，而且是多差叉树
 * @ToDo 给二分搜索树左类似isPrefix 操作*/
public class TireTree {
    /**定义Node结点成员变量*/
    private class Node{
        public boolean isWord;
        public TreeMap<Character, Node> next;
        public Node(boolean isWord){
            this.isWord = isWord;
            next = new TreeMap<Character, Node>();
        }
        public Node(){
            this(false);
        }
    }
    /**私有变量根节点和size*/
    private Node root;
    private int size;
    /**公有构造方法*/
    public TireTree(){
        root = new Node();
        size = 0;
    }

    /**获取TireTree存储的单词数量*/
    public int size(){
        return size;
    }

    /**添加元素，ps：这儿是多叉树，类比二叉树
     * 向TireTree添加一个word:
     * 1.声明变量指向 root（根节点），此时在入口位置，
     * 2.遍历整个 word ，一个个字符取出g给变量c
     * 3.检查cur。next结点的 映射 是否已经有 指向 c 变量的字符的结点
     * 4.没有则创建新结点，map 用 put创建，*/
    public void  add(String word){
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null){
                cur.next.put(c,new Node());
            }
            /**遍历到底*/
            cur = cur.next.get(c);
        }
        /**结束存入操作，末尾设置成true，先判断该节点前这个单词不成立即为false*/
        if (! cur.isWord){
            cur.isWord = true;
            size ++;
        }
    }

    /**查询单词*/
    public boolean contains(String word){
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char s = word.charAt(i);
            if (cur.next.get(s) == null){
                return false;
            }
            cur = cur.next.get(s);
        }
        //查询到底，不能直接返回true，以免出错
        return cur.isWord;
    }
    /**前缀查询，字典查询*/
    public boolean isPrefix(String prefix){
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char s = prefix.charAt(i);
            if (cur.next.get(s) == null){
                return false;
            }
            cur = cur.next.get(s);
        }
        return true;
    }
}
