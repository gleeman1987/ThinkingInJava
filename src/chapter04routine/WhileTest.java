package chapter04routine;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/1/8.
 */
public class WhileTest {
    public static void main(String[] args) {
        while (condition())
            System.out.println(" 继续执行while循环");
        System.out.println("  跳出了while循环");
    }

    private static boolean condition() {
        double random = Math.random();
        boolean b = random < 0.99;
        System.out.print(random +"   "+b);
        return b;
    }
}
