package chapter16arrays;

import java.util.Arrays;
import java.util.Random;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/24
 * Mail:zhengjun1987@outlook.com
 */
public class IceCream {
    private static Random random = new Random(47);
    static final String[] flavours = {"Chocolate", "Strawberry", "Vanilla", "Mint", "Mocha", "Rum", "Praline Cream", "Mud Pie"};

    public static String[] flavourSet(int n) throws Exception {
        if (n > flavours.length) {
            throw new Exception("Set size too big!");
        }
        String[] result = new String[n];
        boolean[] booleans = new boolean[flavours.length];
        for (int i = 0; i < n; i++) {
            int t;
            do {
                t = random.nextInt(flavours.length);
            } while (booleans[t]);
            result[i] = flavours[t];
            booleans[t] = true;
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 7; i++) {
            System.out.println(Arrays.toString(flavourSet(3)));
        }
//[Rum, Mint, Mocha]
//[Chocolate, Strawberry, Mocha]
//[Strawberry, Mint, Mocha]
//[Rum, Vanilla, Mud Pie]
//[Vanilla, Chocolate, Mocha]
//[Praline Cream, Strawberry, Mocha]
//[Mocha, Strawberry, Mint]
    }
}
