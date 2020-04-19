package pers.study.datastructure.tree.segmenttree;
/**
 * LeetCode 303. 区域和检索 - 数组不可变
 * 1. 线段树
 * 2. 数组预处理解决优化（很快）
 * */
public class Solution {
    public SegmentTree<Integer> segmentTree;
    public Solution(int [] nums){
        if (nums.length > 0){
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }
            segmentTree =new SegmentTree<>(data,(e1 , e2) -> e1 +e2);
        }
    }
    public int sumRange(int i, int j)  {
        if (segmentTree == null){
            throw new IllegalArgumentException("segmentTree is null");
        }
        return segmentTree.query(i,j);
    }
}
