package chapter15generics;

import java.util.ArrayList;
import java.util.List;

public class FilledListMaker<T> {
    List<T> create(T t,int count){
        ArrayList<T> ts = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            ts.add(t);
        }
        return ts;
    }

    public static void main(String[] args) {
        FilledListMaker<String> stringFilledListMaker = new FilledListMaker<>();
        List<String> hello = stringFilledListMaker.create("Hello", 4);
        System.out.println("hello = " + hello);
    }
}
