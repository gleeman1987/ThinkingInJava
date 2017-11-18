package chapter03operator;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/1/7.
 */
public class AutoIncrement {
    public static void main(String[] args) {
        int i = 1;
        System.out.println("i = " + i);
        System.out.println("++i = " + ++i);
        System.out.println("i++ = " + i++);
        System.out.println("i = " + i);
//        i = 1
//        ++i = 2
//        i++ = 2
//        i = 3
        System.out.println("--i = " + --i);
        System.out.println("i-- = " + i--);
        System.out.println("i = " + i);
//        --i = 2
//        i-- = 2
//        i = 1
    }
}
