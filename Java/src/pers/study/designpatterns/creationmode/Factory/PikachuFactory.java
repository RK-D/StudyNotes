package pers.study.designpatterns.creationmode.Factory;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/5/23 18:06
 */
public class PikachuFactory extends AbstractToyFactory{

    @Override
    public Toy createToy() {
        return new Pikachu();
    }
}
