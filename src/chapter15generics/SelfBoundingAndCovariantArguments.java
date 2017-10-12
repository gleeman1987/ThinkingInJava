package chapter15generics;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/12
 * Mail:zhengjun1987@outlook.com
 */
interface SelfBoundedSetter<T extends SelfBoundedSetter<T>>{
    void set(T arg);
}

interface Setter extends SelfBoundedSetter<Setter>{}

public class SelfBoundingAndCovariantArguments {
    void test(Setter setter1,Setter setter2,SelfBoundedSetter selfBoundedSetter){
        setter1.set(setter2);
//        setter1.set(selfBoundedSetter);
        selfBoundedSetter.set(setter2);
    }
}
