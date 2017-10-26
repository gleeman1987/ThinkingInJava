package chapter17containeradvanced;

import java.util.*;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/26
 * Mail:zhengjun1987@outlook.com
 */
public class Unsupported {
    static void test(String message, List<String> list){
        System.out.println("---"+message+"---");
        Collection<String> collection = list;
        List<String> subList = list.subList(1, 8);
        List<String> strings = new ArrayList<>(subList);

        try {
            collection.retainAll(strings);
        } catch (Exception e) {
            System.out.println("retainAll()  "+e);
        }
        try {
            collection.removeAll(strings);
        } catch (Exception e) {
            System.out.println("removeAll()  "+e);
        }
        try {
            collection.clear();
        } catch (Exception e) {
            System.out.println("clear()  "+e);
        }
        try {
            collection.add("X");
        } catch (Exception e) {
            System.out.println("add()  "+e);
        }
        try {
            collection.addAll(strings);
        } catch (Exception e) {
            System.out.println("addAll()  "+e);
        }
        try {
            collection.remove("C");
        } catch (Exception e) {
            System.out.println("remove()  "+e);
        }
        try {
            list.set(0,"X");
        } catch (Exception e) {
            System.out.println("set()  "+e);
        }
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("ABCDEFGHIJKL".split(""));
        test("Modifiable Copy",new ArrayList<>(strings));
        test("Arrays.asList()",strings);
        test("UnmodifiableList", Collections.unmodifiableList(new ArrayList<>(strings)));
//        ---Modifiable Copy---
//        ---Arrays.asList()---
//        retainAll()  java.lang.UnsupportedOperationException
//        removeAll()  java.lang.UnsupportedOperationException
//        clear()  java.lang.UnsupportedOperationException
//        add()  java.lang.UnsupportedOperationException
//        addAll()  java.lang.UnsupportedOperationException
//        remove()  java.lang.UnsupportedOperationException
//        ---UnmodifiableList---
//        retainAll()  java.lang.UnsupportedOperationException
//        removeAll()  java.lang.UnsupportedOperationException
//        clear()  java.lang.UnsupportedOperationException
//        add()  java.lang.UnsupportedOperationException
//        addAll()  java.lang.UnsupportedOperationException
//        remove()  java.lang.UnsupportedOperationException
//        set()  java.lang.UnsupportedOperationException
    }
}
