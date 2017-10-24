package chapter16arrays;

import java.util.Arrays;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/24
 * Mail:zhengjun1987@outlook.com
 */
public class ThreeDWithNew {
    public static void main(String[] args) {
        int[][][] ints = new int[2][2][4];
        System.out.println("Arrays.deepToString(ints) = " + Arrays.deepToString(ints));
//        Arrays.deepToString(ints) = [[[0, 0, 0, 0], [0, 0, 0, 0]], [[0, 0, 0, 0], [0, 0, 0, 0]]]
    }
}
