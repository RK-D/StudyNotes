package pers.study.datastructure.queue;

/**
 * @author rookie
 * @date 2020/4/7
 */
public class ArrayQueueTest {
    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            arrayQueue.add(i);
            System.out.println(arrayQueue);
            if (i % 3 == 2){
                arrayQueue.remove();
                System.out.println(arrayQueue);
            }
        }
    }
}
