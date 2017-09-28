package chapter15generics;

public class Coffe {
    private static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName()+ " "+id;
    }
}

class Latte extends Coffe {}

class Mocha extends Coffe {}

class Cappuccino extends Coffe {}

class Americano extends Coffe {}

class Breve extends Coffe {}