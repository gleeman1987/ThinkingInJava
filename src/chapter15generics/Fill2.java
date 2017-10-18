package chapter15generics;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/18
 * Mail:zhengjun1987@outlook.com
 */

interface Addable<T> {
    void add(T t);
}

public class Fill2 {
    public static <T> void fill(Addable<T> addable,Class<? extends T> clazz,int size){
        for (int i = 0; i < size; i++) {
            try {
                addable.add(clazz.newInstance());
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
    }

    public static <T> void fill(Addable<T> addable,Generator<? extends T> generator,int size){
        for (int i = 0; i < size; i++) {
            addable.add(generator.next());
        }
    }
}
