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
//        i = 58
        System.out.println("j = "+j);
//        j = 55
        System.out.println("i > j :"+(i > j));
//        i > j :true
        System.out.println("i < j :"+(i < j));
//        i < j :false
        System.out.println("i >= j :"+(i >= j));
//        i >= j :true
        System.out.println("i <= j :"+(i <= j));
//        i <= j :false
        System.out.println("i == j :"+(i == j));
//        i == j :false
        System.out.println("i != j :"+(i != j));
//        i != j :true
    }
}
