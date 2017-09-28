package chapter13charsequence;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDisplay {
    public static void main(String[] args) {
        ArrayList<Coffe> coffes = new ArrayList<>();
        CoffeGenerator coffeGenerator = new CoffeGenerator();
        for (Coffe coffe : coffeGenerator.CoffeGenerator()) {
            coffes.add(coffe);
        }
        System.out.println(coffes);//[Americano 1, Latte 2, Americano 3, Mocha 4, Mocha 5, Breve 6, Americano 7, Latte 8, Cappuccino 9, Cappuccino 10]
    }
}

class Coffe {
    private static int count;
    private int id;

    Coffe() {
        id = count++;
    }
    @Override
    public String toString() {
        return getClass().getSimpleName()+" "+id;
    }
}

class Americano extends Coffe {
    @Override
    public String toString() {
        return super.toString();
    }
}

class Latte extends Coffe {
}

class Mocha extends Coffe {
}

class Breve extends Coffe {
}

class Cappuccino extends Coffe {
}

class CoffeGenerator {
    public List<Coffe> CoffeGenerator() {
        ArrayList<Coffe> coffes = new ArrayList<>();
        coffes.add(new Americano());
        coffes.add(new Latte());
        coffes.add(new Americano());
        coffes.add(new Mocha());
        coffes.add(new Mocha());
        coffes.add(new Breve());
        coffes.add(new Americano());
        coffes.add(new Latte());
        coffes.add(new Cappuccino());
        coffes.add(new Cappuccino());
        return coffes;
    }
}
