package chapter17containeradvanced;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/26
 * Mail:zhengjun1987@outlook.com
 */
public class Lists {
    private static boolean b;
    private static String string;
    private static int i;
    private static Iterator iterator;
    private static ListIterator listIterator;
    public static void basicalTest(List<String> strings){
        System.out.println("------------------Lists.basicalTest------------------");
        strings.add(0,"X");
        System.out.println("strings = " + strings);
        strings.add("X");
        System.out.println("strings = " + strings);
        strings.addAll(Countries.names(25));
        System.out.println("strings = " + strings);
        strings.addAll(3,Countries.names(25));
        System.out.println("strings = " + strings);
        b = strings.contains("1");
        System.out.println("strings.contains(\"1\") = " + strings.contains("1"));
        b = strings.containsAll(Countries.names(25));
        string = strings.get(1);
        i = strings.indexOf("a");
        b = strings.isEmpty();
        iterator = strings.iterator();
        listIterator = strings.listIterator();
        listIterator = strings.listIterator(2);
        i = strings.lastIndexOf("a");
        strings.remove(1);
        strings.remove("3");
        strings.set(1,"Y");
        strings.retainAll(Countries.names(25));
        i = strings.size();
        strings.clear();
    }

    public static void iterMotion(List<String> list){
        ListIterator<String> stringListIterator = list.listIterator();
        boolean hasNext = stringListIterator.hasNext();
        boolean hasPrevious = stringListIterator.hasPrevious();
        String next = stringListIterator.next();
        String previous = stringListIterator.previous();
        int nextIndex = stringListIterator.nextIndex();
        int previousIndex = stringListIterator.previousIndex();
    }

    public static void iterManipulation(List<String> strings){
        ListIterator<String> stringListIterator = strings.listIterator();
        stringListIterator.add("47");
        stringListIterator.next();
        stringListIterator.remove();
        stringListIterator.next();
        stringListIterator.set("47");
    }
}
