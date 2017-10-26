package chapter17containeradvanced;

import java.util.Collections;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/26
 * Mail:zhengjun1987@outlook.com
 */
public class SortedSetDemo {

    public static final String[] ELEMENTS = "one two three four five six seven eight".split(" ");

    public static void main(String[] args) {
        SortedSet<String> sortedSet = new TreeSet<>();
        Collections.addAll(sortedSet, ELEMENTS);
        System.out.println("sortedSet = " + sortedSet);
//        sortedSet = [eight, five, four, one, seven, six, three, two]
        String first = sortedSet.first();
        String last = sortedSet.last();
        System.out.println("first = " + first);
//        first = eight
        System.out.println("last = " + last);
//        last = two

        Iterator<String> iterator = sortedSet.iterator();
        for (int i = 0; i < 6; i++) {
            if (i == 3) {
                first = iterator.next();
            }
            if (i == 6) {
                last = iterator.next();
            } else {
                iterator.next();
            }
        }

        System.out.println("first = " + first);
//        first = one
        System.out.println("last = " + last);
//        last = two
        System.out.println("sortedSet.subSet(first,last) = " + sortedSet.subSet(first, last));
//        sortedSet.subSet(first,last) = [one, seven, six, three]
        System.out.println("sortedSet.headSet(last) = " + sortedSet.headSet(last));
//        sortedSet.headSet(last) = [eight, five, four, one, seven, six, three]
        System.out.println("sortedSet.tailSet(first) = " + sortedSet.tailSet(first));
//        sortedSet.tailSet(first) = [one, seven, six, three, two]
        System.out.println("--------------------------------------------");
        sortedSet.clear();
        System.out.println("sortedSet = " + sortedSet);
        for (int i = 0; i < ELEMENTS.length; i++) {
            sortedSet.add(ELEMENTS[i]);
            System.out.println("sortedSet = " + sortedSet);
        }
//        sortedSet = []
//        sortedSet = [one]
//        sortedSet = [one, two]
//        sortedSet = [one, three, two]
//        sortedSet = [four, one, three, two]
//        sortedSet = [five, four, one, three, two]
//        sortedSet = [five, four, one, six, three, two]
//        sortedSet = [five, four, one, seven, six, three, two]
//        sortedSet = [eight, five, four, one, seven, six, three, two]
    }
}
