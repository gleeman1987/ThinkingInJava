package chapter10innerclass;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/6/29.
 */
interface Selector{
    boolean end();
    Object current();
    void next();
}
public class Sequence {
    private Object[] items;
    private int next = 0;
    public Sequence(int size){
        items = new Object[size];
    }
    public void add(Object x){
        if (next < items.length){
            items[next++] = x;
        }
    }
    private class SequenceSelector implements Selector{
        public SequenceSelector() {
            //当内部类对象被创建时,此实例对象会秘密地捕获一个外部类对象的引用this
            //内部类的实例仅有在与其外部类对象相关联的时候才会被创建
            //内部类不能是static的类
        }

        private int i = 0;
        @Override
        public boolean end() {
            //内部类自动拥有对其外围类的所有成员的访问权
            return i==items.length;
        }

        @Override
        public Object current() {
            //内部类自动拥有对其外围类的所有成员的访问权
            return items[i];
        }

        @Override
        public void next() {
            //内部类自动拥有对其外围类的所有成员的访问权
            if (i < items.length){
                i++;
            }
        }
    }

    public Selector selector(){
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++) {
            sequence.add(Integer.toString(i));
        }
        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.print(selector.current()+" ");
            selector.next();
        }
    }
}

class SequenceIterator implements Selector{
    @Override
    public boolean end() {
        return false;
    }

    @Override
    public Object current() {
        return null;
    }

    @Override
    public void next() {

    }
}
