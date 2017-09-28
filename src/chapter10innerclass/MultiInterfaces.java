package chapter10innerclass;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/7/5.
 */
public class MultiInterfaces {
    public static void main(String[] args) {
        X x = new X();
        takeA(x);
        takeB(x);
        Y y = new Y();
        takeA(y);
        takeB(y.getB());
    }

    static void takeA(A a){
        a.a();
    }

    static void takeB(B b){
        b.b();
    }
}

interface A {
    void a();
}

interface B {
    void b();
}

class X implements A,B{
    @Override
    public void a() {
        System.out.println(getClass().getName()+"X.a");
    }

    @Override
    public void b() {
        System.out.println(getClass().getName()+"X.b");
    }
}

class Y implements A{
    @Override
    public void a() {
        System.out.println(getClass().getName()+"Y.a");
    }

    B getB(){
        return new B() {
            @Override
            public void b() {
                System.out.println(getClass().getName()+"Y.b");
            }
        };
    }
}
