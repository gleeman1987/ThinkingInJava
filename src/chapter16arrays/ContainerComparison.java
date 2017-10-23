package chapter16arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/23
 * Mail:zhengjun1987@outlook.com
 */
class BerylliumSphere {
    private static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " +id;
    }
}

public class ContainerComparison {
    public static void main(String[] args) {
        BerylliumSphere[] berylliumSpheres = new BerylliumSphere[10];
        for (int i = 0; i < 5; i++) {
            berylliumSpheres[i] = new BerylliumSphere();
        }
        System.out.println(Arrays.toString(berylliumSpheres));
        System.out.println("berylliumSpheres[4] = " + berylliumSpheres[4]);
//        [BerylliumSphere 0, BerylliumSphere 1, BerylliumSphere 2, BerylliumSphere 3, BerylliumSphere 4, null, null, null, null, null]
//        berylliumSpheres[4] = BerylliumSphere 4
        ArrayList<BerylliumSphere> sphereArrayList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            sphereArrayList.add(new BerylliumSphere());
        }
        System.out.println(sphereArrayList);
        System.out.println(sphereArrayList.get(4));
//        [BerylliumSphere 5, BerylliumSphere 6, BerylliumSphere 7, BerylliumSphere 8, BerylliumSphere 9]
//        BerylliumSphere 9

        int[] ints = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(ints));
        System.out.println(ints[4]);
//        [1, 2, 3, 4, 5]
//        5

        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        integers.add(97);
        System.out.println(integers);
        System.out.println(integers.get(4));
//        [1, 2, 3, 4, 5, 97]
//        5
    }
}
