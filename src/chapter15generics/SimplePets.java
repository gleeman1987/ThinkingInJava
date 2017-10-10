package chapter15generics;

import chapter14runtimetypeinfo.People;
import chapter14runtimetypeinfo.Pet;

import java.util.Map;

public class SimplePets {
    public static void main(String[] args) {
        Map<People, ? extends Pet> map = New.map();
//        map.put(new People("Joseph","Epstein","NYC"),new Pet());

        Map<People,? super Pet> map1 = New.map();
        map1.put(new People("Joseph","Epstein","NYC"),new Pet());
    }
}
