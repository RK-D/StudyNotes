package pers.study.datastructure.tree.segmenttree;

/**
 * @author Dongfanger
 * @date 2020/4/15
 */
public interface Merger<E> {
    /**融合器，后期归并元素，具体业务自定义
     * @param e1 元素1
     * @param e2 元素2
     * @return E*/
    E merge(E e1, E e2);
}
