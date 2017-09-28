package chapter14runtimetypeinfo;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/9/23.
 */
public class InterfaceViolation {
    public static void main(String[] args) {
        A a = new B();
        System.out.println("a = " + a);
        System.out.println(a.getClass().getCanonicalName());
        a.f();
//        a.g();
        if (a instanceof B) {
            B b = (B)a;
            System.out.println("b = " + b);
            b.g();
        }
//        a = chapter14runtimetypeinfo.B@610455d6
//        chapter14runtimetypeinfo.B
//        B.f
//                b = chapter14runtimetypeinfo.B@610455d6
//        B.g
    }
}

class B implements A {

    @Override
    public void f() {
        System.out.println("B.f");
    }

    public void g(){
        System.out.println("B.g");
    }
}
