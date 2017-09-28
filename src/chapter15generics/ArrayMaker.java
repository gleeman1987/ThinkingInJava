package chapter15generics;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayMaker<T> {
    private Class<T> type;

    public ArrayMaker(Class<T> type) {
        this.type = type;
    }

    T[] create(int size){
        return (T[]) Array.newInstance(type,size);
    }

    public static void main(String[] args) {
        ArrayMaker<String> stringArrayMaker = new ArrayMaker<>(String.class);
        String[] strings = stringArrayMaker.create(9);
        System.out.println(Arrays.toString(strings));

        ArrayMaker<Office> officeArrayMaker = new ArrayMaker<>(Office.class);
        System.out.println(Arrays.toString(officeArrayMaker.create(9)));
    }
}
