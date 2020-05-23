package pers.study.designpatterns.creationmode.Singleton;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/5/23 10:04
 */
public class singletonTest {
    public static void main(String[] args) {

        //不合法的构造函数
        //编译时错误：构造函数 SingleObject() 是不可见的
        //SingleObject object = new SingleObject();

        //获取唯一可用的对象
        Singleton object = Singleton.getInstance();

        //显示消息
        object.showMessage();
    }
}
