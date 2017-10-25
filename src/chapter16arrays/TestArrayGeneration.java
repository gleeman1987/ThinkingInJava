package chapter16arrays;

import java.util.Arrays;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/25
 * Mail:zhengjun1987@outlook.com
 */
public class TestArrayGeneration {
    public static void main(String[] args) {
        int size = 7;
        boolean[] booleans = ConvertTo.primitive(Generated.array(Boolean.class, new RandomGenerator.Boolean(), size));
        System.out.println("booleans = " + Arrays.toString(booleans));
        byte[] bytes = ConvertTo.primitive(Generated.array(Byte.class, new RandomGenerator.Byte(), size));
        System.out.println("bytes = " + Arrays.toString(bytes));
        char[] chars = ConvertTo.primitive(Generated.array(Character.class, new RandomGenerator.Character(), size));
        System.out.println("chars = " + Arrays.toString(chars));
        short[] shorts = ConvertTo.primitive(Generated.array(Short.class, new RandomGenerator.Short(), size));
        System.out.println("shorts = " + Arrays.toString(shorts));
        int[] ints = ConvertTo.primitive(Generated.array(Integer.class, new RandomGenerator.Integer(), size));
        System.out.println("ints = " + Arrays.toString(ints));
        long[] longs = ConvertTo.primitive(Generated.array(Long.class, new RandomGenerator.Long(), size));
        System.out.println("longs = " + Arrays.toString(longs));
        float[] floats = ConvertTo.primitive(Generated.array(Float.class, new RandomGenerator.Float(), size));
        System.out.println("floats = " + Arrays.toString(floats));
        double[] doubles = ConvertTo.primitive(Generated.array(Double.class, new RandomGenerator.Double(), size));
        System.out.println("doubles = " + Arrays.toString(doubles));
//        booleans = [true, false, true, false, false, true, false]
//        bytes = [-79, -76, 126, 33, -64, -114, 123]
//        chars = [T, L, k, R, a, f, K]
//        shorts = [15161, -28466, -12603, 2001, -4017, -4619, 23487]
//        ints = [8410, 6342, 7674, 8804, 8950, 7826, 4322]
//        longs = [-1099465504, 39716067, 875665968, 1738084688, -914835675, 1169976606, 1947946283]
//        floats = [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]
//        doubles = [78.0, 51.0, 76.0, 90.0, 12.0, 97.0, 29.0]
    }
}
