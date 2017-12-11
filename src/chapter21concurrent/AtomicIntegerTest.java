package chapter21concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/12/11
 * Mail:zhengjun1987@outlook.com
 */
public class AtomicIntegerTest implements Runnable {
    private volatile AtomicInteger atomicInteger = new AtomicInteger(0);

    public int get() {
        return atomicInteger.get();
    }

    private synchronized void evenIncrement() {
        atomicInteger.addAndGet(2);
//        atomicInteger.addAndGet(1);
    }

    @Override
    public void run() {
        while (true) {
            evenIncrement();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        AtomicIntegerTest command = new AtomicIntegerTest();
        executorService.execute(command);
        executorService.shutdown();
        while (true){
            int i = command.get();
            if (i % 2 != 0) {
                System.out.println(MyUtils.getCurrentTime() + "捕获到奇数 = " + i);
                System.exit(0);
            }
        }
    }
}
