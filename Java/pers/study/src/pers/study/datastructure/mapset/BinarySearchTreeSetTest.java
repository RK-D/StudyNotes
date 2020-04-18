package pers.study.datastructure.mapset;



import pers.study.FileOperation;

import java.util.ArrayList;

/**
 * @author rookie
 * @date 2020/4/12
 */
public class BinarySearchTreeSetTest {
    public static void main(String[] args) {
        System.out.println("pride-and-prejudice");
        ArrayList<String> words1 = new ArrayList<>();
        FileOperation.readFile("src\\pers\\study\\txt\\pride-and-prejudice.txt",words1);
        System.out.println("Total words:" + words1.size());
        BinarySearchTreeSet<String> binarySearchTreeSet = new BinarySearchTreeSet<>();
        for (String word : words1){
            binarySearchTreeSet.add(word);
        }
        System.out.println("Total different words:"+binarySearchTreeSet.size());
    }
}
