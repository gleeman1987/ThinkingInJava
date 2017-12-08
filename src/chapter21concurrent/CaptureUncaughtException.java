package chapter21concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/12/8
 * Mail:zhengjun1987@outlook.com
 */
class ExceptionThread2 implements Runnable {
    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        System.out.println(MyUtils.getCurrentTime() + "currentThread = " + currentThread);
        System.out.println(MyUtils.getCurrentTime() + "currentThread.getUncaughtExceptionHandler() = " + currentThread.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(MyUtils.getCurrentTime() + "MyUncaughtExceptionHandler.uncaughtException 捕获到异常 " + "t = [" + t + "], e = [" + e + "]");
    }
}

class HandlerThreadFactory implements ThreadFactory{
    @Override
    public Thread newThread(Runnable r) {
        System.out.println(MyUtils.getCurrentTime() + this + " creating new thread!");
        Thread thread = new Thread(r);
        System.out.println(MyUtils.getCurrentTime() + "thread created = " + thread);
        thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println(MyUtils.getCurrentTime() + "thread.getUncaughtExceptionHandler() = " + thread.getUncaughtExceptionHandler());
        return thread;
    }
}

public class CaptureUncaughtException {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool(new HandlerThreadFactory());
        executorService.execute(new ExceptionThread2());
        executorService.shutdown();
//        2017-12-08 17:48:41:976  chapter21concurrent.HandlerThreadFactory@5e2de80c creating new thread!
//        2017-12-08 17:48:41:976  thread created = Thread[Thread-0,5,main]
//        2017-12-08 17:48:41:977  thread.getUncaughtExceptionHandler() = chapter21concurrent.MyUncaughtExceptionHandler@1d44bcfa
//        2017-12-08 17:48:41:977  currentThread = Thread[Thread-0,5,main]
//        2017-12-08 17:48:41:977  currentThread.getUncaughtExceptionHandler() = chapter21concurrent.MyUncaughtExceptionHandler@1d44bcfa
//        2017-12-08 17:48:41:978  MyUncaughtExceptionHandler.uncaughtException 捕获到异常 t = [Thread[Thread-0,5,main]], e = [java.lang.RuntimeException]
    }
}
