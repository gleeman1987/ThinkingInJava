package chapter15generics;

import java.util.Iterator;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/9/26.
 */
public class IterableFibonacci extends Fibonacci implements Iterable<Integer> {
    private int num;

    public IterableFibonacci(int num) {
        this.num = num;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return num > 0;
            }

            @Override
            public Integer next() {
                num -- ;
                return IterableFibonacci.this.next();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        for (Integer integer : new IterableFibonacci(20)) {
            System.out.print(integer + " ");
        }
        //1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181 6765
    }
}
