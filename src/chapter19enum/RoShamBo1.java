package chapter19enum;

import java.util.Random;

/**
 * Authur:zhengjun
 * E-mail:zhengjun1987@outlook.com
 * Date:2017/12/3
 * Project:ThinkingInJava
 */
interface Item {
    Outcome compete(Item item);
    Outcome eval(Rock rock);
    Outcome eval(Scissors scissors);
    Outcome eval(Paper paper);
}

class Paper implements Item {
    @Override
    public Outcome compete(Item item) {
        return item.eval(this);
    }

    @Override
    public Outcome eval(Rock rock) {
        return Outcome.LOSE;
    }

    @Override
    public Outcome eval(Scissors scissors) {
        return Outcome.WIN;
    }

    @Override
    public Outcome eval(Paper paper) {
        return Outcome.DRAW;
    }

    @Override
    public String toString() {
        return "Paper";
    }
}
class Rock implements Item {
    @Override
    public String toString() {
        return "Rock";
    }

    @Override
    public Outcome compete(Item item) {
        return item.eval(this);
    }

    @Override
    public Outcome eval(Rock rock) {
        return Outcome.DRAW;
    }

    @Override
    public Outcome eval(Scissors scissors) {
        return Outcome.LOSE;
    }

    @Override
    public Outcome eval(Paper paper) {
        return Outcome.WIN;
    }
}
class Scissors implements Item {
    @Override
    public String toString() {
        return "Scissors";
    }

    @Override
    public Outcome compete(Item item) {
        return item.eval(this);
    }

    @Override
    public Outcome eval(Rock rock) {
        return Outcome.WIN;
    }

    @Override
    public Outcome eval(Scissors scissors) {
        return Outcome.DRAW;
    }

    @Override
    public Outcome eval(Paper paper) {
        return Outcome.LOSE;
    }
}
public class RoShamBo1 {
    private static Random random = new Random(47);
    private static Item[] items = new Item[]{new Scissors(),new Rock(),new Paper()};
    public static final int SIZE = 20;
    public static Item newItem(){
        return items[random.nextInt(3)];
    }

    public static void match(Item a,Item b) {
        System.out.println("RoShamBo1.match  " + "a = [" + a + "], b = [" + b + "]   outcome:"+a.compete(b));
    }

    public static void main(String[] args) {
        for (int i = 0; i < SIZE; i++) {
            match(newItem(),newItem());
        }
//        RoShamBo1.match  a = [Paper], b = [Paper]   outcome:DRAW
//        RoShamBo1.match  a = [Rock], b = [Paper]   outcome:LOSE
//        RoShamBo1.match  a = [Rock], b = [Paper]   outcome:LOSE
//        RoShamBo1.match  a = [Rock], b = [Paper]   outcome:LOSE
//        RoShamBo1.match  a = [Scissors], b = [Rock]   outcome:LOSE
//        RoShamBo1.match  a = [Scissors], b = [Scissors]   outcome:DRAW
//        RoShamBo1.match  a = [Scissors], b = [Rock]   outcome:LOSE
//        RoShamBo1.match  a = [Paper], b = [Rock]   outcome:WIN
//        RoShamBo1.match  a = [Rock], b = [Rock]   outcome:DRAW
//        RoShamBo1.match  a = [Paper], b = [Rock]   outcome:WIN
//        RoShamBo1.match  a = [Rock], b = [Scissors]   outcome:WIN
//        RoShamBo1.match  a = [Rock], b = [Scissors]   outcome:WIN
//        RoShamBo1.match  a = [Paper], b = [Scissors]   outcome:LOSE
//        RoShamBo1.match  a = [Paper], b = [Rock]   outcome:WIN
//        RoShamBo1.match  a = [Rock], b = [Paper]   outcome:LOSE
//        RoShamBo1.match  a = [Scissors], b = [Rock]   outcome:LOSE
//        RoShamBo1.match  a = [Rock], b = [Scissors]   outcome:WIN
//        RoShamBo1.match  a = [Rock], b = [Scissors]   outcome:WIN
//        RoShamBo1.match  a = [Rock], b = [Scissors]   outcome:WIN
//        RoShamBo1.match  a = [Rock], b = [Scissors]   outcome:WIN
    }
}
