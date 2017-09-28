package chapter12exeception;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/9/16.
 */
public class ExeceptionThrow {
    public static void main(String[] args) throws Exception {
        String s = "testNull(s);";
        testNull(s);
        System.out.println("s = " + s);
    }

    private static void testNull(String s) throws Exception {
        boolean equals = "".equals(s);
        if (s == null || equals) {
            throw new Exception("Null String");
        }
        System.out.println("equals = " + equals);
    }
}
