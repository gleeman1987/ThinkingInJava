package chapter21concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/12/11
 * Mail:zhengjun1987@outlook.com
 */
class CircularSet {
  private int[] array;
  private int len;
  private int index = 0;

    public CircularSet(int size) {
        this.array = new int[size];
        len = size;
        for (int i = 0; i < array.length; i++) {
            array[i] = -1;
        }
    }

    public synchronized void add(int i){
        array[index] = i;
        index = ++index % len;
    }

    public synchronized boolean contains(int val){
        for (int i = 0; i < len; i++) {
            if (array[i] == val){return true;}
        }
        return false;
    }
}

public class SerialNumberChecker {
    private static CircularSet circularSet = new CircularSet(1000);
    private static ExecutorService executorService = Executors.newCachedThreadPool();

    static class SerialChecker implements Runnable {
        @Override
        public void run() {
            while (true){
                int serialNumber = SerialNumberGenerator.getSerialNumber();
                if (circularSet.contains(serialNumber)) {
                    System.out.println(MyUtils.getCurrentTime() +Thread.currentThread().getName()+"  ■■■Duplicate serial : "+serialNumber);
                    System.exit(0);
                }
                circularSet.add(serialNumber);
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            executorService.execute(new SerialChecker());
        }
        executorService.shutdown();
    }
}
