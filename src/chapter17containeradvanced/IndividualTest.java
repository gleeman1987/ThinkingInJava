package chapter17containeradvanced;

import chapter14runtimetypeinfo.Cat;
import chapter14runtimetypeinfo.Dog;
import chapter14runtimetypeinfo.Individual;
import chapter14runtimetypeinfo.Rat;

import java.util.TreeSet;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/4
 * Mail:zhengjun1987@outlook.com
 */
public class IndividualTest {
    public static void main(String[] args) {
        TreeSet<Individual> individuals = new TreeSet<>();
        // TODO: 2017/11/4 此处需要引用"持有对象"章节相关类
        individuals.add(new Cat("Tom"));
        individuals.add(new Cat("Garfield"));
        individuals.add(new Rat("Mickey"));
        individuals.add(new Rat("Jerry"));
        individuals.add(new Dog("Snoopy"));
        individuals.add(new Cat("Kitty"));
        System.out.println("individuals = " + individuals);
//        individuals = [Cat{name='Garfield'}, Cat{name='Kitty'}, Cat{name='Tom'}, Dog{name='Snoopy'}, Rat{name='Jerry'}, Rat{name='Mickey'}]
    }
}
