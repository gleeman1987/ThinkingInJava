package chapter15generics;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/9/30.
 */
public class ArrayOfGenericReference {
    static Generic<Integer>[] gia;

    public static void main(String[] args) {
        gia = new Generic[]{new Generic<Integer>()};
        System.out.println("gia = " + gia);
    }
}

class Generic<T> {}
