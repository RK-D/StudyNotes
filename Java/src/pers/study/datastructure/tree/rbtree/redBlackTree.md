##红黑树
###2-3树----一种绝对平衡的二叉树
* 两种结点
    * 一个元素，两个孩子结点
    * 两个元素在同一个结点，三个孩子结点，中间孩子结点在父节点两个元素数值之间   \
    左右孩子和二分搜索树一样，左孩子小于左元素，右孩子大于右元素。
* 对于2-3树的插入元素，有上浮，下沉操作，（暂时的四结点，然后对四结点分裂成3节点）

###rb树与2-3树等价
* 把3结点的元素的边绘制成红色，小的元素作为左孩子，从而形成红黑树，所以在红色信息存放在左孩子上面 
（本质基于二分搜索树）
* 红色结点想做倾斜，都是左孩子

###rb树，是保持黑平衡的二叉树，严格意义上不是平衡二叉树，