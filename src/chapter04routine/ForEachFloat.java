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

        long start2 = System.currentTimeMillis();
        for (int i = 0; i < floats.length; i++) {
            System.out.print(floats[i]+" ");
        }
        System.out.println();
        long end2 = System.currentTimeMillis();
        System.out.println("所耗时间为"+(end2 - start2));

        long start1 = System.currentTimeMillis();
        for (float aFloat : floats) {
            System.out.print(aFloat+" ");
        }
        System.out.println();
        long end1 = System.currentTimeMillis();
        System.out.println("所耗时间为"+(end1 - start1));
    }
}
