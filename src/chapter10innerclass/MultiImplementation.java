package chapter10innerclass;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/7/5.
 */
public class MultiImplementation {
    static void takeD(D d){d.d();}
    static void takeE(E e){e.e();}

    public static void main(String[] args) {
        Z z = new Z();
        takeD(z);
        takeE(z.makeE());
    }
}

class D {
    void d(){
        System.out.println("D.d");
    }
}
abstract class E {
    abstract void e();
}

class Z extends D{
    @Override
    void d() {
        super.d();
        System.out.println("Z.d");
    }

    E makeE(){
        return new E() {
            @Override
            void e() {
                System.out.println("Z.e");
            }
        };
    }
}
