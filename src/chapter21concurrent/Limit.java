package chapter21concurrent;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/12/7
 * Mail:zhengjun1987@outlook.com
 */
public class Limit {
    public static void main(String[] args) {
        for (double i = 1; i < 9999+1; i++) {
            double d = 1.0;
            for (int j = 0; j < i; j++) {
                double d1 = (double) (1 + (1 / i));
                d *= d1;
            }
            print(i,d);
        }
    }

    private static void print(double i, double d) {
        System.out.println("i = [" + i + "], d = [" + d + "]");
    }
}
