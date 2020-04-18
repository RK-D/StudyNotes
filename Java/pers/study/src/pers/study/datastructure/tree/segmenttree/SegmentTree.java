package pers.study.datastructure.tree.segmenttree;

/**
 * @author rookie
 * @date 2020/4/14
 * 线段树/区间树 是平衡二叉树（最大深度和最小深度差<= 1）非 完全二叉树(特殊的平衡二叉树，各节点插满，not have null)
 * 对区间数据进性统计查询
 * @ToDo 懒惰更新，二维线段树，动态线段树，树状数组（Binary Index Tree） 区间相关问题（ RMQ）
 */
public class SegmentTree<E> {
    private E[] data;
    private E[] tree;
    private Merger<E> merger;
    /**传入待操作数据，并且指定对数据操作的具体业务实现方式，而不是固化业务实现*/
    public SegmentTree(E[] arr,Merger<E> merger){
        this.merger = merger;
        data = (E[])new Object[arr.length];

        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        //开辟4n大小的空间
        tree = (E[])new Object[4 * arr.length];
        //创建线段树
        buildSegmentTree(0,0,data.length - 1);
    }
    /**创建线段树
     * 在根节点为index的某一个元素，处创建表示区间/线段在[l,r]之间的线段树，index为[l-r]的和*/
    private void buildSegmentTree(int index, int l, int r) {
        //l = r 同一个点区间不可分，那么相对于叶子结点，存本身的元素即可，不必使用区间
        if (l == r){
            tree[index] = data[l];
            return;
        }
        //定义两个变量，左右孩子结点索引
        int lIndex = lChild(index);
        int rIndex = rChild(index);

        //写法等价 int mid = (l + r) / 2; 为了防止int 整型溢出，实际可能性不大
        int mid = l + (r - l) / 2;

        /**下面两个方法都是前闭后闭的区间*/

        //创建针对左子树的结点，存放从l到mid的区间
        buildSegmentTree(lIndex,l,mid);

        //创建针对右子树的结点，存放从mid+1到r的区间
        buildSegmentTree(rIndex,mid + 1, r);

        /**这条定义具体逻辑，求和？max？min？。。。此处error解决方法参考merger（融合，归并） ,
         * 类似MapReduce计算，数据和业务分离，
        具体的计算分开，计算什么传入什么业务即可
         最后在main函数中简单测试可以写业务功能，也可以自定义接口实现*/
        tree[index] = merger.merge(tree[lIndex],tree[rIndex]);
    }
    /**获取元素*/
    public E get(int index){
        if (index < 0 || index >= data.length){
            throw new IllegalArgumentException("error index");
        }
        return data[index];
    }

    /**获取size*/
    public int size(){
        return data.length;
    }
    //下面这两个return值为什么要这么计算呢? 具体参考SegmentTree.MD 文档讲解，开辟的4n空间及索引，因为用的是数组存储开辟空间
    /**左孩子，计算index结点的左孩子结点索引*/
    public int lChild(int index){
        return 2 * index + 1;
    }

    /**右孩子，计算index结点的右孩子结点索引*/
    public int rChild(int index){
        return 2 * index + 2;
    }

    /**查询结点,l,r 是查询范围，区间左右端点*/
    public E query(int queryL, int queryR){
        if (queryL < 0 || queryL >= data.length ||
                queryR < 0 || queryR >= data.length || queryL > queryR){
            throw new IllegalArgumentException("Out of bounds");
        }
        return query(0,0,data.length - 1, queryL, queryR);
    }
    /**
     * 线段树的区间[l,r]，搜索区间[queryL,queryR]的值
     */
    private E query(int index, int l, int r,int queryL, int queryR){


        //查询到叶子结点，直接返回该节点信息即可
        if (l == queryL && r == queryR){
            return tree[index];
        }
        //定义mid，左右孩子索引,并分割区间,方便后面调用去指定该节点的左右孩子区间，index是父节点，lIndex,rIndex是孩子结点
        int mid = l + (r - l) / 2;
        int lIndex = lChild(index);
        int rIndex = rChild(index);

        //当查询左区间在大于mid的右半部分时
        if (queryL >= mid + 1){
            return query(rIndex,mid + 1, r, queryL,queryR);
        }
        else if(queryR <= mid){
            return query(lIndex, l,mid, queryL, queryR);
        }
        //区间跨区域，部分涵盖左右两个区间，去不同区间，递归查询，范围不能错。
        E lRes = query(lIndex, l, mid, queryL, mid);
        E rRes = query(rIndex,mid + 1,r,mid+1,queryR);
        //归并结果，返回
        return   merger.merge(lRes,rRes);
    }
    /**更新指定节点index的元素，并将e赋值给index'节点e*/
    public void  update(int index,E e)  {
        if (index < 0 || index >= data.length){
            throw new IllegalArgumentException("Out of bounds");
        }
        data[index] = e;
        //针对tree更新内容递归实现
        update(0,0, data.length - 1,index, e);
    }

    private void update(int i, int l, int r, int index, E e) {
        if ( l == r){
            tree[i] = e;
            return;
        }
        //定义mid，左右孩子索引,并分割区间,方便后面调用去指定该节点的左右孩子区间，index是父节点，lIndex,rIndex是孩子结点
        int mid = l + (r - l) / 2;
        int lIndex = lChild(i);
        int rIndex = rChild(i);

        //当查询左区间在大于mid的右半部分时,并更新
        if (index >= mid + 1){
            update(rIndex,mid + 1, r, index, e);
        }
        else if(index <= mid){
            update(lIndex, l,mid, index, e);
        }
        //更新结点i自身，这儿有点儿抽闲比较难理解
        tree[i] = merger.merge(tree[lIndex],tree[rIndex]);
    }

    /**懒惰更新思想，用lazy记录数组*/

    /**重写写输出格式，为了表达出区间*/
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append('[');
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null){
                res.append(tree[i]);
            }else {
                res.append("null");
            }
            if (i != tree.length - 1){
                res.append(",");
            }
            res.append(']');
            return res.toString();
        }
        return super.toString();
    }

}
