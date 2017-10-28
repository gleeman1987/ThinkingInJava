package chapter17containeradvanced;

import chapter15generics.Generator;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

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
        public static String[] array = "one two three four five six seven eight nine ten one two three four five six seven eight nine ten".split(" ");
        private int index;
        @Override
        public String next() {
            return array[index++];
        }
    }

    public static void main(String[] args) {
        test(new LinkedList<String>(),new IGenerator());
//        one  two  three  four  five  six  seven  eight  nine  ten
        test(new PriorityQueue<>(),new IGenerator());
//        eight  five  four  nine  one  seven  six  ten  three  two
        test(new ArrayBlockingQueue<String>(count),new IGenerator());
//        one  two  three  four  five  six  seven  eight  nine  ten
        test(new ConcurrentLinkedQueue<>(),new IGenerator());
//        one  two  three  four  five  six  seven  eight  nine  ten
        test(new LinkedBlockingQueue<>(count),new IGenerator());
//        one  two  three  four  five  six  seven  eight  nine  ten
        test(new PriorityBlockingQueue<>(),new IGenerator());
//        eight  five  four  nine  one  seven  six  ten  three  two
    }
}
