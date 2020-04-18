package pers.study.datastructure.unionfind;

/**
 * @author yd
 * @version 1.0
 * @date 2020/4/16 15:21
 *
 *
 * 路径压缩：减少find操作复杂度，理论上性能最好
 */
public class QuickUnion implements UnionFind {
    private int[] parent;
    /**nums[i]表示以i为根的集合的元素有多少个*/
    private int[] rank;

    public QuickUnion(int size){
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
    /**路径压缩优化*/
    private int find(int e){
        if (e < 0 || e >= parent.length){
            throw new IllegalArgumentException("Out of bound");
        }
//        while (e != parent[e]){
//            //把当前的结点调整到该节点的父亲的父节点，减少深度
//            parent[e]= parent[parent[e]];
//            e = parent[e];
//        }
//        return e;
        /** 递归：压缩到更短的路径压缩，统一指向更结点，*/
        if(e != parent[e]){
            parent[e] = find(parent[e]);
        }

        return parent[e];
    }
}
