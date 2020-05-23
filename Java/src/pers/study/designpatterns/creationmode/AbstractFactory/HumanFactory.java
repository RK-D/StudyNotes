package pers.study.designpatterns.creationmode.AbstractFactory;

/**
 * @author yd
 * @version 1.0
 * @date 2020/5/23 19:37
 */
public interface HumanFactory {
    // 造黄色人种
    Human createYellowHuman();
    // 造白色人种
    Human createWhiteHuman();
    // 造黑色人种
    Human createBlackHuman();
}
