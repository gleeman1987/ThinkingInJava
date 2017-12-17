package chapter21concurrent;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Author:Zheng Jun
 * E-mail:zhengjun1987@outlook.com
 * Date:2017/12/17
 * Project:ThinkingInJava
 */
class SleepBlocked implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(100*1000);
        } catch (InterruptedException e) {
            System.out.println(MyUtils.getCurrentTime() +"Interrupt Exception");
        }
        System.out.println(MyUtils.getCurrentTime() + "Exiting from SleepBlocked.run  " + "");
    }
}

class IOBlocked implements Runnable {
    private InputStream inputStream;

    public IOBlocked(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        try {
            System.out.println(MyUtils.getCurrentTime() +"Waiting for read():");
            inputStream.read();
        } catch (IOException e) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println(MyUtils.getCurrentTime() +"Interrupted from Blocked I/O");
            } else {
                throw new RuntimeException();
            }
        }
        System.out.println(MyUtils.getCurrentTime() + "Exiting from IOBlocked.run  " + "");
    }
}

class SynchronizedBlock implements Runnable {
    private synchronized void f(){
        while (true)
            Thread.yield();
    }

    public SynchronizedBlock() {
        new Thread(){
            @Override
            public void run() {
                f();
            }
        }.start();
    }

    @Override
    public void run() {
        System.out.println(MyUtils.getCurrentTime() +"Try to call f()");
        f();
        System.out.println(MyUtils.getCurrentTime() + "Exiting from SynchronizedBlock.run  " + "");
    }
}

public class Interrupting {
    private static ExecutorService executorService = Executors.newCachedThreadPool();
    static void test(Runnable runnable) throws InterruptedException {
        Future<?> future = executorService.submit(runnable);
        Thread.sleep(100);
        System.out.println(MyUtils.getCurrentTime() + "Interrupting ["+ runnable.getClass().getSimpleName()+ "]");
        future.cancel(true);
        System.out.println(MyUtils.getCurrentTime() +"Interrupt sent to "+runnable.getClass().getSimpleName());
    }

    public static void main(String[] args) throws InterruptedException {
        test(new SleepBlocked());
        test(new IOBlocked(System.in));
        test(new SynchronizedBlock());
        Thread.sleep(3000);
        System.out.println(MyUtils.getCurrentTime() +"Aborting with System.exit(0)");
        System.exit(0);
    }
//2017-12-17 17:20:50:058  Interrupting [SleepBlocked]
//2017-12-17 17:20:50:060  Interrupt sent to SleepBlocked
//2017-12-17 17:20:50:060  Interrupt Exception
//2017-12-17 17:20:50:061  Exiting from SleepBlocked.run
    //休眠的线程可以通过Future.cancel来中断
//2017-12-17 17:20:50:062  Waiting for read():
//2017-12-17 17:20:50:169  Interrupting [IOBlocked]
//2017-12-17 17:20:50:170  Interrupt sent to IOBlocked
    //IO的线程无法通过Future.cancel来中断
//2017-12-17 17:20:50:175  Try to call f()
//2017-12-17 17:20:50:280  Interrupting [SynchronizedBlock]
//2017-12-17 17:20:50:281  Interrupt sent to SynchronizedBlock
    //异步锁住的线程无法通过Future.cancel来中断
//2017-12-17 17:20:53:282  Aborting with System.exit(0)
//
//Process finished with exit code 0
}
