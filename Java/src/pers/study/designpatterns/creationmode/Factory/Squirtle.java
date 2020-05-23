package pers.study.designpatterns.creationmode.Factory;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/5/23 17:21
 */
public class Squirtle implements Toy{
    @Override
    public void getName() {
        System.out.println("我是杰尼龟");
    }

    @Override
    public void talk() {
        System.out.println("我是谁？");
    }
}
