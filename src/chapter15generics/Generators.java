package chapter15generics;

import java.util.ArrayList;
import java.util.Collection;

public class Generators {
    public static <T> Collection<T> fill(Collection<T> collection, Generator<T> generator, int n){
        for (int i = 0; i < n; i++) {
            collection.add(generator.next());
        }
        return collection;
    }

    public static void main(String[] args) {
        Collection<Coffe> coffes = fill(new ArrayList<Coffe>(), new CoffeGenerator(20), 20);
        System.out.println("coffes = " + coffes);

        Collection<Integer> integers = fill(new ArrayList<Integer>(), new Fibonacci(), 20);
        System.out.println("integers = " + integers);

//        coffes = [Cappuccino 0, Latte 1, Cappuccino 2, Americano 3, Americano 4, Mocha 5, Cappuccino 6, Latte 7, Breve 8, Breve 9, Cappuccino 10, Cappuccino 11, Americano 12, Mocha 13, Mocha 14, Cappuccino 15, Cappuccino 16, Americano 17, Latte 18, Cappuccino 19]
//        integers = [1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765]
    }
}
