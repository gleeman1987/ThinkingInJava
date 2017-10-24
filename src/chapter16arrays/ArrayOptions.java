package chapter16arrays;

import java.util.Arrays;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/24
 * Mail:zhengjun1987@outlook.com
 */
public class ArrayOptions {
    public static void main(String[] args) {
        BerylliumSphere[] a;
        BerylliumSphere[] b = new BerylliumSphere[5];
        for (int i = 0; i < 6; i++) {
//            b[i] = new BerylliumSphere();
//            Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 5
//            at chapter16arrays.ArrayOptions.main(ArrayOptions.java:14)
        }
        System.out.println("b.length = " + b.length);
        System.out.println("Arrays.toString(b) = " + Arrays.toString(b));
//        b.length = 5
//        Arrays.toString(b) = [null, null, null, null, null]

        BerylliumSphere[] c = new BerylliumSphere[4];
        for (int i = 0; i < c.length; i++) {
            if (c[i] == null) {
                c[i] = new BerylliumSphere();
            }
        }

        BerylliumSphere[] d = {new BerylliumSphere(),new BerylliumSphere(),new BerylliumSphere(),new BerylliumSphere()};
        a = new BerylliumSphere[]{new BerylliumSphere(),new BerylliumSphere()};
        System.out.println("a.length = " + a.length);
        System.out.println("b.length = " + b.length);
        System.out.println("c.length = " + c.length);
        System.out.println("d.length = " + d.length);
//        a.length = 2
//        b.length = 5
//        c.length = 4
//        d.length = 4
        a = d;
        System.out.println("a.length = " + a.length);
//        a.length = 4

        int[] e;
        int[] f = new int[5];
        System.out.println("f = " + Arrays.toString(f));
//        f = [0, 0, 0, 0, 0]
        int[] g = new int[4];
        for (int i = 0; i < g.length; i++) {
            g[i] = i*i;
        }
        int[] h = {11,47,93};
        System.out.println("f.length = " + f.length);
        System.out.println("g.length = " + g.length);
        System.out.println("h.length = " + h.length);
//        f.length = 5
//        g.length = 4
//        h.length = 3
        e = h;
        System.out.println("e.length = " + e.length);
//        e.length = 3
        e = new int[]{1,2};
        System.out.println("e.length = " + e.length);
//        e.length = 2
    }
}
