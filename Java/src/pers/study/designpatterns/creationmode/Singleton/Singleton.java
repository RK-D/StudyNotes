package pers.study.designpatterns.creationmode.Singleton;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/5/23 9:51
 */
public class Singleton {
    //创建 Singleton 的一个对象
    private static Singleton instance = new Singleton();
    //让构造函数为 private，这样该类就不会被实例化
    private Singleton(){}
    //获取唯一可用的对象
    public static Singleton getInstance(){
        return instance;
    }

    public void showMessage(){
        System.out.println("单例1");
    }
}


