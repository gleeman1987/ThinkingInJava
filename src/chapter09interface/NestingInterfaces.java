package chapter09interface;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/6/28.
 */
class A {
    interface B {
        void f();
    }

    interface C {
        void f();
    }

    private interface D {
        void f();
    }

    public class BImpl implements B {
        @Override
        public void f() {

        }
    }

    public class BImpl2 implements B {
        @Override
        public void f() {

        }
    }

    public class CImpl implements C {
        @Override
        public void f() {

        }
    }

    public class CImpl2 implements C {
        @Override
        public void f() {

        }
    }

    public class DImpl implements D {
        @Override
        public void f() {

        }
    }

    public class DImpl2 implements D {
        @Override
        public void f() {

        }
    }

    public D getD() {
        return new DImpl2();
    }

    private D dRef;

    public void receiveD(D d) {
        dRef = d;
        dRef.f();
    }
}

interface E {
    interface G {
        void f();
    }

    public interface H {
        void f();
    }

    void g();
}

public class NestingInterfaces {
    public class BImpl implements A.B {
        @Override
        public void f() {

        }
    }

    class CImpl implements A.C {
        @Override
        public void f() {

        }
    }

    //    class DImpl implements A.D{
//        @Override
//        public void f() {
//
//        }
//    }
    class EImpl implements E {
        @Override
        public void g() {

        }
    }

    class EGImpl implements E.G{
        @Override
        public void f() {

        }
    }

   class EImpl2 implements E{
       @Override
       public void g() {

       }

       class EG implements G{
           @Override
           public void f() {

           }
       }
   }

    public static void main(String[] args) {
        A a = new A();
//        A.D aD = a.getD();
        A.DImpl2 d = (A.DImpl2) a.getD();
//        a.getD().f();
        a.receiveD(a.getD());
    }
}
