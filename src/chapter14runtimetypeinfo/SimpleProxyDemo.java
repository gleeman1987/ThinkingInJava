package chapter14runtimetypeinfo;

public class SimpleProxyDemo {
    public static void main(String[] args) {
        consumer(new RealObject());
        System.out.println("------------------------");
        consumer(new SimpleProxy(new RealObject()));
    }

    public static void consumer(Interface i){
        i.doSomething();
        i.somethingElse("bonobo");
    }
}

interface Interface {
    void doSomething();
    void somethingElse(String arg);
}

class RealObject implements Interface {
    @Override
    public void doSomething() {
        System.out.println("RealObject.doSomething");
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("RealObject.somethingElse  arg = [" + arg + "]");
    }
}

class SimpleProxy implements Interface {
    private Interface proxied;

    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        System.out.println("SimpleProxy.doSomething");
        proxied.doSomething();
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("SimpleProxy.somethingElse  arg = [" + arg + "]");
        proxied.somethingElse(arg);
    }
}
