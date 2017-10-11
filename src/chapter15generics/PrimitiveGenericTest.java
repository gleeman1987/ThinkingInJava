package chapter15generics;

import java.util.Random;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/10
 * Mail:zhengjun1987@outlook.com
 */
class FArray {
    public static <T> T[] fill(T[] a,Generator<T> generator){
        for (int i = 0; i < a.length; i++) {
            a[i] = generator.next();
        }
        return a;
    }
}

public class PrimitiveGenericTest {
    public static void main(String[] args) {
        String[] strings = FArray.fill(new String[7], new Generator<String>() {
            Random random = new Random(47);
            String[] store = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm".split("");
            @Override
            public String next() {
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < 7; i++) {
                    result.append(store[random.nextInt(store.length)]);
                }

                return result.toString();
            }
        });

        for (String string : strings) {
            System.out.println(string);
        }
    }
}
