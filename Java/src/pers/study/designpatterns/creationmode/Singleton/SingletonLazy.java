package pers.study.designpatterns.creationmode.Singleton;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/5/23 10:06
 */
/**
 * 1、懒汉式，线程不安全
 是否 Lazy 初始化：是
 是否多线程安全：否
 实现难度：易
 描述：这种方式是最基本的实现方式，这种实现最大的问题就是不支持多线程。因为没有加锁 synchronized，所以严格意义上它并不算单例模式。
 这种方式 lazy loading 很明显，不要求线程安全，在多线程不能正常工作。
 */
public class SingletonLazy {

    private static SingletonLazy instance;
    private SingletonLazy (){}
    // 2.线程安全版本
    //public static synchronized SingletonLazy getInstance()

    //优点：第一次调用才初始化，避免内存浪费。
    //缺点：必须加锁 synchronized 才能保证单例，但加锁会影响效率。
    //getInstance() 的性能对应用程序不是很关键（该方法使用不太频繁）。
    public static SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }
}
