package pers.study.datastructure.array;

/**
 * @author rookie
 * @date 2020/4/7
 */
public class ArrayTest {
    public static void main(String[] args) {
        Array<Integer> array = new Array<>();
        for (int i = 0; i < 10; i++) {
            array.addLast(i);

        }
        System.out.println(array);

        array.add(1,100);
        System.out.println(array);

        array.addFirst(-1);
        System.out.println(array);
    }


}
