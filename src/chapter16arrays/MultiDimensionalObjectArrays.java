package chapter16arrays;

import java.util.Arrays;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/24
 * Mail:zhengjun1987@outlook.com
 */
public class MultiDimensionalObjectArrays {
    public static void main(String[] args) {
        BerylliumSphere[][] berylliumSpheres =
                {
                        {new BerylliumSphere(),new BerylliumSphere()},
                        {new BerylliumSphere(),new BerylliumSphere(),
                                new BerylliumSphere(),new BerylliumSphere()},
                        {new BerylliumSphere(),new BerylliumSphere(),
                                new BerylliumSphere(),new BerylliumSphere(),
                                new BerylliumSphere(),new BerylliumSphere(),
                                new BerylliumSphere(),new BerylliumSphere()},
                };
        System.out.println("Arrays.deepToString(berylliumSpheres) = " + Arrays.deepToString(berylliumSpheres));
//        Arrays.deepToString(berylliumSpheres) = [[BerylliumSphere 0, BerylliumSphere 1], [BerylliumSphere 2, BerylliumSphere 3, BerylliumSphere 4, BerylliumSphere 5], [BerylliumSphere 6, BerylliumSphere 7, BerylliumSphere 8, BerylliumSphere 9, BerylliumSphere 10, BerylliumSphere 11, BerylliumSphere 12, BerylliumSphere 13]]
    }
}
