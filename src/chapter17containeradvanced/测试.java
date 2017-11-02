package chapter17containeradvanced;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/27
 * Mail:zhengjun1987@outlook.com
 */
public class 测试 {
    public static void 测试(String[] args) {
        System.out.println("\"\".hashCode() = " + "".hashCode());
        System.out.println("\" \".hashCode() = " + " ".hashCode());
        System.out.println("\"中华人民共和国\".hashCode() = " + "中华人民共和国".hashCode());
        System.out.println("\"United State of America\".hashCode() = " + "United State of America".hashCode());
        System.out.println("Long.valueOf(System.currentTimeMillis()).hashCode() = " + Long.valueOf(System.currentTimeMillis()).hashCode());
    }

    public static void main(String[] args) {
        测试(null);
    }
}
