package pers.study.datastructure.queue;

/**
 * @author rookie
 * @date 2020/4/8
 */
public class LoopQueueTest {
    public static void main(String[] args) {
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            loopQueue.add(i);
            System.out.println(loopQueue);
            if (i % 3 == 2){
                loopQueue.remove();
                System.out.println(loopQueue);
            }
        }
    }
}
