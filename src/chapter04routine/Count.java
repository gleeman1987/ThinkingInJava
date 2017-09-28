package chapter04routine;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/1/8.
 */
public class Count {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            if (i==99)return;
            System.out.println(i+1);
        }
        System.out.println("后续的区别!");
    }
}
