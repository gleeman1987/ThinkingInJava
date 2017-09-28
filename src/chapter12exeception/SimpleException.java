package chapter12exeception;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/9/16.
 */
public class SimpleException extends Exception {
}

class InheritingExeceptions{
    public static void main(String[] args) {
        InheritingExeceptions inheritingExeceptions = new InheritingExeceptions();
        try {
            inheritingExeceptions.f();
        } catch (SimpleException e) {
//            System.out.println("Caught it!");
            System.err.println("caught it!");
        }
    }

    public void f() throws SimpleException {
        System.out.println("InheritingExeceptions.f()");
        throw new SimpleException();
    }
}


