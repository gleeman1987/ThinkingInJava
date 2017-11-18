package chapter03operator;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/17
 * Mail:zhengjun1987@outlook.com
 */
public class Equivalence {
    public static void main(String[] args) {
        Integer integer1 = new Integer(47);
        Integer integer2  = new Integer(47);
        System.out.println("(integer1.equals(integer2)) = " + (integer1.equals(integer2)));
//        (integer1.equals(integer2)) = true
        System.out.println("(integer1 == integer2) = " + (integer1 == integer2));
//        (integer1 == integer2) = false
        System.out.println("(integer1 != integer2) = " + (integer1 != integer2));
//        (integer1 != integer2) = true

    }
}
