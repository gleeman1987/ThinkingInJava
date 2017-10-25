package chapter17containeradvanced;

import chapter15generics.Generator;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/25
 * Mail:zhengjun1987@outlook.com
 */
public class CollectionData<T> extends ArrayList<T> {
    public CollectionData(Generator<T> generator,int quantity) {
        for (int i = 0; i < quantity; i++) {
            add(generator.next());
        }
    }

    public static <E> CollectionData<E> list(Generator<E> generator,int quantity){
        return new CollectionData<>(generator,quantity);
    }

    public static class Government implements Generator<String>{
        String[] foundation = ("strange woman lying in ponds " + "distributing swords is no basis for a system of government").split(" ");
        private int index;
        @Override
        public String next() {
            return foundation[index++];
        }
    }

    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>(new CollectionData<>(new Government(),15));
        System.out.println("set = " + set);
//        set = [strange, woman, lying, in, ponds, distributing, swords, is, no, basis, for, a, system, of, government]
        set.addAll(CollectionData.list(new Government(),15));
        System.out.println("set = " + set);
//        set = [strange, woman, lying, in, ponds, distributing, swords, is, no, basis, for, a, system, of, government]
    }
}
