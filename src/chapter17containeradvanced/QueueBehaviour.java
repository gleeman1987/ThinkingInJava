package chapter17containeradvanced;

import chapter15generics.Generator;

import java.util.LinkedList;
import java.util.Queue;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/27
 * Mail:zhengjun1987@outlook.com
 */
public class QueueBehaviour {
    public static int count = 10;
    static <T> void test(Queue<T> queue, Generator<T> generator){
        for (int i = 0; i < count; i++) {
            queue.offer(generator.next());
        }
        while (queue.peek() != null){
            System.out.print(queue.remove()+"  ");
        }
        System.out.println();
    }
    static class IGenerator implements Generator<String>{
        public static String[] array = "1234567890".split("");
        private int index;
        @Override
        public String next() {
            return array[index++];
        }
    }

    public static void main(String[] args) {
        test(new LinkedList<String>(),new IGenerator());
    }
}
