package pers.study.designpatterns.creationmode.Factory;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/5/23 17:16
 */
public class Pikachu implements Toy {
    @Override
    public void getName() {
        System.out.println("我是皮卡丘");
    }

    @Override
    public void talk() {
        System.out.println("我是谁？");
    }
}
