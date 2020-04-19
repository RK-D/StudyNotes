package pers.study.datastructure.tree.avltree;

import pers.study.FileOperation;

import java.util.ArrayList;

/**
 * @author HeYu-0126
 * @version 1.0
 * @date 2020/4/19 12:55
 */
public class BalancedBinaryTreeTest {
    public static void main(String[] args){

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("src\\pers\\study\\txt\\pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            BalancedBinaryTree<String, Integer> map = new BalancedBinaryTree<>();
            for (String word : words) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.add(word, 1);
                }
            }
            System.out.println("Total different words: " + map.size());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
            System.out.println("Is BST?: "+ map.isBinarySearchTree());
        }

        System.out.println();
    }
}
