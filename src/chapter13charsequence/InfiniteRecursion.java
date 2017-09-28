package chapter13charsequence;

import java.util.ArrayList;

public class InfiniteRecursion {
    @Override
    public String toString() {
        return "InfiniteRecursion address:"+this;//this.toString()导致无限循环引用
//        Exception in thread "main" java.lang.StackOverflowError
//        at java.lang.AbstractStringBuilder.ensureCapacityInternal(AbstractStringBuilder.java:125)
//        at java.lang.AbstractStringBuilder.append(AbstractStringBuilder.java:448)
//        at java.lang.StringBuilder.append(StringBuilder.java:136)
//        at chapter13charsequence.InfiniteRecursion.toString(InfiniteRecursion.java:8)
//        at java.lang.String.valueOf(String.java:2994)
//        at java.lang.StringBuilder.append(StringBuilder.java:131)
//        at chapter13charsequence.InfiniteRecursion.toString(InfiniteRecursion.java:8)
    }

    public static void main(String[] args) {
        ArrayList<InfiniteRecursion> infiniteRecursions = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            infiniteRecursions.add(new InfiniteRecursion());
        }
        System.out.println(infiniteRecursions);
    }
}
