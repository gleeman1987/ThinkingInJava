package chapter15generics;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/17
 * Mail:zhengjun1987@outlook.com
 */
public class SimpleQueue<T> implements Iterable<T> {
    private LinkedList<T> storage = new LinkedList<>();

    public void add(T t){storage.offer(t);}

    public T get(){return storage.poll();}

    @Override
    public Iterator<T> iterator() {
        return storage.iterator();
    }
}
