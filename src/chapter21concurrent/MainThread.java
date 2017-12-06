package chapter21concurrent;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/12/6
 * Mail:zhengjun1987@outlook.com
 */
public class MainThread {
    public static void main(String[] args) {
        LiftOff liftOff = new LiftOff();
        liftOff.run();
        System.out.println();

        for (int i = 0; i < 10000; i++) {
            if (i % 2 == 1 && i % 6 == 3 && i % 9 == 0 && i % 8 == 1 && i % 5 == 4 && i % 7 == 0) {
                System.out.println("i = " + i);
            }
        }
    }
}
