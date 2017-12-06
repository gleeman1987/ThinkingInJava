package chapter21concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/12/6
 * Mail:zhengjun1987@outlook.com
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            newCachedThreadPool.execute(new LiftOff());
        }
        newCachedThreadPool.shutdown();
//        #0(9) #0(8) #0(7) #0(6) #2(9) #0(5) #1(9) #3(9) #2(8) #1(8) #4(9) #3(8) #0(4) #2(7) #1(7) #4(8)
//        #3(7) #0(3) #2(6) #1(6) #4(7) #3(6) #0(2) #2(5) #1(5) #4(6) #3(5) #0(1) #2(4) #3(4) #4(5) #1(4)
//        #3(3) #2(3) #1(3) #4(4) #0(LiftOff!pool-1-thread-1) #3(2) #2(2) #1(2) #4(3) #3(1) #2(1) #1(1) #4(2)
//        #3(LiftOff!pool-1-thread-4) #2(LiftOff!pool-1-thread-3) #1(LiftOff!pool-1-thread-2) #4(1) #4(LiftOff!pool-1-thread-5)

    }
}
