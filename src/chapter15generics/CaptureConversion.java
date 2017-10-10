package chapter15generics;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/10
 * Mail:zhengjun1987@outlook.com
 */
public class CaptureConversion {
    static <T> void f1(Holder<T> holder){
        T t = holder.get();
        System.out.println("t.getClass().getCanonicalName() = " + t.getClass().getCanonicalName());
    }

    static void f2(Holder<?> holder){
        f1(holder);
    }

    public static void main(String[] args) {
        Holder holder = new Holder<>(1);
        f1(holder);
        f2(holder);
        Holder rawBasical = new Holder(new Object());
        f1(rawBasical);
        f2(rawBasical);
        Holder<?> wildcard = new Holder<>(1.0);
        f1(wildcard);
        f2(wildcard);
    }
}
