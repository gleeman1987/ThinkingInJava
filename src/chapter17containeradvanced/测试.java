package chapter17containeradvanced;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/27
 * Mail:zhengjun1987@outlook.com
 */
public class 测试 {
    public static void 测试(String[] args) {
        for (int i = 0; i < 11; i++) {
            System.out.println("(3 << "+i+") = " + (3 << i));
        }
        System.out.println("------------------------------------");
        System.out.println("(1024 >>> 2) = " + (1024 >>> 2));
        System.out.println("------------------------------------");
        for (int i = 0; i < 6; i++) {
            System.out.println("(31 >>> "+i+") = " + (31 >>> i));
        }
        System.out.println("------------------------------------");
        for (int i = 0; i < 6; i++) {
            System.out.println("(31 >> "+i+") = " + (31 >> i));
        }
        System.out.println("------------------------------------");
        System.out.println("(16>>>1) = " + (16 >>> 1));
        System.out.println("(16>>>2) = " + (16 >>> 2));
        System.out.println("(16>>>3) = " + (16 >>> 3));
        System.out.println("(16>>>4) = " + (16 >>> 4));
        System.out.println("(16>>>5) = " + (16 >>> 5));
        System.out.println("\"\".hashCode() = " + "".hashCode());
        System.out.println("\" \".hashCode() = " + " ".hashCode());
        System.out.println("\"中华人民共和国\".hashCode() = " + "中华人民共和国".hashCode());
        System.out.println("\"United State of America\".hashCode() = " + "United State of America".hashCode());
        System.out.println("Long.valueOf(System.currentTimeMillis()).hashCode() = " + Long.valueOf(System.currentTimeMillis()).hashCode());
        System.out.println("Integer.toHexString(256*0.9) = " + Integer.toHexString((int) (256 * 0.9)));
    }

    public static void main(String[] args) {
        测试(null);
    }
}
