package chapter17containeradvanced;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;
import java.util.Random;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/9
 * Mail:zhengjun1987@outlook.com
 */
public class ListSortSearch {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>(Utilities.list);
        strings.addAll(Utilities.list);
        System.out.println("strings = " + strings);
//        strings = [one, Two, three, Four, five, six, one, one, Two, three, Four, five, six, one]
        Collections.shuffle(strings,new Random(47));
        System.out.println("Shuffled strings = " + strings);
//        Shuffled strings = [Four, five, one, one, Two, six, six, three, three, five, Four, Two, one, one]
        ListIterator<String> stringListIterator = strings.listIterator(10);
        while (stringListIterator.hasNext()){
            stringListIterator.next();
            stringListIterator.remove();
        }
        System.out.println("Trimmed strings = " + strings);
//        Trimmed strings = [Four, five, one, one, Two, six, six, three, three, five]

        String key = strings.get(7);
        System.out.println("Collections.binarySearch(strings,key) = " + Collections.binarySearch(strings, key));
//        Collections.binarySearch(strings,key) = 7

        Collections.sort(strings,String.CASE_INSENSITIVE_ORDER);
        System.out.println("Sorted strings = " + strings);
//        Sorted strings = [five, five, Four, one, one, six, six, three, three, Two]
        key = strings.get(7);
        System.out.println("Collections.binarySearch(strings,key) = " + Collections.binarySearch(strings, key));
//        Collections.binarySearch(strings,key) = 7
    }
}
