package chapter11objectcontainer;

import java.util.ArrayList;

public class GenericsAndUpcasting {
    public static void main(String[] args) {
        ArrayList<Apple> apples = new ArrayList<>();
        apples.add(new Apple());
        apples.add(new Fuji());
        apples.add(new Apple());
        apples.add(new Apple());
        apples.add(new Gala());
        apples.add(new Apple());
        apples.add(new Apple());
        for (Apple apple : apples) {
            System.out.println(apple.getId()+"  "+apple.getClass().getName());
        }
//        0  chapter11objectcontainer.Apple
//        1  chapter11objectcontainer.Fuji
//        2  chapter11objectcontainer.Apple
//        3  chapter11objectcontainer.Apple
//        4  chapter11objectcontainer.Gala
//        5  chapter11objectcontainer.Apple
//        6  chapter11objectcontainer.Apple
    }
}

class Gala extends Apple {}

class Fuji extends Apple {}
