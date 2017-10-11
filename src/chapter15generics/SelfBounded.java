package chapter15generics;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/11
 * Mail:zhengjun1987@outlook.com
 */
public class SelfBounded<T extends SelfBounded> {
    private T t;

    public SelfBounded(T t) {
        this.t = t;
    }

    public SelfBounded() {
    }
}
