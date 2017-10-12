package chapter15generics;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/12
 * Mail:zhengjun1987@outlook.com
 */
class GenericSetter<T> {
    void set(T t){
        System.out.println("GenericSetter.set");
    }
}

class DerivedGS extends GenericSetter<Base>{
    void set(Derived derived){
        System.out.println("DerivedGS.set");
    }
}
public class PlainGenericInheritance {
    public static void main(String[] args) {
        Base base = new Base();
        Derived derived = new Derived();
        DerivedGS derivedGS = new DerivedGS();
        derivedGS.set(derived);//DerivedGS.set
        derivedGS.set(base);//GenericSetter.set
    }
}
