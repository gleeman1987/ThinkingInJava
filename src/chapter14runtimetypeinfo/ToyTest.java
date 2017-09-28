package chapter14runtimetypeinfo;

import java.lang.reflect.Field;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/9/21.
 */
public class ToyTest {
    static void printInfo(Class cls){
        System.out.println("Class name : "+cls.getName()+" , isInterface:"+cls.isInterface());
        System.out.println("Simple name : "+cls.getSimpleName());
        System.out.println("Canonical name : "+cls.getCanonicalName());
        System.out.println("---------------------------------------------------------------");
    }
    public static void main(String[] args) {
        Class cls = null;
        try {
            cls = Class.forName("chapter14runtimetypeinfo.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("Cannot find FancyToy");
            System.exit(1);
        }
        printInfo(cls);

        for (Class aClass : cls.getInterfaces()) {
            printInfo(aClass);
        }
        Class superclass = cls.getSuperclass();
        printInfo(superclass);
//
//        Object object = null;
//        try {
//            object = superclass.newInstance();
//        } catch (InstantiationException e) {
//            System.out.println("Cannot instanciate");
//            System.exit(1);
//        } catch (IllegalAccessException e) {
//            System.out.println("Cannot access");
//            System.exit(1);
//        }
//        printInfo(object.getClass());

        printTree(Integer.TYPE);
        printTree(Integer.class);
        System.out.println("---------------------");
        System.out.println(Integer.SIZE);
        System.out.println(Integer.BYTES);
    }

    static void printTree(Class clazz){
        System.out.println(clazz.getCanonicalName());
        for (Field field : clazz.getDeclaredFields()) {
            System.out.println(field);
        }
        Class superclass = clazz.getSuperclass();
        if (superclass != null) {
            printTree(superclass);
        }
    }

}

interface HasBatteries{}

interface Shoots{}

interface Waterproof{}

interface Plastics{}

class Toy{
    public Toy() {
    }
    public Toy(int i) {
    }
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots, Plastics {
    public FancyToy() {
        super(1);
    }
}
