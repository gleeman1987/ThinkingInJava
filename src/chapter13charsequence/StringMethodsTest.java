package chapter13charsequence;

import java.io.UnsupportedEncodingException;

public class StringMethodsTest {
    public static void main(String[] args) {
        String s = new String("最爱湖东行不足,绿杨阴里白沙堤");
        System.out.println(s.length());
        System.out.println(s.charAt(3));
        System.out.println(s.charAt(4));
        byte[] bytes = new byte[0];
        try {
            bytes = s.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(bytes+"  "+bytes.length);
        for (byte aByte : bytes) {
            System.out.print(aByte+" ");
        }
        System.out.println();
        for (byte aByte : bytes) {
            System.out.print((char)aByte+" ");
        }
        System.out.println();
        System.out.println(s.toCharArray());
        System.out.println(s.toCharArray().length);

        System.out.println(s.contains("爱"));
        System.out.println(s.startsWith("最爱"));
        System.out.println(s.endsWith("白沙堤"));

        System.out.println(s.intern());
        System.out.println("the day you went away".intern());
    }
}
