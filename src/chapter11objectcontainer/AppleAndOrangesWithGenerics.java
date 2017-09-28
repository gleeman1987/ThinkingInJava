package chapter11objectcontainer;

import java.util.ArrayList;

public class AppleAndOrangesWithGenerics {
    public static void main(String[] args) {
        ArrayList<Apple> apples = new ArrayList<>();
        apples.add(new Apple());
        apples.add(new Apple());
        apples.add(new Apple());
//        apples.add(new Orange());IDE报错(编译期错误)
        for (int i = 0; i < apples.size(); i++) {
            Apple apple = apples.get(i);//此处使用泛型之后无须强制转型
            System.out.println(apple.getId());
        }
    }
}
