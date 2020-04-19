package pers.study.datastructure.unionfind;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/4/16 10:54
 *
 * 快查，慢合并
 * 分组，标注id ，查询比较id号快速区分
 */
public class QuickFind implements UnionFind{
    /**利用id标注不同集合，用于后期区分集合，并且方便快速查询是否连通*/
    private int[] id;

    public QuickFind(int size){
        id = new int[size];
        /**每个元素的id重新标注，因此这里的都不连通*/
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    /**，查询返回比较两者id手否相同，判断是否连通复杂度O(1)*/
    @Override
    public boolean isConnected(int x, int y) {
        return findId(x) == findId(y);
    }

    /**并集，也就是链接操作，这里链接要考虑一下从属，x，y的连通，二者原先同id的元素同事也被连通
     * 循环改写，O(n) ，比较慢*/
    @Override
    public void union(int x, int y) {
        int xId = findId(x);
        int yId = findId(y);
        if (xId == yId){
            return;
        }

        for (int i = 0; i < id.length; i++) {
                if (id[i] == xId){
                    id[i] = yId;
                }
            }

    }

    @Override
    public int size() {
        return id.length;
    }
    /**查询id嘞*/
    private int findId(int e){
        if (e < 0 || e >= id.length){
            throw new IllegalArgumentException("Out of bound");
        }
        return id[e];
    }
}
