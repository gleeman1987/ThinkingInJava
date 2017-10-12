package chapter15generics;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/12
 * Mail:zhengjun1987@outlook.com
 */
class Base{}
class Derived extends Base{}
interface OrdinaryGetter {
    Base get();
}

interface DerivedGetter extends OrdinaryGetter{
    Derived get();
}

public class CovariantReturnTypes {
    void test(DerivedGetter derivedGetter){
        Derived derived = derivedGetter.get();
    }
}
