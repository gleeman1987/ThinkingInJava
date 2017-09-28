package chapter11objectcontainer;

import java.util.*;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/9/14.
 */
public class PrintingContainers {
    public static void main(String[] args) {
        System.out.println(fill(new ArrayList<String>()));//        [rat, cat, dog, dog]
        System.out.println(fill(new LinkedList<String>()));//        [rat, cat, dog, dog]
        System.out.println(fill(new HashSet<String>()));//        [rat, cat, dog]
        System.out.println(fill(new TreeSet<String>()));//        [rat, cat, dog]
        System.out.println(fill(new LinkedHashSet<String>()));//        [rat, cat, dog]

        //键值对dog-Bart已被覆盖
        System.out.println(fill(new HashMap<String, String>()));//        {rat=Mickey, cat=Garfield, dog=Barry}
        System.out.println(fill(new TreeMap<String, String>()));//        {cat=Garfield, dog=Barry, rat=Mickey}
        System.out.println(fill(new LinkedHashMap<String, String>()));//        {rat=Mickey, cat=Garfield, dog=Barry}

//        [rat, cat, dog, dog]
//        [rat, cat, dog, dog]
//        [rat, cat, dog]
//        [cat, dog, rat]
//        [rat, cat, dog]
//        {rat=Mickey, cat=Garfield, dog=Barry}
//        {cat=Garfield, dog=Barry, rat=Mickey}
//        {rat=Mickey, cat=Garfield, dog=Barry}
    }

    static Collection fill(Collection<String> collection){
        collection.add("rat");
        collection.add("cat");
        collection.add("dog");
        collection.add("dog");
        return collection;
    }
    static Map fill(Map<String,String> map){
        map.put("rat","Mickey");
        map.put("cat","Garfield");
        map.put("dog","Bart");
        map.put("dog","Barry");
        return map;
    }
}
