package chapter15generics;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/12
 * Mail:zhengjun1987@outlook.com
 */
class OrdinarySetter {
    void set(Base base){
        System.out.println("OrdinarySetter.set");
    }
}

class DerivedSetter extends OrdinarySetter {
    void set(Derived base) {
        System.out.println("DerivedSetter.set");
    }
}
public class OrdinaryArguments {
    public static void main(String[] args) {
        Base base = new Base();
        Derived derived = new Derived();
        DerivedSetter derivedSetter = new DerivedSetter();
        derivedSetter.set(derived);//DerivedSetter.set
        derivedSetter.set(base);//OrdinarySetter.set
    }
}
