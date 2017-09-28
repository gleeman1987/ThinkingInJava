package chapter15generics;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/9/26.
 */
public class GenericMethods {
    public <T> void f(T t){
        System.out.println("t = " + t.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        GenericMethods genericMethods = new GenericMethods();
        genericMethods.f(" ");
        genericMethods.f(1);
        genericMethods.f(1.0);
        genericMethods.f(1.0f);
        genericMethods.f('a');
        genericMethods.f(genericMethods);
    }
//    t = String
//            t = Integer
//    t = Double
//            t = Float
//    t = Character
//            t = GenericMethods
}
