package chapter15generics;

import java.util.*;

public class New {
    public static <K,V> Map<K,V> map(){
        return new HashMap<>();
    }

    public static <T> List<T> list(){
        return new ArrayList<>();
    }

    public static <T> LinkedList<T> linkedList(){
        return new LinkedList<>();
    }

    public static <T> Set<T> set(){
        return new HashSet<>();
    }

    public static <T> Queue<T> queue(){
        return new LinkedList<>();
    }

    public static void main(String[] args) {
        Queue<String> list = New.queue();
        list.add("横看成岭侧成峰");
        list.add("远近高低各不同");
        list.add("不识庐山真面目");
        list.add("只缘身在此山中");
        System.out.println("list = " + list);

        Map<String, List<String>> map = New.map();

    }
}
