package pers.study.designpatterns.creationmode.AbstractFactory;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/5/23 19:30
 */
public abstract class AbstractWhiteHuman implements Human {
    public void getColor(){
        System.out.println("白色");
    }
    public void talk(){
        System.out.println("白人说话");
    }
}
