package chapter15generics;

import chapter14runtimetypeinfo.Dog;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/14
 * Mail:zhengjun1987@outlook.com
 */
interface Performs {
    void speak();
    void sit();
}
class PerformingDog extends Dog implements Performs {
    @Override
    public void speak() {
        System.out.println("PerformingDog.bark Woof!");
    }

    @Override
    public void sit() {
        System.out.println("PerformingDog.sit");
    }
}

class Robot implements Performs {
    @Override
    public void speak() {
        System.out.println("Robot.speak 'Click!'");
    }

    @Override
    public void sit() {
        System.out.println("Robot.sit");
    }
}

class Communicate {}

public class DogsAndRobots {

}
