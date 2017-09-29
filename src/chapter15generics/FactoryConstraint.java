package chapter15generics;

public class FactoryConstraint {
    public static void main(String[] args) {
        new Foo2<Integer>(new IntegerFactory());
        new Foo2<Widget>(new Widget.WidgetFactory());
    }
}

interface FactoryI<T> {
    T create();
}

class Foo2<T> {
    private T x;
    public  Foo2 (FactoryI<T> f){
        x = f.create();
    }
}

class IntegerFactory implements FactoryI<Integer>{
    @Override
    public java.lang.Integer create() {
        return new Integer(0);
    }
}

class Widget  {
    public static class WidgetFactory implements FactoryI<Widget>{
        @Override
        public Widget create() {
            return new Widget();
        }
    }
}