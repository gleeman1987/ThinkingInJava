package chapter04routine;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/1/8.
 */
public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        int[] array = fibonacci.getArray(50);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    private int[] getArray(int i) {
        if (i <=2) {
            return null;
        }

        int[] ints = new int[i];
        ints[0] = 1;
        ints[1] = 1;
        if (i > 2) {
            for (int i1 = 2; i1 < ints.length; i1++) {
                ints[i1] = ints[i1 - 1] + ints[i1-2];
                if (ints[i1] > Integer.MAX_VALUE/2) break;
            }
        }
        return ints;
    }
}
