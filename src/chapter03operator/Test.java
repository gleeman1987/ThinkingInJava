package chapter03operator;

import java.util.Random;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/17
 * Mail:zhengjun1987@outlook.com
 */
public class Test {
    public static void main(String[] args) {
        long seed = System.currentTimeMillis() % 79;
        int nextInt = new Random().nextInt(1024);
        System.out.println("seed : "+seed +"  result:"+nextInt);
    }
}
