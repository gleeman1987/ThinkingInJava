package chapter15generics;

import chapter14runtimetypeinfo.Individual;

public class Holder3<T> {
    private T t;

    public Holder3(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public void set(T t) {
        this.t = t;
    }

    public static void main(String[] args) {
        Holder3<AutoMobile> autoMobileHolder3 = new Holder3<>(null);
        autoMobileHolder3.set(new AutoMobile());
        AutoMobile autoMobile = autoMobileHolder3.get();
        System.out.println("autoMobileHolder3 = " + autoMobileHolder3);

        Holder<Individual> individualHolder = new Holder<>(new Individual());
        System.out.println("individualHolder.getClass() = " + individualHolder.getClass());
    }
}

class Holder<E>{
    private E t;

    public Holder(E t) {
        System.out.println("t.getClass().getCanonicalName() = " + t.getClass().getCanonicalName());
        this.t = t;
    }

    public E get() {
        return t;
    }

    public void set(E t) {
        this.t = t;
    }
}

class Holder4<S>{
    private S t;

    public Holder4(S t) {
        this.t = t;
    }

    public S get() {
        return t;
    }

    public void set(S t) {
        this.t = t;
    }
}
