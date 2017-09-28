package chapter03operator;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/1/7.
 */
public class Literals {
    public static void main(String[] args) {
        int i1 = 0x2f;
        System.out.println("i1:"+Integer.toBinaryString(i1));
        System.out.println("i1:"+Integer.toString(i1));
        System.out.println(i1);
        int i2 = 0X2F;
        System.out.println("i2:"+Integer.toBinaryString(i2));
        System.out.println("i2:"+Integer.toString(i2));
        int i3 = 0177;
        System.out.println("i3:"+Integer.toBinaryString(i3));
        System.out.println("i3:"+Integer.toString(i3));
        char c = 0xffff;
        System.out.println("c:"+Integer.toBinaryString(c));
        System.out.println("c:"+Integer.toString(c));
        byte b = 0x7f;
        System.out.println("b:"+Integer.toBinaryString(b));
        System.out.println("b:"+Integer.toString(b));
        float i = 1.93e-43f;
        System.out.println(i);
        System.out.println(255|254);
    }
}
