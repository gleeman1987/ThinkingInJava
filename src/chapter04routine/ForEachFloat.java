package chapter04routine;

import java.util.Random;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/1/8.
 */
public class ForEachFloat {
    public static void main(String[] args) {
        Random random = new Random(47);
        float[] floats = new float[10];
        for (int i = 0; i < 10; i++) {
            floats[i] = random.nextFloat();
        }

        long start2 = System.nanoTime();
        for (int i = 0; i < floats.length; i++) {
            System.out.print(floats[i]+" ");
        }
        System.out.println();
        long end2 = System.nanoTime();
        System.out.println("所耗时间为"+(end2 - start2));
//        0.72711575 0.39982635 0.5309454 0.0534122 0.16020656 0.57799757 0.18847865 0.4170137 0.51660204 0.73734957
//        所耗时间为4865016

        long start1 = System.nanoTime();
        for (float aFloat : floats) {
            System.out.print(aFloat+" ");
        }
        System.out.println();
        long end1 = System.nanoTime();
        System.out.println("所耗时间为"+(end1 - start1));
//        0.72711575 0.39982635 0.5309454 0.0534122 0.16020656 0.57799757 0.18847865 0.4170137 0.51660204 0.73734957
//        所耗时间为387313
    }
}
