package chapter15generics;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/9
 * Mail:zhengjun1987@outlook.com
 */
public class EpicBattle {
    static <POWER extends SuperHearing> void useSuperHearing(SuperHero<POWER> hero){
        hero.getPower().hearSubtleNoises();
    }
    static <POWER extends SuperHearing & SuperSmell> void superFind(SuperHero<POWER> hero){
        hero.getPower().hearSubtleNoises();
        hero.getPower().trackBySmell();
    }

    public static void main(String[] args) {
        DogBoy dogBoy = new DogBoy();
        useSuperHearing(dogBoy);
        superFind(dogBoy);
    }
}

interface SuperPower{}

interface XRayVision extends SuperPower{
    void seeThroughWalls();
}

interface SuperHearing extends SuperPower{
    void hearSubtleNoises();
}

interface SuperSmell extends SuperPower{
    void trackBySmell();
}

class SuperHero<POWER extends SuperPower> {
    POWER power;

    public SuperHero(POWER power) {
        this.power = power;
    }

    public POWER getPower() {
        return power;
    }
}

class SuperSleuth<POWER extends XRayVision> extends SuperHero<POWER>{

    public SuperSleuth(POWER power) {
        super(power);
    }

    void see(){
        power.seeThroughWalls();
    }
}

class CanineHero <POWER extends SuperHearing & SuperSmell> extends SuperHero<POWER>{

    public CanineHero(POWER power) {
        super(power);
    }

    void hear(){
        power.hearSubtleNoises();
    }

    void smell(){
        power.trackBySmell();
    }
}

class SuperHearSmell implements SuperSmell,SuperHearing{
    @Override
    public void hearSubtleNoises() {
        System.out.println("SuperHearSmell.hearSubtleNoises");
    }

    @Override
    public void trackBySmell() {
        System.out.println("SuperHearSmell.trackBySmell");
    }
}

class DogBoy extends CanineHero<SuperHearSmell>{
    public DogBoy() {
        super(new SuperHearSmell());
    }
}
