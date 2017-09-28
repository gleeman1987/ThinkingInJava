package chapter09interface;

import java.util.Random;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/6/28.
 */
public class TestRanvals {
    public static void main(String[] args) {
        System.out.println(RandVals.RANDOM_INT);
        System.out.println(RandVals.RANDOM_LONG);
        System.out.println(RandVals.RANDOM_FLOAT);
        System.out.println(RandVals.RANDOM_DOUBLE);
    }
}

interface RandVals{
    Random RANDOM = new Random(47);
    int RANDOM_INT = RANDOM.nextInt(10);
    long RANDOM_LONG = RANDOM.nextLong()*10;
    float RANDOM_FLOAT = RANDOM.nextFloat();
    double RANDOM_DOUBLE = RANDOM.nextDouble()*10;
}