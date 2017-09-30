package chapter15generics;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/9/30.
 */
public class CreatorGeneric {
    public static void main(String[] args) {
        Creator creator = new Creator();
        X x = creator.get();
    }
}

abstract class GenericWithCreate<T> {
    final T element;
    abstract T create();

    public GenericWithCreate() {
        this.element = create();
    }
}

class X {}

class Creator extends GenericWithCreate<X> {

    public X get(){
        return element;
    }

    @Override
    X create() {
        return new X();
    }
}
