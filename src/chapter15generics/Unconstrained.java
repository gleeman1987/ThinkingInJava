package chapter15generics;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/11
 * Mail:zhengjun1987@outlook.com
 */
class Other{}
class BasicOther extends BasicHolder<Other>{}

public class Unconstrained {

    public static void main(String[] args) {
        BasicOther basicOther1 = new BasicOther(),basicOther2 = new BasicOther();
        basicOther1.set(new Other());
        Other other = basicOther1.get();
        basicOther1.f();
    }
}
