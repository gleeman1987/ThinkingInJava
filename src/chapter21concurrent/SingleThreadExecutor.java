package chapter21concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/12/6
 * Mail:zhengjun1987@outlook.com
 */
public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();
//        #0(9) #0(8) #0(7) #0(6) #0(5) #0(4) #0(3) #0(2) #0(1) #0(LiftOff!pool-1-thread-1)
//        #1(9) #1(8) #1(7) #1(6) #1(5) #1(4) #1(3) #1(2) #1(1) #1(LiftOff!pool-1-thread-1)
//        #2(9) #2(8) #2(7) #2(6) #2(5) #2(4) #2(3) #2(2) #2(1) #2(LiftOff!pool-1-thread-1)
//        #3(9) #3(8) #3(7) #3(6) #3(5) #3(4) #3(3) #3(2) #3(1) #3(LiftOff!pool-1-thread-1)
//        #4(9) #4(8) #4(7) #4(6) #4(5) #4(4) #4(3) #4(2) #4(1) #4(LiftOff!pool-1-thread-1)
    }
}
