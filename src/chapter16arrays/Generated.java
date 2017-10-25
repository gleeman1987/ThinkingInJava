package chapter16arrays;

import chapter15generics.Generator;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/25
 * Mail:zhengjun1987@outlook.com
 */
public class Generated {
    public static <T> T[] array(T[] a, Generator<T> generator){
        for (int i = 0; i < a.length; i++) {
            a[i] = generator.next();
        }
        return a;
    }

    public static <T> T[] array(Class<T> tClass,Generator<T> generator,int size) {
        T[] ts = (T[]) Array.newInstance(tClass, size);
        for (int i = 0; i < size; i++) {
            ts[i] = generator.next();
        }
        return ts;
    }

    public static void main(String[] args) {
        Integer[] a = {9,8,7,6};
        System.out.println("Arrays.toString(a) = " + Arrays.toString(a));
//        Arrays.toString(a) = [9, 8, 7, 6]
        a = array(a,new CountingGenerator.Integer());
        System.out.println("Arrays.toString(a) = " + Arrays.toString(a));
//        Arrays.toString(a) = [0, 1, 2, 3]
        System.out.println("Arrays.toString(array(Integer.class,new CountingGenerator.Integer(),15)) = " + Arrays.toString(array(Integer.class, new CountingGenerator.Integer(), 15)));
//        Arrays.toString(array(Integer.class,new CountingGenerator.Integer(),15)) = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14]
    }
}
