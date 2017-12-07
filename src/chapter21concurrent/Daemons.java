package chapter21concurrent;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/12/7
 * Mail:zhengjun1987@outlook.com
 */
public class Daemons {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Daemon());
        thread.setDaemon(true);
        thread.start();
        System.out.println(MyUtils.getCurrentTime() + "thread.isDaemon() = " + thread.isDaemon());
        Thread.sleep(1000);
    }
//            2017-12-07 16:38:45:193  thread.isDaemon() = true
//            2017-12-07 16:38:45:193  DaemonSpawn 0 started!
//            2017-12-07 16:38:45:193  DaemonSpawn 1 started!
//            2017-12-07 16:38:45:194  DaemonSpawn 2 started!
//            2017-12-07 16:38:45:194  DaemonSpawn 3 started!
//            2017-12-07 16:38:45:194  DaemonSpawn 4 started!
//            2017-12-07 16:38:45:194  DaemonSpawn 5 started!
//            2017-12-07 16:38:45:194  DaemonSpawn 6 started!
//            2017-12-07 16:38:45:194  DaemonSpawn 7 started!
//            2017-12-07 16:38:45:194  DaemonSpawn 8 started!
//            2017-12-07 16:38:45:195  DaemonSpawn 9 started!
//            2017-12-07 16:38:45:195  pool[0].isDaemon() = true
//            2017-12-07 16:38:45:195  pool[1].isDaemon() = true
//            2017-12-07 16:38:45:195  pool[2].isDaemon() = true
//            2017-12-07 16:38:45:195  pool[3].isDaemon() = true
//            2017-12-07 16:38:45:195  pool[4].isDaemon() = true
//            2017-12-07 16:38:45:196  pool[5].isDaemon() = true
//            2017-12-07 16:38:45:196  pool[6].isDaemon() = true
//            2017-12-07 16:38:45:196  pool[7].isDaemon() = true
//            2017-12-07 16:38:45:196  pool[8].isDaemon() = true
//            2017-12-07 16:38:45:196  pool[9].isDaemon() = true
}

class DaemonSpawn implements Runnable{
    @Override
    public void run() {
        while (true){
            Thread.yield();
        }
    }
}

class Daemon implements Runnable {
    private Thread[] pool = new Thread[10];
    @Override
    public void run() {
        for (int i = 0; i < pool.length; i++) {
            pool[i] = new Thread(new DaemonSpawn());
            pool[i].start();
            System.out.println(MyUtils.getCurrentTime() + "DaemonSpawn "+i+" started!");
        }
        for (int i = 0; i < pool.length; i++) {
            System.out.println(MyUtils.getCurrentTime() + "pool["+i+"].isDaemon() = " + pool[i].isDaemon());
            //后台线程里面产生的新的子线程也是后台线程
        }
        while (true)
            Thread.yield();
    }
}
