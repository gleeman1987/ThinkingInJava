package chapter16arrays;

import java.io.Serializable;
import java.util.*;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/23
 * Mail:zhengjun1987@outlook.com
 */
public class ArrayList<T> extends AbstractList<T> implements List<T>,RandomAccess,Serializable,Cloneable {
    private Object[] elementData;
    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    protected ArrayList() {
        super();
        elementData = new Object[10];
    }

    @Override
    public boolean add(T t) {
        return super.add(t);
    }

    @Override
    public T set(int index, T element) {
        return super.set(index, element);
    }

    @Override
    public void add(int index, T element) {
        super.add(index, element);
    }

    @Override
    public T remove(int index) {
        return super.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return super.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return super.lastIndexOf(o);
    }

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return super.addAll(index, c);
    }

    @Override
    public Iterator<T> iterator() {
        return super.iterator();
    }

    @Override
    public ListIterator<T> listIterator() {
        return super.listIterator();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return super.listIterator(index);
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return super.subList(fromIndex, toIndex);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        super.removeRange(fromIndex, toIndex);
    }
}
