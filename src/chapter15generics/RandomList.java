package chapter15generics;

import java.util.ArrayList;
import java.util.Random;

public class RandomList<T> {
    private int seed;
    private ArrayList<T> storage = new ArrayList<>();
    private Random random;

    public RandomList(int seed) {
        this.seed = seed;
        random = new Random(seed);
    }

    public void add(T t){
        storage.add(t);
    }

    public T getItem(){
        return storage.get(random.nextInt(storage.size()));
    }

    public static void main(String[] args) {
        RandomList<String> stringRandomList = new RandomList<>(47);
        for (String s : "The quick brown fox jumps over the lazy brown dog".split(" ")) {
            stringRandomList.add(s);
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(stringRandomList.getItem()+" ");
        }
//        brown over fox quick quick dog brown The brown lazy
    }
}
