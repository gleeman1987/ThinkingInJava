package chapter04routine;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/1/8.
 */
public class ListPrimeNumber {
    public static void main(String[] args) {
//        int count = 0;
        for (int i = 3,count = 0; i < 100; i++) {
            boolean isNotPrimeNumber = false;
            for (int j = 2; j < i; j++) {
                if (i%j==0) {
                    isNotPrimeNumber = true;
                    break;
                }
                if (j==i-1 && !isNotPrimeNumber) {
                    ++count;
                    String s = i + "  ";
                    System.out.print(s);
                    sayCount(count);
                }
            }
        }
        System.out.println();
//        System.out.println("素数个数为:"+count);
    }

    private static void sayCount(int count) {
        if (count%10==0) {
            System.out.println();
        }
    }
}
