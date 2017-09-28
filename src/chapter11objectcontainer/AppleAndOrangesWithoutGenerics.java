package chapter11objectcontainer;

import java.util.ArrayList;

public class AppleAndOrangesWithoutGenerics {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Apple());
        arrayList.add(new Apple());
        arrayList.add(new Apple());
        arrayList.add(new Apple());
        //arrayList.add(new Orange());//Exception in thread "main" java.lang.ClassCastException: chapter11objectcontainer.Orange cannot be cast to chapter11objectcontainer.Apple
        for (int i = 0; i < arrayList.size(); i++) {
            Apple apple = (Apple) arrayList.get(i);
            System.out.println(apple.getId()+" ");
        }
    }
}

class Apple {
    private static int total;
    private int id = total++;

    public int getId() {
        return id;
    }
}

class Orange {

}