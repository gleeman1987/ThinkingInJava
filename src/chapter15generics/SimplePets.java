package chapter15generics;

import chapter14runtimetypeinfo.People;
import chapter14runtimetypeinfo.Pet;

import java.util.Map;

public class SimplePets {
    public static void main(String[] args) {
        Map<People, ? extends Pet> map = New.map();
    }
}
