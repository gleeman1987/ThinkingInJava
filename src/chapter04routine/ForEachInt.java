package chapter04routine;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/21
 * Mail:zhengjun1987@outlook.com
 */
public class ForEachInt {
    public static void main(String[] args) {
        int[] arr = range(10);
        for (int i : arr) {
            System.out.print(i + " ");
        }

        System.out.println();

        for (int i : range(12, 31)) {
            System.out.print(i + " ");
        }
    }

    private static int[] range(int start, int end) {
        int[] ints = new int[end - start];
        for (int i = 0; i < end - start; i++) {
            ints[i] = start + i;
        }
        return ints;
    }

    private static int[] range(int i) {
        int[] ints = new int[i];
        for (int i1 = 0; i1 < i; i1++) {
            ints[i1] = i1;
        }
        return ints;
    }
}
