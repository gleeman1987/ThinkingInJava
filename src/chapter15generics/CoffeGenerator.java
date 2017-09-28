package chapter15generics;

import java.util.Iterator;
import java.util.Random;

public class CoffeGenerator implements Generator<Coffe>,Iterable<Coffe> {
    private static Random random = new Random(47);
    private Class[] types = {Latte.class,Americano.class,Breve.class,Cappuccino.class,Mocha.class};
    private int size;

    public CoffeGenerator(int size) {
        this.size = size;
    }

    @Override
    public Coffe next() {
        try {
            return (Coffe) types[random.nextInt(types.length)].newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Iterator<Coffe> iterator() {
        return new Iterator<Coffe>() {
            int count = size;
            @Override
            public boolean hasNext() {
                return count > 0;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override
            public Coffe next() {
                count -- ;
                    return CoffeGenerator.this.next();
            }
        };
    }

    public static void main(String[] args) {
        CoffeGenerator coffes = new CoffeGenerator(5);
        for (int i = 0; i < 7; i++) {
            System.out.println(coffes.next());
        }

        for (Coffe coffe : new CoffeGenerator(10)) {
            System.out.println(coffe);
        }
    }
}
