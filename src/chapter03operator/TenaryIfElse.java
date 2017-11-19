package chapter03operator;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/19
 * Mail:zhengjun1987@outlook.com
 */
public class TenaryIfElse {
    static int tenary(int i){
        return i <10?i*100:i*10;
    }

    static int standard(int i){
        if (i <10){
            return i*100;
        } else {
            return  i*10;
        }
    }

    public static void main(String[] args) {
        System.out.println("tenary(9) = " + tenary(9));
        System.out.println("standard(9) = " + standard(9));
        System.out.println("tenary(10) = " + tenary(10));
        System.out.println("standard(10) = " + standard(10));
    }
}
