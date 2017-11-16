package chapter03operator;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/16
 * Mail:zhengjun1987@outlook.com
 */
public class Precedence {
    public static void main(String[] args) {
        int x =1,y=2,z=3;
        System.out.println("(x + y - 2/2 +z) = " + (x + y - 2 / 2 + z));
        System.out.println("(x + (y - 2)/(2 + z)) = " + (x + (y - 2) / (2 + z)));
//        (x + y - 2/2 +z) = 5
//        (x + (y - 2)/(2 + z)) = 1
    }
}
