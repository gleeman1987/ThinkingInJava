package chapter21concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/12/14
 * Mail:zhengjun1987@outlook.com
 */
public class LocalSynch {
    private int localValue = 0;
    private Object object = new Object();

    public int getLocalValue() {
        synchronized (object) {
            return localValue;
        }
    }

    public void setLocalValue() {
        synchronized (" ") {
            this.localValue++;
            this.localValue++;
            Thread.yield();
            this.localValue++;
            Thread.yield();
            this.localValue++;
            Thread.yield();
            this.localValue++;
            System.out.println(MyUtils.getCurrentTime() + "LocalSynch.setLocalValue  " + "+5");
        }
    }

    static class Setter implements Runnable {
        LocalSynch localSynch;

        public Setter(LocalSynch localSynch) {
            this.localSynch = localSynch;
        }

        @Override
        public void run() {
            while (true){
                localSynch.setLocalValue();
            }
        }
    }

    static class Getter implements Runnable {
        LocalSynch localSynch;

        public Getter(LocalSynch localSynch) {
            this.localSynch = localSynch;
        }

        @Override
        public void run() {
            while (true){
                int localValue = localSynch.getLocalValue();
                if (localValue %  5 != 0) {
                    throw new RuntimeException("线程互斥出错,产生了不能被5整除的值:"+localValue);
                }
                System.out.println(MyUtils.getCurrentTime() + "localSynch.getLocalValue() = " + localValue);
            }
        }
    }

    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                e.printStackTrace();
                System.exit(1);
            }
        });
        LocalSynch localSynch = new LocalSynch();
        new Thread(new Setter(localSynch)).start();
        new Thread(new Getter(localSynch)).start();
        new Thread(new Getter(localSynch)).start();
        new Thread(new Getter(localSynch)).start();
        new Thread(new Getter(localSynch)).start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
//            2017-12-14 14:47:48:714  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:714  localSynch.getLocalValue() = 5
//            2017-12-14 14:47:48:714  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:714  localSynch.getLocalValue() = 10
//            2017-12-14 14:47:48:714  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:714  localSynch.getLocalValue() = 15
//            2017-12-14 14:47:48:714  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:714  localSynch.getLocalValue() = 20
//            2017-12-14 14:47:48:714  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:714  localSynch.getLocalValue() = 25
//            2017-12-14 14:47:48:714  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:714  localSynch.getLocalValue() = 30
//            2017-12-14 14:47:48:714  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:714  localSynch.getLocalValue() = 35
//            2017-12-14 14:47:48:714  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:714  localSynch.getLocalValue() = 40
//            2017-12-14 14:47:48:714  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:714  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:714  localSynch.getLocalValue() = 45
//            2017-12-14 14:47:48:714  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:714  localSynch.getLocalValue() = 55
//            2017-12-14 14:47:48:714  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:714  localSynch.getLocalValue() = 60
//            2017-12-14 14:47:48:714  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:714  localSynch.getLocalValue() = 65
//            2017-12-14 14:47:48:714  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:714  localSynch.getLocalValue() = 70
//            2017-12-14 14:47:48:714  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:714  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:714  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:714  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:714  localSynch.getLocalValue() = 75
//            2017-12-14 14:47:48:714  localSynch.getLocalValue() = 95
//            2017-12-14 14:47:48:714  localSynch.getLocalValue() = 95
//            2017-12-14 14:47:48:714  localSynch.getLocalValue() = 95
//            2017-12-14 14:47:48:714  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:714  localSynch.getLocalValue() = 95
//            2017-12-14 14:47:48:714  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:714  localSynch.getLocalValue() = 100
//            2017-12-14 14:47:48:714  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:714  localSynch.getLocalValue() = 105
//            2017-12-14 14:47:48:714  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:714  localSynch.getLocalValue() = 110
//            2017-12-14 14:47:48:714  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:714  localSynch.getLocalValue() = 115
//            2017-12-14 14:47:48:714  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:714  localSynch.getLocalValue() = 120
//            2017-12-14 14:47:48:714  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:714  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:714  localSynch.getLocalValue() = 125
//            2017-12-14 14:47:48:714  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:714  localSynch.getLocalValue() = 135
//            2017-12-14 14:47:48:714  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:714  localSynch.getLocalValue() = 140
//            2017-12-14 14:47:48:714  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:729  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:729  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:729  localSynch.getLocalValue() = 145
//            2017-12-14 14:47:48:729  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:729  localSynch.getLocalValue() = 160
//            2017-12-14 14:47:48:729  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:729  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:729  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:729  localSynch.getLocalValue() = 165
//            2017-12-14 14:47:48:729  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:729  localSynch.getLocalValue() = 180
//            2017-12-14 14:47:48:729  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:729  localSynch.getLocalValue() = 185
//            2017-12-14 14:47:48:729  localSynch.getLocalValue() = 190
//            2017-12-14 14:47:48:729  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:729  localSynch.getLocalValue() = 190
//            2017-12-14 14:47:48:729  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:729  localSynch.getLocalValue() = 195
//            2017-12-14 14:47:48:729  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:729  localSynch.getLocalValue() = 200
//            2017-12-14 14:47:48:729  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:729  localSynch.getLocalValue() = 205
//            2017-12-14 14:47:48:729  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:729  localSynch.getLocalValue() = 210
//            2017-12-14 14:47:48:729  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:729  localSynch.getLocalValue() = 215
//            2017-12-14 14:47:48:729  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:729  localSynch.getLocalValue() = 220
//            2017-12-14 14:47:48:729  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:729  localSynch.getLocalValue() = 225
//            2017-12-14 14:47:48:729  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:729  localSynch.getLocalValue() = 230
//            2017-12-14 14:47:48:729  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:729  localSynch.getLocalValue() = 235
//            2017-12-14 14:47:48:729  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:729  localSynch.getLocalValue() = 240
//            2017-12-14 14:47:48:729  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:729  localSynch.getLocalValue() = 245
//            2017-12-14 14:47:48:729  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:729  localSynch.getLocalValue() = 250
//            2017-12-14 14:47:48:729  LocalSynch.setLocalValue  +5
//            2017-12-14 14:47:48:729  localSynch.getLocalValue() = 255
//            2017-12-14 14:47:48:729  LocalSynch.setLocalValue  +5
}
