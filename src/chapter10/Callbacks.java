package chapter10;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/7/6.
 */
public class Callbacks {
    public static void main(String[] args) {
        Callee1 callee1 = new Callee1();
        Callee2 callee2 = new Callee2();
        MyIncrement.f(callee2);
        Caller caller = new Caller(callee1);
        Caller caller1 = new Caller(callee2.getCallbackReference());
        caller.go();
        caller.go();
        caller1.go();
        caller1.go();
    }
}

interface Incrementable{
    void increment();
}

class Callee1 implements Incrementable{
    private int i = 0;
    @Override
    public void increment() {
        i++;
        System.out.println("i = " + i);
    }
}

class MyIncrement {
    public void increment(){
        System.out.println("其他操作");
    }
    static void f(MyIncrement myIncrement){myIncrement.increment();}
}

class Callee2 extends MyIncrement{
    private int i = 0;

    @Override
    public void increment() {
        super.increment();
        i++;
        System.out.println("i = " + i);
    }

    private class Closure implements Incrementable{
        @Override
        public void increment() {
            Callee2.this.increment();
        }
    }

    Incrementable getCallbackReference(){
        return this.new Closure();
    }
}

class Caller{
    private Incrementable callbackReference;

    public Caller(Incrementable callbackReference) {
        this.callbackReference = callbackReference;
    }

    void go(){
        callbackReference.increment();
    }
}