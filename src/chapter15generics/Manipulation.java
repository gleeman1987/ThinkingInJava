package chapter15generics;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/9/27.
 */
public class Manipulation {
    public static void main(String[] args) {
        Manipulator<HasF> hasFManipulator = new Manipulator<>(new HasF());
        hasFManipulator.manipulate();
        Manipulator<Double> doubleManipulator = new Manipulator<>(1.3);
        doubleManipulator.manipulate();

        Manipulator2<HasF> hasFManipulator2 = new Manipulator2<>(new HasF());
        hasFManipulator2.manipulate();//由于Manipulator2的泛型指定了extends HasF,对f()的调用可以通过编译
//        HasF.f

        Manipulator3 manipulator3 = new Manipulator3(new HasF());
        manipulator3.manipulate();//Manipulator3指定了成员变量的类型为HasF,与Manipulator2完全一样,所以此处使用泛型extends HasF没有发挥泛型的更多好处
//        HasF.f

        ManipulatorReturnGenericType<HasF> hasFManipulatorReturnGenericType = new ManipulatorReturnGenericType<>(new HasF());
        //仅有在你使用的泛型类型 比 某个具体类型及其子类 更加泛化时,也就是说,当你希望你的代码能够跨越多个类工作时,使用泛型才有实际意义
        hasFManipulatorReturnGenericType.get().f();
//        HasF.f
    }
}

class HasF {
    public void f(){
        System.out.println("HasF.f");
    }
}

class Manipulator<T> {
    private T t;

    public Manipulator(T t) {
        this.t = t;
//        if (t instanceof HasF) {
//            HasF hasF = (HasF)t;
//            hasF.f();
//        }
    }

    public void manipulate(){
        //Java在编译后擦除了泛型信息,编译之前默认使用Object处理
        System.out.println(t.getClass().getCanonicalName());
    }
}