package pers.study.designpatterns.creationmode.Factory;

/**
 * @author yd
 * @version 1.0
 * @date 2020/5/23 17:09
 */
//建立一个玩具工厂
public interface Toy {
    //玩具名称
    void getName();
    //玩具可以动
    void talk();
}
