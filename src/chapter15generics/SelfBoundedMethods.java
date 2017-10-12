package chapter15generics;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/12
 * Mail:zhengjun1987@outlook.com
 */
public class SelfBoundedMethods {
    static <T extends SelfBounded2<T>> T f(T arg){
        //可以限定方法参数的具体类型不超越规定的类型及子类之外
        return arg.set(arg).get();
    }

    public static void main(String[] args) {
        A a = f(new A());
    }
}
