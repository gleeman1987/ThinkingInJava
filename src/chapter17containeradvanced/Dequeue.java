package chapter17containeradvanced;

import java.util.Collection;
import java.util.LinkedList;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/30
 * Mail:zhengjun1987@outlook.com
 */
public class Dequeue<T> {
    private LinkedList<T> deque = new LinkedList<>();

    public T getFirst() {
        return deque.getFirst();
    }

    public T getLast() {
        return deque.getLast();
    }

    public T removeFirst() {
        return deque.removeFirst();
    }

    public T removeLast() {
        return deque.removeLast();
    }

    public void addFirst(T t) {
        deque.addFirst(t);
    }

    public void addLast(T t) {
        deque.addLast(t);
    }

    public int size() {
        return deque.size();
    }

    public boolean containsAll(Collection<?> c) {
        return deque.containsAll(c);
    }

    @Override
    public String toString() {
        return deque.toString();
    }
}
