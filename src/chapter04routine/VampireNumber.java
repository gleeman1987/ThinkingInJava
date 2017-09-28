package chapter04routine;

import java.util.ArrayList;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/1/8.
 */
public class VampireNumber {
    public static void main(String[] args) {
        VampireNumber vampireNumber = new VampireNumber();
        vampireNumber.getAll();
    }

    private void getAll() {
        outer:for (int i = 1000; i < 10000; i++) {
            for (int i1 = 0; i1 < 3; i1++)
                for (int i2 = i1 + 1; i2 < 4; i2++) {
                    ArrayList<String> integers = new ArrayList<>();
                    String s = String.valueOf(i);
                    integers.add(0,String.valueOf(s.charAt(0)));
                    integers.add(1,String.valueOf(s.charAt(1)));
                    integers.add(2,String.valueOf(s.charAt(2)));
                    integers.add(3,String.valueOf(s.charAt(3)));
                    int a = Integer.valueOf(integers.remove(i1));
                    int b = Integer.valueOf(integers.remove(i2-1));
                    int c = Integer.valueOf(integers.remove(0));
                    int d = Integer.valueOf(integers.remove(0));
                    if ((a * 10 + b) * (c * 10 + d) == i) {System.out.println("---------------"+i + "-----------------");continue outer;}
                    if ((b * 10 + a) * (c * 10 + d) == i) {System.out.println("---------------"+i + "-----------------");continue outer;}
                    if ((a * 10 + b) * (d * 10 + c) == i) {System.out.println("---------------"+i + "-----------------");continue outer;}
                    if ((b * 10 + a) * (d * 10 + c) == i) {System.out.println("---------------"+i + "-----------------");continue outer;}
                }
        }
    }
}
