package pers.study.designpatterns.creationmode.Singleton;

import java.util.LinkedList;
import java.util.Random;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/5/23 16:40
 */
public class expandSingleton {
        //定义最多能产生的实例数量
        private static int maxNumOfEmperor = 2;
        //每个r人都有名字，使用一个LinkedList来容纳，每个对象的私有属性
        //谁用ArrayList啊
        private static LinkedList<String> nameList=new LinkedList<String>() ;
        //定义一个列表，容纳所有的人实例
        private static LinkedList <expandSingleton> emperorList=new LinkedList<expandSingleton>() ;
        //当前人的序列号
        private static int countNumOfEmperor =0;
        //产生所有的对象
        static {
            for(int i=0; i < maxNumOfEmperor;i++) {
                emperorList.add(new expandSingleton(" 人"+(i+1)));
            }
        }
        private expandSingleton() {}
        //传入人的名称，建立一个人对象
        private expandSingleton (String name) {
            nameList.add(name) ;
        }
        //随机获得一个人对象
        public static expandSingleton getInstance() {
            Random random = new Random() ;
            //随机拉出一个人
            countNumOfEmperor = random.nextInt(maxNumOfEmperor) ;
            return emperorList. get(countNumOfEmperor) ;
        }
        //人说话了
        public static void say() {
            System. out. println (nameList.get(countNumOfEmperor)) ;
        }
}
