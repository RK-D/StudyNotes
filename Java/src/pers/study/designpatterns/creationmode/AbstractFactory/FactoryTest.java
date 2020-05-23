package pers.study.designpatterns.creationmode.AbstractFactory;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/5/23 19:48
 */
public class FactoryTest {
    public static void main(String[] args) {
        //男
        HumanFactory maleHumanFactory = new MaleFactory();
        //女
        HumanFactory femaleHumanFactory = new MaleFactory();
        //造人开始
        Human maleYellowHuman = maleHumanFactory.createYellowHuman();
        Human femaleYellowHuman = femaleHumanFactory.createYellowHuman();

        System.out.println("第一个黄种人女生");
        femaleYellowHuman.getColor();
        femaleYellowHuman.talk();
        femaleYellowHuman.getSex();
        System.out.println();
        System.out.println("第一个黄种人男生");
        maleYellowHuman.getColor();
        maleYellowHuman.talk();
        maleYellowHuman.getSex();
    }
}
