package chapter15generics;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/9/26.
 */
public class Fibonacci implements Generator<Integer> {
    private int count = 0;

    @Override
    public Integer next() {
        return fib(count++);
    }

    private int fib(int n){
        if (n < 2 ) return 1;
        return fib(n-1)+fib(n-2);
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        for (int i = 0; i < 20; i++) {
            System.out.print(fibonacci.next()+" ");
        }
        //1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181 6765
    }
}
