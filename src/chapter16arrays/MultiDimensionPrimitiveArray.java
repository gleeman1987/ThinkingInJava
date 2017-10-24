package chapter16arrays;

import java.util.Arrays;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/24
 * Mail:zhengjun1987@outlook.com
 */
public class MultiDimensionPrimitiveArray {
    public static void main(String[] args) {
        int[][] a = {{1,2,3},{4,5}};
        System.out.println("Arrays.toString(a) = " + Arrays.toString(a));
//        Arrays.toString(a) = [[I@4554617c, [I@74a14482]
        for (int i = 0; i < a.length; i++) {
            System.out.println("a[i] = " + Arrays.toString(a[i]));
        }
//        a[i] = [1, 2, 3]
//        a[i] = [4, 5]
        System.out.println("Arrays.deepToString(a) = " + Arrays.deepToString(a));
//        Arrays.deepToString(a) = [[1, 2, 3], [4, 5]]
    }
}
