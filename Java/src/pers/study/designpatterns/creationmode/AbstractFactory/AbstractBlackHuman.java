package pers.study.designpatterns.creationmode.AbstractFactory;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/5/23 19:33
 */
public abstract class AbstractBlackHuman implements Human{
    public void getColor(){
        System.out.println("黑色");
    }
    public void talk(){
        System.out.println("黑人说话");
    }
}
