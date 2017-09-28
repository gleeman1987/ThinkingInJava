package chapter14runtimetypeinfo;

import java.util.ArrayList;
import java.util.List;

public class FilledList<T> {
    private Class<T> tClass;

    public FilledList(Class<T> tClass) {
        this.tClass = tClass;
    }

    public List<T> create(int elements){
        List<T> tArrayList = new ArrayList<>();
        for (int i = 0; i < elements; i++) {
            try {
                tArrayList.add(tClass.newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return tArrayList;
    }

    public static void main(String[] args) {
        FilledList<CountedInteger> countedIntegerFilledList = new FilledList<>(CountedInteger.class);
        System.out.println(countedIntegerFilledList.create(15));//[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14]
    }
}

class CountedInteger {
    private static long counter;
    private final long id = counter++;

    @Override
    public String toString() {
        return Long.toString(id);
    }
}
