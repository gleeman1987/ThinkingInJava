package chapter03operator;

import chapter21concurrent.MyUtils;

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

        Long aLong = Long.valueOf(Integer.toString(Integer.MAX_VALUE));
        System.out.println(MyUtils.getCurrentTime() + "aLong = " + aLong);
        Long aLong1 = Long.valueOf((long) (Math.pow(2,31) - 1));
        System.out.println(MyUtils.getCurrentTime() + "aLong1 = " + aLong1);
        System.out.println(MyUtils.getCurrentTime() + (aLong - aLong1));
    }
}
