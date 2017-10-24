package chapter16arrays;

import java.util.Arrays;
import java.util.Random;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/24
 * Mail:zhengjun1987@outlook.com
 */
public class RaggedArray {
    public static void main(String[] args) {
        Random random = new Random(47);
        int[][][] ints = new int[random.nextInt(7)][][];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = new int[random.nextInt(5)][];
            for (int i1 = 0; i1 < ints[i].length; i1++) {
                ints[i][i1] = new int[random.nextInt(6)];
            }
        }
        System.out.println("Arrays.deepToString(ints) = " + Arrays.deepToString(ints));
//        Arrays.deepToString(ints) = [[], [[0, 0, 0, 0, 0], [0], [0, 0, 0, 0, 0]], [[0, 0], [], [0]], [[], [0, 0, 0], [0]], [[0, 0, 0, 0], [0, 0, 0, 0], [0], [0, 0]], [[0, 0, 0, 0], [], [0]]]
    }
}
