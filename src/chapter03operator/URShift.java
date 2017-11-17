package chapter03operator;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/17
 * Mail:zhengjun1987@outlook.com
 */
public class URShift {
    public static void main(String[] args) {
        System.out.println("Integer.toBinaryString(-1) = \n" + Integer.toBinaryString(-1));
        System.out.println("(Integer.toBinaryString(-1>>>10)) = \n" + (Integer.toBinaryString(-1 >>> 10)));
        System.out.println();
        System.out.println("Long.toBinaryString(-1) = \n" + Long.toBinaryString(-1));
        System.out.println("Long.toBinaryString(-1 >>> 10) = \n" + Long.toBinaryString(-1L >>> 10));
        System.out.println();
        short s = -1;
        System.out.println(Integer.toBinaryString(s >>> 10));
    }
}
