package chapter15generics;

import java.util.ArrayList;
import java.util.List;

public class ListMaker<T> {
    List<T> create(){ return new ArrayList<T>(); }

    public static void main(String[] args) {
        ListMaker<String> stringListMaker = new ListMaker<>();
        List<String> strings = stringListMaker.create();
    }
}
