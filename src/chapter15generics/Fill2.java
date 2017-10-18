package chapter15generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/18
 * Mail:zhengjun1987@outlook.com
 */

interface Addable<T> {
    void add(T t);
}

public class Fill2 {
    public static <T> void fill(Addable<T> addable,Class<? extends T> clazz,int size){
        for (int i = 0; i < size; i++) {
            try {
                addable.add(clazz.newInstance());
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
    }

    public static <T> void fill(Addable<T> addable,Generator<? extends T> generator,int size){
        for (int i = 0; i < size; i++) {
            addable.add(generator.next());
        }
    }
}

class AddableCollectionAdapter<T> implements Addable<T>{
    private Collection<T> collection;

    public AddableCollectionAdapter(Collection<T> collection) {
        this.collection = collection;
    }

    @Override
    public void add(T t) {
        collection.add(t);
    }
}

class Adapter {
    public static <T> Addable<T> collectionAdapter(Collection<T> collection){
        return new AddableCollectionAdapter<>(collection);
    }
}

class AddableSimpleQueue<T> extends SimpleQueue<T> implements Addable<T>{
    @Override
    public void add(T t) {
        super.add(t);
    }
}

class Fill2Test {
    public static void main(String[] args) {
        List<Coffe> coffes = new ArrayList<>();
        Fill2.fill(Adapter.collectionAdapter(coffes),Coffe.class,3);
        Fill2.fill(new AddableCollectionAdapter<Coffe>(coffes),Latte.class,2);
        System.out.println("coffes = " + coffes);
        System.out.println("-----------------------");
        AddableSimpleQueue<Coffe> coffeAddableSimpleQueue = new AddableSimpleQueue<>();
        Fill2.fill(coffeAddableSimpleQueue,Mocha.class,4);
        Fill2.fill(coffeAddableSimpleQueue,Americano.class,4);
        for (Coffe coffe : coffeAddableSimpleQueue) {
            System.out.println("coffe = " + coffe);
        }
//        coffes = [Coffe 0, Coffe 1, Coffe 2, Latte 3, Latte 4]
//        -----------------------
//        coffe = Mocha 5
//        coffe = Mocha 6
//        coffe = Mocha 7
//        coffe = Mocha 8
//        coffe = Americano 9
//        coffe = Americano 10
//        coffe = Americano 11
//        coffe = Americano 12
    }
}