package chapter21concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author:Zheng Jun
 * E-mail:zhengjun1987@outlook.com
 * Date:2017/12/9
 * Project:ThinkingInJava
 */
public class EvenChecker implements Runnable {
    private IntGenerator intGenerator;
    private final int id;

    public EvenChecker(IntGenerator intGenerator, int id) {
        this.intGenerator = intGenerator;
        this.id = id;
    }

    @Override
    public String toString() {
        return "EvenChecker{" +
                "intGenerator=" + intGenerator +
                ", id=" + id +
                ", currentThread=" + Thread.currentThread().getName() +
                '}';
    }

    @Override
    public void run() {
        while (!intGenerator.isCanceled()){
            int next = intGenerator.next();
//            System.out.println(MyUtils.getCurrentTime() + "next = " + next);
            if (next % 2 != 0) {
                System.out.println(MyUtils.getCurrentTime()+this+"  next = " + next + " NOT EVEN!!");
                intGenerator.cancel();
            }
        }
    }

    public static void test(IntGenerator intGenerator,int count){
        System.out.println(MyUtils.getCurrentTime()+"Press Control+C to exit");
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            executorService.execute(new EvenChecker(intGenerator,i));
        }
        executorService.shutdown();
    }

    public static void test(IntGenerator intGenerator){
        test(intGenerator,10);
    }
//    2017-12-09 16:54:31:246  Press Control+C to exit
//    2017-12-09 16:54:31:253  pool-1-thread-1  next = 1273 NOT EVEN!!
//    2017-12-09 16:54:31:253  pool-1-thread-3  next = 1277 NOT EVEN!!
//    2017-12-09 16:54:31:253  pool-1-thread-2  next = 1275 NOT EVEN!!
//    2017-12-09 16:54:31:254  pool-1-thread-4  next = 1279 NOT EVEN!!
//
//    Process finished with exit code 0
}
