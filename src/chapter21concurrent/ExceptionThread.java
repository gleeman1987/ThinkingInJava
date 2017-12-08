package chapter21concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/12/8
 * Mail:zhengjun1987@outlook.com
 */
public class ExceptionThread implements Runnable {
    @Override
    public void run() {
        throw new RuntimeException(MyUtils.getCurrentTime()+"ExceptionThread");
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new ExceptionThread());
        executorService.shutdown();
    }
//    Exception in thread "pool-1-thread-1" java.lang.RuntimeException: 2017-12-08 17:11:24:042  ExceptionThread
//    at chapter21concurrent.ExceptionThread.run(ExceptionThread.java:15)
//    at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
//    at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
//    at java.lang.Thread.run(Thread.java:748)
//
//    Process finished with exit code 0
}
