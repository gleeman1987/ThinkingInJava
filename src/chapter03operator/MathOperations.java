package chapter03operator;

import java.util.Random;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/1/7.
 */
public class MathOperations {
    public static void main(String[] args) {
        Random random = new Random(47);
        int i,j,k;
        j = random.nextInt(100) +1;
        System.out.println("j = " + j);
        k = random.nextInt(100) + 1;
        System.out.println("k = " + k);
        System.out.println("(j + k) = " + (j + k));
        System.out.println("(j += k) = " + (j += k));
        j = 59;
        k = 56;
        System.out.println("(j - k) = " + (j - k));
        System.out.println("(j -= k) = " + (j -= k));
        j = 59;
        k = 56;
        System.out.println("(j / k) = " + (j / k));
        System.out.println("(j /= k) = " + (j /= k));
        j = 59;
        k = 56;
        System.out.println("(j * k) = " + (j * k));
        System.out.println("(j *= k) = " + (j *= k));
        j = 59;
        k = 56;
        System.out.println("(j % k) = " + (j % k));
        System.out.println("(j %= k) = " + (j %= k));
//        j = 59
//        k = 56
//        (j + k) = 115
//        (j += k) = 115
//        (j - k) = 3
//        (j -= k) = 3
//        (j / k) = 1
//        (j /= k) = 1
//        (j * k) = 3304
//        (j *= k) = 3304
//        (j % k) = 3
//        (j %= k) = 3

        float u, v,w;
        v = random.nextFloat();
        System.out.println("v = " + v);
        w = random.nextFloat();
        System.out.println("w = " + w);
        System.out.println("(v+w) = " + (v + w));
        System.out.println("(v+=w) = " + (v += w));
        v = 0.5309454f;
        w = 0.0534122f;
        System.out.println("(v-w) = " + (v - w));
        System.out.println("(v-=w) = " + (v -= w));
        v = 0.5309454f;
        w = 0.0534122f;
        System.out.println("(v*w) = " + (v * w));
        System.out.println("(v*=w) = " + (v *= w));
        v = 0.5309454f;
        w = 0.0534122f;
        System.out.println("(v/w) = " + (v / w));
        System.out.println("(v/=w) = " + (v /= w));
        v = 0.5309454f;
        w = 0.0534122f;
        System.out.println("(v%w) = " + (v % w));
        System.out.println("(v %= w) = " + (v %= w));
//        v = 0.5309454
//        w = 0.0534122
//        (v+w) = 0.5843576
//        (v+=w) = 0.5843576
//        (v-w) = 0.47753322
//        (v-=w) = 0.47753322
//        (v*w) = 0.028358962
//        (v*=w) = 0.028358962
//        (v/w) = 9.940527
//        (v/=w) = 9.940527
//        (v%w) = 0.05023563
//        (v %= w) = 0.05023563

    }
}
