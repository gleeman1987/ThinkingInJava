package chapter15generics;

public class SimpleHolder {
    private Object object;
    public void set(Object o){
        object = o;
    }

    public Object get() {
        return object;
    }

    public static void main(String[] args) {
        SimpleHolder simpleHolder = new SimpleHolder();
        simpleHolder.set("Item");
        String item = (String) simpleHolder.get();
    }
}
