package pers.study.designpatterns.creationmode.AbstractFactory;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/5/23 19:40
 */
public class FemaleFactory implements  HumanFactory {
    //生产出黑人女性
    public Human createBlackHuman() {
        return new FemaleBlackHuman();
    }

    //生产出白人女性
    public Human createWhiteHuman() {
        return new FemaleWhiteHuman();
    }

    //生产出黄人女性
    public Human createYellowHuman() {
        return new FemaleYellowHuman();
    }
}