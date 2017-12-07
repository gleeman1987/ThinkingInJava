package chapter21concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/12/7
 * Mail:zhengjun1987@outlook.com
 */
public class SimplePriorities implements Runnable {
    private int countdown = 5;
    private volatile double d;
    private int priority;

    public SimplePriorities(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return Thread.currentThread() + ": " + countdown;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        while (true) {
            for (int i = 1; i < 100000; i++) {
                d += (Math.PI + Math.E) / i;
                if (i % 1000 == 0) {
                    System.out.println("d = " + d);
                    Thread.yield();
                }
            }
            System.out.println(this);
            if (--countdown == 0) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new SimplePriorities(Thread.MIN_PRIORITY));
        }
        executorService.execute(new SimplePriorities(Thread.MAX_PRIORITY));
        executorService.shutdown();
    }
//    Thread[pool-1-thread-6,10,main]: 5
//    Thread[pool-1-thread-6,10,main]: 4
//    Thread[pool-1-thread-1,1,main]: 5
//    Thread[pool-1-thread-2,1,main]: 5
//    Thread[pool-1-thread-6,10,main]: 3
//    Thread[pool-1-thread-5,1,main]: 5
//    Thread[pool-1-thread-3,1,main]: 5
//    Thread[pool-1-thread-4,1,main]: 5
//    Thread[pool-1-thread-6,10,main]: 2
//    Thread[pool-1-thread-6,10,main]: 1
//    Thread[pool-1-thread-2,1,main]: 4
//    Thread[pool-1-thread-1,1,main]: 4
//    Thread[pool-1-thread-3,1,main]: 4
//    Thread[pool-1-thread-5,1,main]: 4
//    Thread[pool-1-thread-4,1,main]: 4
//    Thread[pool-1-thread-2,1,main]: 3
//    Thread[pool-1-thread-1,1,main]: 3
//    Thread[pool-1-thread-3,1,main]: 3
//    Thread[pool-1-thread-5,1,main]: 3
//    Thread[pool-1-thread-4,1,main]: 3
//    Thread[pool-1-thread-2,1,main]: 2
//    Thread[pool-1-thread-5,1,main]: 2
//    Thread[pool-1-thread-1,1,main]: 2
//    Thread[pool-1-thread-3,1,main]: 2
//    Thread[pool-1-thread-4,1,main]: 2
//    Thread[pool-1-thread-2,1,main]: 1
//    Thread[pool-1-thread-5,1,main]: 1
//    Thread[pool-1-thread-1,1,main]: 1
//    Thread[pool-1-thread-3,1,main]: 1
//    Thread[pool-1-thread-4,1,main]: 1
}
