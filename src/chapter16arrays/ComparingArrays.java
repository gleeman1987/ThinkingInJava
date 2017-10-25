package chapter16arrays;

import java.util.Arrays;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/25
 * Mail:zhengjun1987@outlook.com
 */
public class ComparingArrays {
    public static void main(String[] args) {
        int[] a1 = new int[10];
        int[] a2 = new int[10];
        Arrays.fill(a1,47);
        Arrays.fill(a2,47);
        System.out.println("Arrays.equals(a1,a2) = " + Arrays.equals(a1, a2));
//        Arrays.equals(a1,a2) = true

        a2[3] = 11;
        System.out.println("Arrays.equals(a1,a2) = " + Arrays.equals(a1, a2));
//        Arrays.equals(a1,a2) = false

        String[] s1 = new String[4];
        Arrays.fill(s1,"Hi");
        String[] s2 = {new String("Hi"),new String("Hi"),new String("Hi"),new String("Hi")};
        System.out.println("Arrays.equals(s1,s2) = " + Arrays.equals(s1, s2));;
//        Arrays.equals(s1,s2) = true


        String[][] strings = new String[3][3];
        String[][] strings1 = new String[3][3];
        for (int i = 0; i < strings.length; i++) {
            for (int i1 = 0; i1 < strings[i].length; i1++) {
                strings[i][i1] = ""+i+""+i1;
                strings1[i][i1] = ""+i+""+i1;
            }
        }
        System.out.println("strings = " + Arrays.deepToString(strings));
        System.out.println("strings1 = " + Arrays.deepToString(strings1));
        System.out.println("Arrays.deepEquals(strings,strings1) = " + Arrays.deepEquals(strings, strings1));
//        strings = [[00, 01, 02], [10, 11, 12], [20, 21, 22]]
//        strings1 = [[00, 01, 02], [10, 11, 12], [20, 21, 22]]
//        Arrays.deepEquals(strings,strings1) = true

        strings[1][1] = "99";
        System.out.println("Arrays.deepEquals(strings,strings1) = " + Arrays.deepEquals(strings, strings1));
//        Arrays.deepEquals(strings,strings1) = false
    }
}
