package chapter17containeradvanced;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/26
 * Mail:zhengjun1987@outlook.com
 */
class SetType {
    int i;

    public SetType(int i) {
        this.i = i;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof SetType && (i == ((SetType) obj).i);
    }

    @Override
    public String toString() {
        return ""+i+" "+hashCode();
    }
}

class HashedType extends SetType {
    public HashedType(int i) {
        super(i);
    }

    @Override
    public int hashCode() {
        return i;
    }
}

class ComparableTreeType extends SetType implements Comparable<ComparableTreeType>{
    public ComparableTreeType(int i) {
        super(i);
    }

    @Override
    public int compareTo(ComparableTreeType o) {
        return i < o.i ? -1 : (i == o.i ? 0 : 1);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

public class TypesForSets {
    static <T> Set<T> fill(Set<T> set,Class<T> type){
        try {
            for (int i = 0; i < 10; i++) {
                set.add(type.getConstructor(int.class).newInstance(i));
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return set;
    }

    static <T> void test(Set<T> set,Class<T> type){
        fill(set,type);
        fill(set,type);
        fill(set,type);
        System.out.println("set = " + set);
    }

    public static void main(String[] args) {
        test(new HashSet<HashedType>(), HashedType.class);
//        set = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        test(new LinkedHashSet<HashedType>(), HashedType.class);
//        set = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        test(new TreeSet<ComparableTreeType>(), ComparableTreeType.class);
//        set = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        test(new HashSet<HashedType>(), HashedType.class);
//        set = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        test(new HashSet<ComparableTreeType>(), ComparableTreeType.class);
//        set = [2, 1, 4, 3, 0, 9, 9, 3, 5, 6, 7, 7, 8, 5, 3, 6, 8, 0, 0, 8, 1, 2, 2, 1, 5, 7, 4, 9, 6, 4]
        test(new LinkedHashSet<HashedType>(), HashedType.class);
//        set = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        test(new LinkedHashSet<ComparableTreeType>(), ComparableTreeType.class);
//        set = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

        try {
            test(new TreeSet<SetType>(),SetType.class);
        } catch (Exception e) {
            System.out.println("e = " + e);
        }
//        e = java.lang.RuntimeException
        try {
            test(new TreeSet<HashedType>(), HashedType.class);
        } catch (Exception e) {
            System.out.println("e = " + e);
        }
//        e = java.lang.RuntimeException
    }

}
