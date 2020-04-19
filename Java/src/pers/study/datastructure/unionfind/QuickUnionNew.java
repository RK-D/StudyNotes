package pers.study.datastructure.unionfind;

/**
 * @author yd
 * @version 1.0
 * @date 2020/4/16 14:11
 *
 *
 * 基于size的优化：使用nums优化size，减少深度（让元素少的集合指向元素多的）
 * 基于rank的优化：高度低的指向高度高的树(首选)
 */
public class QuickUnionNew implements UnionFind {
    private int[] parent;
    /**nums[i]表示以i为根的集合的元素有多少个*/
    private int[] rank;

    public QuickUnionNew(int size){
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            //初始化就一个元素，自己本身独立成一个集合，后续添加继续用
            rank[i] = 1;
        }
    }

    @Override
    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    @Override
    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot == yRoot){
            return;
        }
        //让数量少的集合指点多的进性合并，减小H（深度）变化
        if(rank[xRoot] < rank[yRoot]){
            parent[xRoot] = yRoot;
        }
        else if (rank[xRoot] > rank[yRoot]){
            parent[yRoot] = xRoot;
        }else {
            parent[xRoot] = yRoot;
            rank[yRoot] += 1;
        }
    }

    @Override
    public int size() {
        return parent.length;
    }

    private int find(int e){
        if (e < 0 || e >= parent.length){
            throw new IllegalArgumentException("Out of bound");
        }
        while (e != parent[e]){
            e = parent[e];
        }
        return e;
    }
}
