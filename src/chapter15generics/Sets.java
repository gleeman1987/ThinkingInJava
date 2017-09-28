package chapter15generics;

import java.util.HashSet;
import java.util.Set;

public class Sets {
    public static <T> Set<T> union(Set<T> a,Set<T> b){
        HashSet<T> ts = new HashSet<>(a);
        ts.addAll(b);
        return ts;
    }

    public static <T> Set<T> intersection(Set<T> a,Set<T> b){
        HashSet<T> ts = new HashSet<>(a);
        ts.retainAll(b);
        return ts;
    }

    public static <T> Set<T> difference(Set<T> a,Set<T> b){
        HashSet<T> ts = new HashSet<>(a);
        ts.removeAll(b);
        return ts;
    }

    public static <T> Set<T> complement(Set<T> a,Set<T> b){
        return difference(union(a,b),difference(a,b));
    }
}
