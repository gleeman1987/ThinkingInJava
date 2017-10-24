package chapter16arrays;

import java.util.Arrays;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/24
 * Mail:zhengjun1987@outlook.com
 */
public class MultiDimensionalWrapperArray {
    public static void main(String[] args) {
        Integer[][] a = {{1,2,3},{4,5,6}};
        Double[][] b = {{1.1,2.2},{3.3,4.4},{5.5,6.6},{7.7,8.8},{9.9,1.2},{2.3,3.4}};
        String[][] c = {{"The","Quick","Sly","Fox"},{"Jumps","Over"},{"The","Lazy","Brown","Dog","and","Friend"}};
        System.out.println("Arrays.deepToString(a) = " + Arrays.deepToString(a));
        System.out.println("Arrays.deepToString(b) = " + Arrays.deepToString(b));
        System.out.println("Arrays.deepToString(c) = " + Arrays.deepToString(c));
//        Arrays.deepToString(a) = [[1, 2, 3], [4, 5, 6]]
//        Arrays.deepToString(b) = [[1.1, 2.2], [3.3, 4.4], [5.5, 6.6], [7.7, 8.8], [9.9, 1.2], [2.3, 3.4]]
//        Arrays.deepToString(c) = [[The, Quick, Sly, Fox], [Jumps, Over], [The, Lazy, Brown, Dog, and, Friend]]
    }
}
