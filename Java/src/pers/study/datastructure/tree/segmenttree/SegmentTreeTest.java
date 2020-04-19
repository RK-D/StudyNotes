package pers.study.datastructure.tree.segmenttree;

/**
 * @author rookie
 * @date 2020/4/15
 */
public class SegmentTreeTest {
    public static void main(String[] args) {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        //(a,b)->a+b 是lambada表达式，此处意思是进性操作 +  的运算
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums,(e1,e2)->e1+e2);
        System.out.println(segmentTree.query(0, 2));
        //简单测试传入乘法
        SegmentTree<Integer> segmentTree2 = new SegmentTree<>(nums,(e1,e2)->e1*e2);
        System.out.println(segmentTree2.query(1, 2));
    }
}
