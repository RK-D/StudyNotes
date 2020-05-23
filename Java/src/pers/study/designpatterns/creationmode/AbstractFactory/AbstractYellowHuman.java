package pers.study.designpatterns.creationmode.AbstractFactory;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/5/23 19:32
 */
public abstract class AbstractYellowHuman implements Human {
    public void getColor(){
        System.out.println("黄色");
    }
    public void talk(){
        System.out.println("黄人说话");
    }
}
