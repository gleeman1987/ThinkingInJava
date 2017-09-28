package chapter15generics;

public class ManipulatorReturnGenericType<T extends HasF> {
    private T t;

    public ManipulatorReturnGenericType(T t) {
        this.t = t;
    }

    public T manipulate(){
        t.f();
        return t;
    }

    public T get(){//仅有在你使用的泛型类型 比 某个具体类型及其子类 更加泛化时
                        //也就是说,当你希望你的代码能够跨越多个类工作时,使用泛型才有实际意义
        return t;
    }
}
