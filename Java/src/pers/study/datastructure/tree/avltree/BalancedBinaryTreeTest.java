package pers.study.datastructure.tree.avltree;

import pers.study.FileOperation;

import java.util.ArrayList;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/4/19 12:55
 */
public class BalancedBinaryTreeTest {
    public static void main(String[] args){

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("src\\pers\\study\\txt\\pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());
            long start = System.nanoTime();
            //添加操作
            BalancedBinaryTree<String, Integer> map = new BalancedBinaryTree<>();
            for (String word : words) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.add(word, 1);
                }
            }
            //查询操作
            long end = System.nanoTime();
            double time = (end - start) / 1000000000.0;
            System.out.println("AVL: "+ time + "s");
            System.out.println("Total different words: " + map.size());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
            System.out.println("Is BST?: "+ map.isBinarySearchTree());
            System.out.println("Is Balanced?: "+ map.isBalanced());

            for(String word : words){
                map.remove(word);
                if (!map.isBinarySearchTree() || !map.isBalanced()){
                    throw new RuntimeException("Error,AVL");
                }
            }
        }
    }
}
