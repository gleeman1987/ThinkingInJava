package chapter15generics;

public class ErasureAndInheritance {
    public static void main(String[] args) {
        Derived2 derived2 = new Derived2();
        //Derived2未规范使用类型,证明了泛型无法通过继承传递给子类/扩展类
        derived2.set(System.out);
        derived2.set(" ");

        Derived1<String> stringDerived1 = new Derived1<>();
        //Derived1规范了使用类型
//        stringDerived1.set(System.out);
        stringDerived1.set(" ");
    }
}

class GenericBase<T> {
    private T element;

    public void set(T t){
        System.out.println("t = [" + t + "]");
        element = t;
    }

    public T get(){
        return element;
    }
}

class Derived1<T> extends GenericBase<T> { }

class Derived2 extends GenericBase { }