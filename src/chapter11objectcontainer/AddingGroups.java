package chapter11objectcontainer;

import java.util.*;

public class AddingGroups {
    public static void main(String[] args) {
        Collection<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Integer[] more = {7, 8, 9, 10};
        integers.addAll(Arrays.asList(more));
        printArrays(integers);
        Collections.addAll(integers,11,12,13,14,15);
        printArrays(integers);
        List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);
        list.set(1,99);
        printArrays(list);
//        list.add(100);
//        printArrays(list);
//        -----------------------------------
//        Exception in thread "main" java.lang.UnsupportedOperationException
//        at java.util.AbstractList.add(AbstractList.java:148)
//        at java.util.AbstractList.add(AbstractList.java:108)
//        at chapter11objectcontainer.AddingGroups.main(AddingGroups.java:16)
    }

    private static void printArrays(Collection<Integer> integers) {
        for (Integer integer : integers) {
            System.out.print(integer+"  ");
        }
        System.out.println();
    }
}
