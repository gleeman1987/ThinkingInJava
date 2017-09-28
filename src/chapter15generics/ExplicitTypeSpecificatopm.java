package chapter15generics;

import chapter14runtimetypeinfo.People;
import chapter14runtimetypeinfo.Pet;

import java.util.List;
import java.util.Map;

public class ExplicitTypeSpecificatopm {
    static void f(Map<People, List<? extends Pet>> peopleListMap){}

    public static void main(String[] args) {
        f(New.map());
//        f(New.<People,List<? extends Pet>>map());这种写法可行,但没有必要
    }
}
