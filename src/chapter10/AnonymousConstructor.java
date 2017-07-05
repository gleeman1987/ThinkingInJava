package chapter10;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/6/30.
 */
public class AnonymousConstructor {
    public static void main(String[] args) {
        Base base = getBase(47);
        System.out.println("+++++++++++++++++");
        base.f();
    }

    private static Base getBase(int i) {
        return new Base(i) {
            {
                System.out.println("Inside instance initializer!");
                System.out.println(getClass().getName());
            }
            @Override
            public void f() {
                System.out.println(getClass().getName()+".f()");
            }
        };
    }

}
abstract class Base{
    public Base(int i) {
        System.out.println("Base.Constructor  i:"+i);
    }

    public abstract void f();
}
