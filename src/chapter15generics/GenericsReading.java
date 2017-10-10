package chapter15generics;

import java.util.Arrays;
import java.util.List;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/10
 * Mail:zhengjun1987@outlook.com
 */
public class GenericsReading {
    static <T> T readExact(List<T> list){
        return list.get(0);
    }

    static List<Apple> apples = Arrays.asList(new Apple());
    static List<Fruit> fruits = Arrays.asList(new Fruit());

    static void f1(){
        Apple apple = readExact(apples);
        Fruit fruit = readExact(fruits);
        fruit = readExact(apples);
    }

    static class Reader<T> {
        T readExact(List<T> list){
            return list.get(0);
        }
    }

    static void f2(){
        Reader<Fruit> fruitReader = new Reader<>();
        Fruit fruit = fruitReader.readExact(fruits);
//        Fruit fruit1 = fruitReader.readExact(apples);fruitReader无法接收apples参数,因为类型被严格匹配
    }

    static class CovariantReader<T> {
        T readCovariant(List<? extends T> list){
            return list.get(0);
        }
    }

    static void f3(){
        CovariantReader<Fruit> fruitCovariantReader = new CovariantReader<>();
        Fruit fruit = fruitCovariantReader.readCovariant(apples);
        Fruit fruit1 = fruitCovariantReader.readCovariant(fruits);
    }

    public static void main(String[] args) {
        f1();f2();f3();
    }
}
