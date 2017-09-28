package chapter08polymophism;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/6/27.
 */
public abstract class Base {
    public static void main(String[] args) {
    }
    abstract void play();

    static void test(Base base){
        System.out.println("Base.test");
        extention base1 = (extention) base;
        base1.test(base1);
    }
}

abstract class extention extends Base{

    abstract void play();
}
