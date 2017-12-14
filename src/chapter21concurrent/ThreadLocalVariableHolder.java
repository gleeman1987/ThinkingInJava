package chapter21concurrent;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/12/14
 * Mail:zhengjun1987@outlook.com
 */
class Accessor implements Runnable {
    private final int id;

    public Accessor(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            ThreadLocalVariableHolder.increment();
            System.out.println(MyUtils.getCurrentTime() +this);
            Thread.yield();
        }
    }

    @Override
    public String toString() {
        return "#"+id+":"+ThreadLocalVariableHolder.get();
    }
}

public class ThreadLocalVariableHolder {
    private static ThreadLocal<Integer> value = new ThreadLocal<Integer>(){
        private Random random = new Random(47);

        @Override
        protected Integer initialValue() {
            return random.nextInt(10000);
        }
    };

    public static void increment() {
        value.set(value.get()+1);
    }

    public static Integer get() {
        return value.get();
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new Accessor(i));
        }
        Thread.sleep(30);
        executorService.shutdownNow();
    }
//        2017-12-14 16:45:32:667  #0:9259
//        2017-12-14 16:45:32:668  #4:962
//        2017-12-14 16:45:32:668  #3:1862
//        2017-12-14 16:45:32:668  #2:6694
//        2017-12-14 16:45:32:668  #1:556
//        2017-12-14 16:45:32:668  #3:1863
//        2017-12-14 16:45:32:668  #2:6695
//        2017-12-14 16:45:32:668  #4:963
//        2017-12-14 16:45:32:668  #1:557
//        2017-12-14 16:45:32:668  #4:964
//        2017-12-14 16:45:32:669  #0:9260
//        2017-12-14 16:45:32:669  #4:965
//        2017-12-14 16:45:32:669  #1:558
//        2017-12-14 16:45:32:669  #2:6696
//        2017-12-14 16:45:32:669  #3:1864
//        2017-12-14 16:45:32:669  #1:559
//        2017-12-14 16:45:32:669  #3:1865
//        2017-12-14 16:45:32:669  #4:966
//        2017-12-14 16:45:32:670  #0:9261
//        2017-12-14 16:45:32:670  #3:1866
//        2017-12-14 16:45:32:670  #1:560
//        2017-12-14 16:45:32:670  #2:6697
//        2017-12-14 16:45:32:670  #3:1867
//        2017-12-14 16:45:32:670  #0:9262
//        2017-12-14 16:45:32:670  #4:967
//        2017-12-14 16:45:32:671  #0:9263
//        2017-12-14 16:45:32:671  #3:1868
//        2017-12-14 16:45:32:671  #2:6698
//        2017-12-14 16:45:32:671  #1:561
//        2017-12-14 16:45:32:671  #4:968
//        2017-12-14 16:45:32:671  #0:9264
//
//    Process finished with exit code 0
}
