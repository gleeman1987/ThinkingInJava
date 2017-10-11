package chapter15generics;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/11
 * Mail:zhengjun1987@outlook.com
 */
class SelfBounded2<T extends SelfBounded2>{
    T element;

    public SelfBounded2<T> set(T element) {
        this.element = element;
        return this;
    }

    public T get() {
        return element;
    }
}

class A extends SelfBounded2<A>{}
class B extends SelfBounded2<A>{}
class C extends SelfBounded2<C>{
    C setAndGet(C arg){set(arg); return arg;}
}
class D {}
//class E extends SelfBounded2<D>{}
class F extends SelfBounded2{}

public class SelfBounding {
    public static void main(String[] args) {
        A a = new A();
        a.set(new A());
        a = a.set(new A()).get();
        a = a.get();

        C c = new C();
        c = c.setAndGet(new C());
    }
}
