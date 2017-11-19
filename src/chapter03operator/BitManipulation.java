package chapter03operator;

import java.util.Random;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/17
 * Mail:zhengjun1987@outlook.com
 */
public class BitManipulation {
    public static void main(String[] args) {
        Random random = new Random(47);
        int i = random.nextInt(),j = random.nextInt();

        printBinaryString("-1",-1);
        printBinaryString("+1",+1);
//        -1  int:-1 binary:11111111111111111111111111111111
//                +1  int:1 binary:1

            printBinaryString("i",i);
            printBinaryString("j",j);

        System.out.println();
        System.out.println();

        System.out.println("Integer.toBinaryString(Integer.MIN_VALUE) = \n" + Integer.toBinaryString(Integer.MIN_VALUE));
        System.out.println("Integer.toBinaryString(0) = \n" + Integer.toBinaryString(Integer.MAX_VALUE));
    }

    private static void printBinaryString(String s, int i) {
        System.out.println(s + " int:"+i+" binary:"+Integer.toBinaryString(i));
    }
}
