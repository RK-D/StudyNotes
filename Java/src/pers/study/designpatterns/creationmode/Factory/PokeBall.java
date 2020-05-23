package pers.study.designpatterns.creationmode.Factory;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/5/23 17:30
 */
public class PokeBall {
    public static void main(String[] args) {
        //声明精灵球
        AbstractToyFactory pokeBall = new ToyFactory();
        //第一只宝可梦被捕捉（生产）放进精灵球
        System.out.println("皮卡丘");
        Toy pikachu = (new PikachuFactory()).createToy();
        pikachu.talk();
        pikachu.getName();

//        //第一只宝可梦被捕捉（生产）放进精灵球
//        System.out.println("皮卡丘");
//        Toy bulbasaur = pokeBall.createToy(Bulbasaur.class);
//        bulbasaur.talk();
//        bulbasaur.getName();
//
//        //第一只宝可梦被捕捉（生产）放进精灵球
//        System.out.println("皮卡丘");
//        Toy squirtle = pokeBall.createToy(Squirtle.class);
//        squirtle.talk();
//        squirtle.getName();
    }
}
