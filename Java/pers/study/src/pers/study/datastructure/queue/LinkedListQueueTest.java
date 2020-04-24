package pers.study.datastructure.queue;

/**
 * @author rookie
 * @date 2020/4/9
 */
public class LinkedListQueueTest {
    public static void main(String[] args) {
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            linkedListQueue.add(i);
            System.out.println(linkedListQueue);
            if (i % 3 == 2){
                linkedListQueue.remove();
                System.out.println(linkedListQueue);
            }
        }
    }
}
