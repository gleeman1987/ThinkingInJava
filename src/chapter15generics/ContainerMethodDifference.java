package chapter15generics;

import java.lang.reflect.Method;
import java.util.*;

public class ContainerMethodDifference {
    static Set<String> object = methodSet(Object.class);
    static {
        object.add("clone");
    }
    static Set<String> methodSet(Class<?> type){
        TreeSet<String> strings = new TreeSet<>();
        for (Method method : type.getMethods()) {
            strings.add(method.getName());
        }
        return strings;
    }

    static void interfaces(Class<?> type){
        ArrayList<String> strings = new ArrayList<>();
        for (Class<?> aClass : type.getInterfaces()) {
            strings.add(aClass.getCanonicalName());
        }
        System.out.println("strings = " + strings);
    }

    static void difference(Class<?> superset,Class<?> subset){
        System.out.println("superset = [" + superset.getSimpleName() + "] EXTENDS subset = [" + subset.getSimpleName() + "] , ADDS:");
        Set<String> difference = Sets.difference(methodSet(superset), methodSet(subset));
        difference.removeAll(object);
        System.out.println(difference);
        System.out.println("------------------------------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("methodSet(Collection.class) = " + methodSet(Collection.class));
        interfaces(Collection.class);
        difference(Set.class,Collection.class);
        difference(HashSet.class,Set.class);
        difference(LinkedHashSet.class,HashSet.class);
        difference(LinkedList.class,List.class);
        difference(ArrayList.class,List.class);
        difference(HashMap.class,Map.class);
        difference(TreeMap.class,Map.class);
    }
}
