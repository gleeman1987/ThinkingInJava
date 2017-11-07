package chapter17containeradvanced;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/7
 * Mail:zhengjun1987@outlook.com
 */
public class Utilities {
    static List<String> list = Arrays.asList("one Two three Four five six one".split(" "));

    public static void main(String[] args) {
        System.out.println("list = " + list);
//        list = [one, Two, three, Four, five, six, one]
        System.out.println("Collections.disjoint(list,Collections.singletonList(\"Four\")) = " + Collections.disjoint(list, Collections.singletonList("Four")));
//        Collections.disjoint(list,Collections.singletonList("Four")) = false
        System.out.println("Collections.max(list) = " + Collections.max(list));
//        Collections.max(list) = three
        System.out.println("Collections.min(list) = " + Collections.min(list));
//        Collections.min(list) = Four
        System.out.println("Collections.max(list,String.CASE_INSENSITIVE_ORDER) = " + Collections.max(list, String.CASE_INSENSITIVE_ORDER));
//        Collections.max(list,String.CASE_INSENSITIVE_ORDER) = Two
        System.out.println("Collections.max(list,String.CASE_INSENSITIVE_ORDER) = " + Collections.min(list, String.CASE_INSENSITIVE_ORDER));
//        Collections.max(list,String.CASE_INSENSITIVE_ORDER) = five
        List<String> subList = Arrays.asList("Four five six".split(" "));
        System.out.println("Collections.indexOfSubList(list,subList) = " + Collections.indexOfSubList(list, subList));
//        Collections.indexOfSubList(list,subList) = 3
        System.out.println("Collections.lastIndexOfSubList(list,subList) = " + Collections.lastIndexOfSubList(list, subList));
//        Collections.lastIndexOfSubList(list,subList) = 3
        System.out.println("Collections.replaceAll(list,\"one\",\"Yo\") = " + Collections.replaceAll(list, "one", "Yo"));
//        Collections.replaceAll(list,"one","Yo") = true
        System.out.println("replaceAll = " + list);
//        replaceAll = [Yo, Two, three, Four, five, six, Yo]
        Collections.reverse(list);
        System.out.println("reverse = " + list);
//        reverse = [Yo, six, five, Four, three, Two, Yo]
        Collections.rotate(list,3);
        System.out.println("rotate = " + list);
//        rotate = [three, Two, Yo, Yo, six, five, Four]
        List<String> sourcr = Arrays.asList("in the matrix".split(" "));
        Collections.copy(list,sourcr);
        System.out.println("copy = " + list);
//        copy = [in, the, matrix, Yo, six, five, Four]
        Collections.swap(list,0,list.size()-1);
        System.out.println("swap = " + list);
        Collections.shuffle(list,new Random(47));
        System.out.println("shuffle = " + list);
        Collections.fill(list,"pop");
        System.out.println("pop = " + list);
        System.out.println("Collections.frequency(list,\"pop\") = " + Collections.frequency(list, "pop"));
        List<String> nCopies = Collections.nCopies(3, "snap");
        System.out.println("nCopies = " + nCopies);
        System.out.println("Collections.disjoint(list,nCopies) = " + Collections.disjoint(list, nCopies));
    }
}
