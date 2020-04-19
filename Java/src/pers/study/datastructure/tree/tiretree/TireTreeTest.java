package pers.study.datastructure.tree.tiretree;



import pers.study.FileOperation;
import pers.study.datastructure.mapset.BinarySearchTreeSet;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/4/16 1:17
 *
 * 测试对比，bst和tire操作用时，看看速度优化如何
 */
public class TireTreeTest {
    public static void main(String[] args) {
        System.out.println("pride-and-prejudice");
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("src\\pers\\study\\txt\\pride-and-prejudice.txt",words)){
            long start = System.nanoTime();
            BinarySearchTreeSet<String> binarySearchTreeSet = new BinarySearchTreeSet<>();
            for (String word: words){
                binarySearchTreeSet.add(word);
            }
            for (String word: words){
                binarySearchTreeSet.contains(word);
            }
            long end = System.nanoTime();
            double time = (end - start) / 1000000000.0;
            System.out.println("total different words:" + binarySearchTreeSet.size());
            System.out.println("BST:"+time+"s");


            start = System.nanoTime();
            TireTree tireTree = new TireTree();
            for (String word: words){
                tireTree.add(word);
            }
            for (String word: words){
                tireTree.contains(word);
            }
             end = System.nanoTime();

            time = (end - start) / 1000000000.0;
            System.out.println("total different words:" + tireTree.size());
            System.out.println("Tire:"+time+"s");
        }
    }
}
