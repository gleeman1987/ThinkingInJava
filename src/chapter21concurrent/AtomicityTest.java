package chapter21concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/12/11
 * Mail:zhengjun1987@outlook.com
 */
public class AtomicityTest implements Runnable {
    private int i = 0;

    public int getValue() {
        return i;
    }

    private synchronized void evenIncrement(){
        i++;
        i++;
    }

    @Override
    public void run() {
        while (true){
            evenIncrement();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        AtomicityTest atomicityTest = new AtomicityTest();
        executorService.execute(atomicityTest);
        executorService.shutdown();
        while (true){
            int value = atomicityTest.getValue();
            if (value % 2 != 0) {
                System.out.println(MyUtils.getCurrentTime() + "程序出现错误奇数值 value = " + value);
                System.exit(0);
            }
        }
//        2017-12-11 11:07:06:178  程序出现错误奇数值 value = 799
//
//        Process finished with exit code 0
    }
}
