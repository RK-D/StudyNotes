package pers.study.datastructure.heap;

import java.util.Random;

/**
 * @author rookie
 * @date 2020/4/14
 */
public class MaxHeapTest {
    public static void main(String[] args) {
        int n = 1000000;
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n ; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
            System.out.println(arr[i]);
        }
        //足最大堆测试
        for (int i = 1; i < n; i++) {
            if (arr[i-1] < arr[i]){
               throw new IllegalArgumentException("error");
            }
        }
        System.out.println("ok");
    }
}
