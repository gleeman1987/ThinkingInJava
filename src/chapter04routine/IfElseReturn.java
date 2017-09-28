package chapter04routine;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/1/8.
 */
public class IfElseReturn {
    public static void main(String[] args) {
        System.out.println(test(1,2));
        System.out.println(test(2,2));
        System.out.println(test(3,2));
    }

    private static int test(int i, int i1) {
        if (i == i1)
            return 0;
        else if (i < i1)
            return -1;
        else
            return 1;
    }
}
