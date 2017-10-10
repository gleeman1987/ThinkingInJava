package chapter15generics;

import java.util.Arrays;
import java.util.List;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/10
 * Mail:zhengjun1987@outlook.com
 */
public class CompilerIntelligence {
    public static void main(String[] args) {
        Apple apple = new Apple();
        List<? extends Fruit> fruits = Arrays.asList(apple);
//        fruits.add(new Apple());
        System.out.println("fruits.get(0) = " + fruits.get(0));
        System.out.println("fruits.indexOf(apple) = " + fruits.indexOf(apple));
        System.out.println("fruits.contains(apple) = " + fruits.contains(apple));
        System.out.println("--------------------------------------------");
        System.out.println("fruits.indexOf(new Apple()) = " + fruits.indexOf(new Apple()));
        System.out.println("fruits.contains(new Apple()) = " + fruits.contains(new Apple()));
//        fruits.get(0) = chapter15generics.Apple@4554617c
//        fruits.indexOf(apple) = 0
//        fruits.contains(apple) = true
//                --------------------------------------------
//        fruits.indexOf(new Apple()) = -1
//        fruits.contains(new Apple()) = false
    }
}
