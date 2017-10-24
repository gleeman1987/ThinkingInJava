package chapter16arrays;

import java.util.Arrays;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/24
 * Mail:zhengjun1987@outlook.com
 */
public class AutoBoxingArrays {
    public static void main(String[] args) {
        Integer[][] a = {
                {0,1,2,3,4,5,6,7,8,9},
                {30,21,32,23,24,25,26,27,28,29},
                {60,51,52,53,54,55,56,57,58,59},
                {70,71,72,73,74,75,76,77,78,79},
        };
        System.out.println("Arrays.deepToString(a) = " + Arrays.deepToString(a));
//        Arrays.deepToString(a) = [[0, 1, 2, 3, 4, 5, 6, 7, 8, 9], [30, 21, 32, 23, 24, 25, 26, 27, 28, 29], [60, 51, 52, 53, 54, 55, 56, 57, 58, 59], [70, 71, 72, 73, 74, 75, 76, 77, 78, 79]]
    }
}
