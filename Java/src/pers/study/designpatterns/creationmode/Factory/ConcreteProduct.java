package pers.study.designpatterns.creationmode.Factory;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/5/23 18:30
 */
public class ConcreteProduct implements Product {
    @Override
    public void doSomething() {
        System.out.println("do");
    }
}
