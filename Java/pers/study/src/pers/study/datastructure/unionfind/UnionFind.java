package pers.study.datastructure.unionfind;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/4/16 10:39
 *
 * @name 并查集
 * 不一样的树结构，孩子指向父节点，快速处理链接问题
 */
public interface UnionFind {
    /**查询
     * @return true / false
     * @param x
     * @param y
     * 判断网络（not only internet）中x，y两个节点中的链接状态
     * */
    boolean isConnected(int x, int y);
    /**求并集*/
    void union(int x, int y);

    int size();
}
