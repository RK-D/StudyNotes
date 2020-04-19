package pers.study.datastructure.unionfind;

/**
 * @author yd
 * @version 1.0
 * @date 2020/4/16 11:11
 *
 * 未优化版本
 * 快并， 这时候开始建树，默认单个元素都是一个结点，一个结点拥有自回路，然后又被子节点指向
 * 合并操作是需要指向同一个父节点，从而达到合并（链接） 这一操作
 *  牺牲一部分查询性能提升，union性能 复杂度均为O(h) h是树高度
 */
public class QuickUnionLow implements UnionFind {
    private int[] parent;
    public QuickUnionLow(int size){
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
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
        parent[xRoot] = yRoot;

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
