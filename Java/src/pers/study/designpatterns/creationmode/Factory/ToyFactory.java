package pers.study.designpatterns.creationmode.Factory;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/5/23 17:24
 */
public class ToyFactory extends AbstractToyFactory {
    @Override
    public <T extends Toy> T createToy(Class<T> tClass) {
        Toy pokemon = null;
        try{
            //出现一只宝可梦
            pokemon = (T)Class.forName(tClass.getName()).newInstance();
        }catch ( Exception e){
            System.out.println("pokemon没有出现");
        }
        return (T)pokemon;
    }
}
