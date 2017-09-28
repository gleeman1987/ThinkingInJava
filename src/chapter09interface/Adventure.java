package chapter09interface;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/6/28.
 */
public class Adventure {
    public static void main(String[] args) {
        Hero superman = new Hero();
        f(superman);
        s(superman);
        c(superman);
        a(superman);
    }

    public static void f(Aviator canFly){canFly.fly();}
    public static void s(CanSwim canSwim){canSwim.swim();}
    public static void c(CanFight canFight){canFight.fight();}
    public static void a(ActionCharacter actionCharacter){actionCharacter.fight();}
}

interface CanFight{
    void fight();
}

interface CanSwim{
    void swim();
}

interface CanFly{
    void fly();
}

interface Aviator extends CanFly{
    void navigate();
}

class ActionCharacter {
    public void fight(){
        System.out.println("ActionCharacter.fight  "+ getClass().getSimpleName());
    };
}

class Hero extends ActionCharacter implements CanFight,Aviator,CanSwim{

    @Override
    public void fly() {
        System.out.println("Hero.fly");
    }

    @Override
    public void swim() {
        System.out.println("Hero.swim");
    }

    @Override
    public void navigate() {
        System.out.println("Hero.navigate");
    }
}
