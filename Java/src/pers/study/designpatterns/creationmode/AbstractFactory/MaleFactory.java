package pers.study.designpatterns.creationmode.AbstractFactory;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/5/23 19:40
 */
public class MaleFactory implements  HumanFactory {
    @Override
    public Human createYellowHuman() {
        return new MaleYellowHuman();
    }

    @Override
    public Human createWhiteHuman() {
        return new MaleWhiteHuman();
    }

    @Override
    public Human createBlackHuman() {
        return new MaleBlackHuman();
    }
}
