package pers.study.designpatterns.creationmode.Factory;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/5/23 17:23
 */
public class Bulbasaur implements Toy {
    @Override
    public void getName() {
        System.out.println("我是妙蛙种子");
    }

    @Override
    public void talk() {
        System.out.println("我是谁？");
    }
}
