package chapter16arrays;

import java.util.Arrays;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/25
 * Mail:zhengjun1987@outlook.com
 */
public class CopyingArrays {
    public static void main(String[] args) {
        int[] i = new int[7];
        int[] j = new int[10];
        Arrays.fill(i,47);
        Arrays.fill(j,99);
        System.out.println("Arrays.toString(i) = " + Arrays.toString(i));
        System.out.println("Arrays.toString(j) = " + Arrays.toString(j));
//        Arrays.toString(i) = [47, 47, 47, 47, 47, 47, 47]
//        Arrays.toString(j) = [99, 99, 99, 99, 99, 99, 99, 99, 99, 99]

        System.arraycopy(i,0,j,0,i.length);
        System.out.println("Arrays.toString(j) = " + Arrays.toString(j));
//        Arrays.toString(j) = [47, 47, 47, 47, 47, 47, 47, 99, 99, 99]
        int[] k = new int[5];
        Arrays.fill(k,103);
        System.arraycopy(i,0,k,0,k.length);
        System.out.println("Arrays.toString(k) = " + Arrays.toString(k));
//        Arrays.toString(k) = [47, 47, 47, 47, 47]
        Arrays.fill(k,103);
        System.arraycopy(k,0,i,0,k.length);
        System.out.println("Arrays.toString(i) = " + Arrays.toString(i));
//        Arrays.toString(i) = [103, 103, 103, 103, 103, 47, 47]

        Integer[] u = new Integer[10];
        Integer[] v = new Integer[5];
        Arrays.fill(u,new Integer(47));
        Arrays.fill(v,new Integer(99));
        System.out.println("Arrays.toString(u) = " + Arrays.toString(u));
        System.out.println("Arrays.toString(v) = " + Arrays.toString(v));
//        Arrays.toString(u) = [47, 47, 47, 47, 47, 47, 47, 47, 47, 47]
//        Arrays.toString(v) = [99, 99, 99, 99, 99]

        System.arraycopy(v,0,u,u.length/2,v.length);
        System.out.println("Arrays.toString(u) = " + Arrays.toString(u));
//        Arrays.toString(u) = [47, 47, 47, 47, 47, 99, 99, 99, 99, 99]
    }
}
