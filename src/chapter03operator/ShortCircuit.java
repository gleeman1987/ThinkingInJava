package chapter03operator;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/17
 * Mail:zhengjun1987@outlook.com
 */
public class ShortCircuit {
    static boolean test1(int val){
        System.out.println("ShortCircuit.test1 val = [" + val + "]");
        System.out.println("result = "+(val < 1));
        return val < 1;
    }
    static boolean test2(int val){
        System.out.println("ShortCircuit.test2 val = [" + val + "]");
        System.out.println("result = "+(val < 2));
        return val < 2;
    }
    static boolean test3(int val){
        System.out.println("ShortCircuit.test3 val = [" + val + "]");
        System.out.println("result = "+(val < 3));
        return val < 3;
    }

    public static void main(String[] args) {
        System.out.println("(test1(0) && test2(2) && test3(2)) = " + (test1(0) && test2(2) && test3(2)));
//        ShortCircuit.test1 val = [0]
//        result = true
//        ShortCircuit.test2 val = [2]
//        result = false
//        (test1(0) && test2(2) && test3(2)) = false
    }
}
