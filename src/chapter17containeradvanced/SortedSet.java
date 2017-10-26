package chapter17containeradvanced;

import java.util.*;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/26
 * Mail:zhengjun1987@outlook.com
 */
public class SortedSet<E> implements Set<E> {
    private LinkedList<E> eLinkedList;

    public SortedSet() {
        eLinkedList = new LinkedList<>();
    }

    @Override
    public int size() {
        return eLinkedList.size();
    }

    @Override
    public boolean isEmpty() {
        return eLinkedList.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return eLinkedList.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return eLinkedList.iterator();
    }

    @Override
    public Object[] toArray() {
        return eLinkedList.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return eLinkedList.toArray(a);
    }

    @Override
    public boolean add(E e) {
        boolean add = eLinkedList.add(e);
        return add;
    }

    @Override
    public boolean remove(Object o) {
        return eLinkedList.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return eLinkedList.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return eLinkedList.addAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return eLinkedList.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return eLinkedList.removeAll(c);
    }

    @Override
    public void clear() {
        eLinkedList.clear();
    }

    /**
     * Returns a string representation of this collection.  The string
     * representation consists of a list of the collection's elements in the
     * order they are returned by its iterator, enclosed in square brackets
     * (<tt>"[]"</tt>).  Adjacent elements are separated by the characters
     * <tt>", "</tt> (comma and space).  Elements are converted to strings as
     * by {@link String#valueOf(Object)}.
     *
     * @return a string representation of this collection
     */
    public String toString() {
        Iterator<E> it = iterator();
        if (! it.hasNext())
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (;;) {
            E e = it.next();
            sb.append(e == this ? "(this Collection)" : e);
            if (! it.hasNext())
                return sb.append(']').toString();
            sb.append(',').append(' ');
        }
    }

    public static void main(String[] args) {
        SortedSet<String> stringSortedSet = new SortedSet<>();
        System.out.println("stringSortedSet = " + stringSortedSet);
        for (int i = 0; i < SortedSetDemo.ELEMENTS.length; i++) {
            stringSortedSet.add(SortedSetDemo.ELEMENTS[i]);
            System.out.println("stringSortedSet = " + stringSortedSet);
        }
//        stringSortedSet = []
//        stringSortedSet = [one]
//        stringSortedSet = [one, two]
//        stringSortedSet = [one, two, three]
//        stringSortedSet = [one, two, three, four]
//        stringSortedSet = [one, two, three, four, five]
//        stringSortedSet = [one, two, three, four, five, six]
//        stringSortedSet = [one, two, three, four, five, six, seven]
//        stringSortedSet = [one, two, three, four, five, six, seven, eight]
    }
}
