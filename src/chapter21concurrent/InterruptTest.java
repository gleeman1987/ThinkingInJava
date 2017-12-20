package chapter21concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Author:Zheng Jun
 * E-mail:zhengjun1987@outlook.com
 * Date:2017/12/20
 * Project:ThinkingInJava
 */
class TestInterrupt implements Runnable {

    private long start;

    @Override
    public void run() {
        try {
            System.out.println(MyUtils.getCurrentTime() +"========START========");
            start = System.currentTimeMillis();
            Thread.sleep(2000);
            System.out.println(MyUtils.getCurrentTime() +"========BOTTOM========");
        } catch (InterruptedException e) {
            long duration = System.currentTimeMillis() - start;
            System.out.println(MyUtils.getCurrentTime() +"Thread interrupted!!!  duration:"+duration);
        }
    }
}
public class InterruptTest {
    public static void main(String[] args) throws InterruptedException {
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        Future<?> submit = executorService.submit(new TestInterrupt());
//        Thread.sleep(1500);
//        System.out.println(MyUtils.getCurrentTime() +"========CANCELLING========");
//        submit.cancel(true);

        Thread thread = new Thread(new TestInterrupt());
        thread.start();
        Thread.sleep(1400);
        System.out.println(MyUtils.getCurrentTime() +"========CANCELLING========");
        thread.interrupt();
    }
}
