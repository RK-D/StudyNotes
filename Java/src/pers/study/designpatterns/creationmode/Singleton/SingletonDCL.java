package pers.study.designpatterns.creationmode.Singleton;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/5/23 10:11
 */
/**
 * 双检锁/双重校验锁（DCL，即 double-checked locking）
 JDK 版本：JDK1.5 起
 是否 Lazy 初始化：是
 是否多线程安全：是
 实现难度：较复杂
 描述：这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
 getInstance() 的性能对应用程序很关键。
 */
public class SingletonDCL {
    private volatile static SingletonDCL instance;
    private SingletonDCL (){}
    public static SingletonDCL getInstance() {
        if (instance == null) {
            synchronized (SingletonDCL.class) {
                if (instance == null) {
                    instance = new SingletonDCL();
                }
            }
        }
        return instance;
    }
}
