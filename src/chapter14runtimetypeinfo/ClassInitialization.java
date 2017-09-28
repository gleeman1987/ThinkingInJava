package chapter14runtimetypeinfo;

import java.util.Random;

public class ClassInitialization {
    public static Random random = new Random(47);

    public static void main(String[] args) throws ClassNotFoundException {
        Class<Initable> initableClass = Initable.class;
        System.out.println("After creating Initable ref : initableClass = " + initableClass);
        System.out.println(Initable.staticFinal);
        System.out.println(Initable.staticFinal2);
        System.out.println(Initable2.staticNonFinal);
        Class<?> aClass = Class.forName("chapter14runtimetypeinfo.Initable3");
        System.out.println("After creating Initable3 ref : aClass = " + aClass);
        System.out.println(Initable3.staticFinal);
    }

}

class Initable {
    public static final int staticFinal = 47;
    public static final int staticFinal2 = ClassInitialization.random.nextInt(100);
    static {
        System.out.println("Initable.static initializer");
    }
}

class Initable2{
    static int staticNonFinal = 147;
    static {
        System.out.println("Initable2.static initializer");
    }
}

class Initable3 {
    static int staticFinal = 74;
    static {
        System.out.println("Initable3.static initializer");
    }
}