package chapter21concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/12/8
 * Mail:zhengjun1987@outlook.com
 */
public class SettingDefaultHandler {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new ExceptionThread());
        executorService.shutdown();
    }
//    2017-12-08 17:51:53:083  MyUncaughtExceptionHandler.uncaughtException 捕获到异常 t = [Thread[pool-1-thread-1,5,main]], e = [java.lang.RuntimeException: 2017-12-08 17:51:53:082  ExceptionThread]
//
//    Process finished with exit code 0
}
