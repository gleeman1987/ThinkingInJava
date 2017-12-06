package chapter21concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Author:Zheng Jun
 * E-mail:zhengjun1987@outlook.com
 * Date:2017/12/6
 * Project:ThinkingInJava
 */
public class SleepingTask extends LiftOff {
    @Override
    public void run() {
        while (countDown -- >0) {
            System.out.print(status());
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.submit(new SleepingTask());
        }
        executorService.shutdown();
    }
//            #0(9) #1(9) #2(9) #3(9) #4(9) #1(8) #3(8) #0(8) #2(8) #4(8) #1(7) #3(7) #0(7)#2(7) #4(7)
//            #0(6) #3(6) #1(6) #2(6) #4(6) #3(5) #1(5) #2(5) #0(5) #4(5) #3(4)#1(4) #2(4)#0(4) #4(4)
//            #3(3)#1(3) #2(3) #0(3) #4(3) #1(2) #0(2) #3(2) #2(2) #4(2) #1(1)#3(1) #0(1) #2(1) #4(1)
//            #2(LiftOff!pool-1-thread-3)
//            #0(LiftOff!pool-1-thread-1)
//            #3(LiftOff!pool-1-thread-4)
//            #1(LiftOff!pool-1-thread-2)
//            #4(LiftOff!pool-1-thread-5)
}
