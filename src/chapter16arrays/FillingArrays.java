package chapter16arrays;

import java.util.Arrays;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/24
 * Mail:zhengjun1987@outlook.com
 */
public class FillingArrays {
    public static void main(String[] args) {
        int size = 6;
        boolean[] booleans = new boolean[size];
        byte[] bytes = new byte[size];
        char[] chars = new char[size];
        short[] shorts = new short[size];
        int[] ints = new int[size];
        long[] longs = new long[size];
        float[] floats = new float[size];
        double[] doubles = new double[size];
        String[] strings = new String[6];
        Arrays.fill(booleans,true);
        System.out.println("booleans = " + Arrays.toString(booleans));
        Arrays.fill(bytes, (byte) 11);
        System.out.println("bytes = " + Arrays.toString(bytes));
        Arrays.fill(chars,'x');
        System.out.println("chars = " + Arrays.toString(chars));
        Arrays.fill(shorts, (short) 17);
        System.out.println("shorts = " + Arrays.toString(shorts));
        Arrays.fill(ints,19);
        System.out.println("ints = " + Arrays.toString(ints));
        Arrays.fill(longs,23);
        System.out.println("longs = " + Arrays.toString(longs));
        Arrays.fill(floats,29);
        System.out.println("floats = " + Arrays.toString(floats));
        Arrays.fill(doubles,31);
        System.out.println("doubles = " + Arrays.toString(doubles));
        Arrays.fill(strings,"Hello");
        System.out.println("strings = " + Arrays.toString(strings));
        Arrays.fill(strings,3,5,"World");
        System.out.println("strings = " + Arrays.toString(strings));
//        booleans = [true, true, true, true, true, true]
//        bytes = [11, 11, 11, 11, 11, 11]
//        chars = [x, x, x, x, x, x]
//        shorts = [17, 17, 17, 17, 17, 17]
//        ints = [19, 19, 19, 19, 19, 19]
//        longs = [23, 23, 23, 23, 23, 23]
//        floats = [29.0, 29.0, 29.0, 29.0, 29.0, 29.0]
//        doubles = [31.0, 31.0, 31.0, 31.0, 31.0, 31.0]
//        strings = [Hello, Hello, Hello, Hello, Hello, Hello]
//        strings = [Hello, Hello, Hello, World, World, Hello]
    }
}
