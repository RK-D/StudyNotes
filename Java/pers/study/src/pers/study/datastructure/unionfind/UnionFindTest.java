package pers.study.datastructure.unionfind;

import java.util.Random;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/4/16 14:06
 */
public class UnionFindTest {
    private static double test(UnionFind unionFind, int m){

        int size = unionFind.size();
        Random random = new Random();

        long startTime = System.nanoTime();

        for(int i = 0 ; i < m ; i ++){
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            unionFind.union(a, b);
        }

        for(int i = 0 ; i < m ; i ++){
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            unionFind.isConnected(a, b);
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }
    public static void main(String[] args) {
        int size = 100000000;
        int m = 10000000;

        //测试1,2时数据size和m得调小，否则，超级慢复杂度高，你懂得！
//        QuickFind uf1 = new QuickFind(size);
//        System.out.println("QuickFind : " + test(uf1, m) + " s");

//        QuickUnionLow uf2 = new QuickUnionLow(size);
//        System.out.println("QuickUnionLow : " + test(uf2, m) + " s");

        QuickUnionNew uf3 = new QuickUnionNew(size);
        System.out.println("QuickUnionNew : " + test(uf3, m) + " s");

        QuickUnion uf4 = new QuickUnion(size);
        System.out.println("QuickUnion : " + test(uf3, m) + " s");
    }
}
