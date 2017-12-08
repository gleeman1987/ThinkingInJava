package chapter21concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/12/8
 * Mail:zhengjun1987@outlook.com
 */
public class NaiveExceptionHandling {
    public static void main(String[] args) {
        //子线程中的异常无法通过父线程的try-catch异常处理机制来进行处理 UNCaughtException!!!
        try {
            ExecutorService executorService = Executors.newCachedThreadPool();
            executorService.execute(new ExceptionThread());
            executorService.shutdown();
        } catch (Exception e) {
            System.out.println(MyUtils.getCurrentTime() + "捕获到异常 e = " + e);
        }
    }
//    Exception in thread "pool-1-thread-1" java.lang.RuntimeException: 2017-12-08 17:15:29:888  ExceptionThread
//    at chapter21concurrent.ExceptionThread.run(ExceptionThread.java:15)
//    at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
//    at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
//    at java.lang.Thread.run(Thread.java:748)
//
//    Process finished with exit code 0
}
