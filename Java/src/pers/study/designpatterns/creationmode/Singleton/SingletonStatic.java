package pers.study.designpatterns.creationmode.Singleton;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/5/23 10:13
 */
/**
 * 登记式/静态内部类
 是否 Lazy 初始化：是
 是否多线程安全：是
 这种方式能达到双检锁方式一样的功效，但实现更简单。对静态域使用延迟初始化，
 应使用这种方式而不是双检锁方式。
 PS:这种方式只适用于静态域的情况，双检锁方式可在实例域需要延迟初始化时使用。
 */
public class SingletonStatic {
    private static class SingletonHolder {
        private static final SingletonStatic instance = new SingletonStatic();
    }
    private SingletonStatic (){}
    public static final SingletonStatic getInstance() {
        return SingletonHolder.instance;
    }
}
