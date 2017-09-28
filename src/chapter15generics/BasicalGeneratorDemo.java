package chapter15generics;

import java.util.Collection;

public class BasicalGeneratorDemo {
    public static void main(String[] args) {
        Collection<CountedObject> countedObjects = Generators.fill(New.list(), BasicalGenerator.create(CountedObject.class), 5);
        System.out.println("countedObjects = " + countedObjects);//countedObjects = [CountedObject  0, CountedObject  1, CountedObject  2, CountedObject  3, CountedObject  4]
    }
}
