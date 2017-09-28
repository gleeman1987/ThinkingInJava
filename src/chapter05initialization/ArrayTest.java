package chapter05initialization;

import java.util.Arrays;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/3/14.
 */
public class ArrayTest {
    public static void main(String[] args) {
        int[] ints = {1,2,3,4,5};
        int arr[] = ints;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * 2;
        }
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+" ");
        }

        System.out.println();
        System.out.println("数组初始化");
        Tobo[] a = new Tobo[5];
        System.out.println("开始组建数组");
        for (int i = 0; i < 5; i++) {
            a[i] = new Tobo("tobo"+i,i);
        }

        System.out.println(Arrays.toString(a));
    }

    static class Tobo {
        String name;
        int size;

        public Tobo(String name, int size) {
            System.out.println("name = [" + name + "], size = [" + size + "]");
            this.name = name;
            this.size = size;
        }

        @Override
        public String toString() {
            return "Tobo{" +
                    "name='" + name + '\'' +
                    ", size=" + size +
                    '}';
        }
    }
}
