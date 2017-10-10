package chapter15generics;

import java.util.ArrayList;
import java.util.List;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/10
 * Mail:zhengjun1987@outlook.com
 */
public class GenericsWriting {
    static <T> void writeExact(List<T> list,T item){
        list.add(item);
    }

    static List<Apple> apples = new ArrayList<>();
    static List<Fruit> fruits = new ArrayList<>();

    static void f1(){
        writeExact(apples,new Apple());
        writeExact(fruits,new Apple());
    }

    static <T> void writeWithWildcard(List<? super T> list,T item){
        list.add(item);
    }

    static void f2(){
        writeWithWildcard(apples,new Apple());
        writeWithWildcard(fruits,new Apple());
    }

    public static void main(String[] args) {
        f1();
        System.out.println("apples = " + apples);
        System.out.println("fruits = " + fruits);
        f2();
        System.out.println("apples = " + apples);
        System.out.println("fruits = " + fruits);
    }
}
