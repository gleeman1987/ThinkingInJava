package chapter15generics;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/9/27.
 */
public class ErasedTypeEquivalence {
    public static void main(String[] args) {
        Class<? extends ArrayList> aClass = new ArrayList<String>().getClass();
        System.out.println("aClass = " + aClass);
        Class<? extends ArrayList> bClass = new ArrayList<Integer>().getClass();
        System.out.println("bClass = " + bClass);
        System.out.println(aClass.equals(bClass));
//        aClass = class java.util.ArrayList
//        bClass = class java.util.ArrayList
//        true

        Class<? extends ArrayList> aClass1 = new ArrayList<Office>().getClass();
        System.out.println("aClass1 = " + aClass1);
//        aClass1 = class java.util.ArrayList
        System.out.println(aClass.equals(aClass1));
//        true

        System.out.println(Arrays.toString(aClass.getTypeParameters()));
        System.out.println(Arrays.toString(bClass.getTypeParameters()));
        System.out.println(Arrays.toString(aClass1.getTypeParameters()));
//        [E]
//        [E]
//        [E]
    }
}
