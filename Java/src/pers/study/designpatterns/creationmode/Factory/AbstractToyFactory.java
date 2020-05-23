package pers.study.designpatterns.creationmode.Factory;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/5/23 17:11
 */
public abstract class AbstractToyFactory {
    //    public abstract <T extends Toy> T createToy(Class<T> tClass);
    //使用泛型，定义泛型对createToy 的参数有两层限制：
    // 1、必须Class类型
    // 2、必须是Toy实现类
    //其中的"T"表示的是，只要实现了Toy接口的类都可以作为参数，泛型是JDK 1.5中的一个非常重要的新特性，它减少了对象间的转换，约束其输入参数类型，对Collection集合下的实现类都可以定义泛型。
    public abstract Toy createToy();
}
