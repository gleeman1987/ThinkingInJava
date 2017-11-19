package chapter03operator;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/19
 * Mail:zhengjun1987@outlook.com
 */
public class RoundingNumbers {
    public static void main(String[] args) {
        double above = 0.7,below = 0.4;
        float fabove = 0.7f,fbelow = 0.4f;
        System.out.println("Math.round(above) = " + Math.round(above));
        System.out.println("Math.round(below) = " + Math.round(below));
        System.out.println("Math.round(fabove) = " + Math.round(fabove));
        System.out.println("Math.round(fbelow) = " + Math.round(fbelow));
//        Math.round(above) = 1
//        Math.round(below) = 0
//        Math.round(fabove) = 1
//        Math.round(fbelow) = 0
    }
}
