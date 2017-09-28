package chapter03operator;

import java.util.Random;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/1/7.
 */
public class MathOperations {
    public static void main(String[] args) {
        float i,j,k;
        j = new Random().nextFloat();
        k = new Random().nextFloat();
        System.out.println("j = "+j);
        System.out.println("k = "+k);
        i = j + k;
        say(i,j,k,"j+k");
        i = j - k;
        say(i,j,k,"j-k");
        i = j * k;
        say(i,j,k,"j*k");
        i = j / k;
        say(i,j,k,"j/k");
        i = j % k;
        say(i,j,k,"j%k");
    }

    private static void say(float i, float j, float k, String s) {
        System.out.println(s +" = "+i);
    }
}
