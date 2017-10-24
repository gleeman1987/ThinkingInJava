package chapter16arrays;

import java.util.Arrays;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/24
 * Mail:zhengjun1987@outlook.com
 */
public class AssemblingMultidimensionalArrays {
    public static void main(String[] args) {
        Integer[][] integers = new Integer[3][];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = new Integer[3];
            for (int i1 = 0; i1 < integers[i].length; i1++) {
                integers[i][i1] = i*i1;
            }
        }
        System.out.println("Arrays.deepToString(integers) = " + Arrays.deepToString(integers));
//        Arrays.deepToString(integers) = [[0, 0, 0], [0, 1, 2], [0, 2, 4]]
    }
}
