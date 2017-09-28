package chapter03operator;

import java.util.Random;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/1/7.
 */
public class Bool {
    public static void main(String[] args) {
        Random random = new Random(47);
        int i = random.nextInt(100);
        int j = random.nextInt(100);
        System.out.println("i = "+i);
        System.out.println("j = "+j);
        System.out.println("i > j :"+(i > j));
        System.out.println("i < j :"+(i < j));
        System.out.println("i >= j :"+(i >= j));
        System.out.println("i < j :"+(i < j));
        System.out.println("i == j :"+(i == j));
        System.out.println("i != j :"+(i != j));
    }
}
