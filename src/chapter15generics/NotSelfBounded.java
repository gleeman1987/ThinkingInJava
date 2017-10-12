package chapter15generics;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/11
 * Mail:zhengjun1987@outlook.com
 */
public class NotSelfBounded<T> {
    T element;

    public NotSelfBounded(T element) {
        this.element = element;
    }

    public T get() {
        return element;
    }

    public NotSelfBounded<T> set(T element) {
        this.element = element;
        return this;
    }
}

class A2 extends NotSelfBounded<A2>{
    public A2(A2 element) {
        super(element);
    }
}

class B2 extends NotSelfBounded<A2>{
    public B2(A2 element) {
        super(element);
    }
}

class C2 {}

class D2 extends NotSelfBounded<C2>{
    public D2(C2 element) {
        super(element);
    }
}