package chapter21concurrent;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/12/21
 * Mail:zhengjun1987@outlook.com
 */
class NeedCleanUp {
    private final int id;

    public NeedCleanUp(int id) {
        this.id = id;
        System.out.println(MyUtils.getCurrentTime() + "NeedCleanUp.<init>  id = " + id);
    }

    public void cleanup() {
        System.out.println(MyUtils.getCurrentTime() + "NeedCleanUp.cleanup  id = " + id);
    }
}

class Blocked3 implements Runnable {
    private volatile double d = 0.0;

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                NeedCleanUp needCleanUp = new NeedCleanUp(1);
                try {
                    System.out.println(MyUtils.getCurrentTime() + "Sleeping");
                    Thread.sleep(1000);
                    NeedCleanUp needCleanUp2 = new NeedCleanUp(2);
                    try {
                        System.out.println(MyUtils.getCurrentTime() +"Calculating");
                        for (int i = 0; i < 25000000; i++) {
                            d = d + (Math.PI + Math.E)/d;
                        }
                        System.out.println(MyUtils.getCurrentTime() + "d = " + d);
                        System.out.println(MyUtils.getCurrentTime() +"Time-consuming operation finished");
                    } finally {
                        needCleanUp2.cleanup();
                    }
                } finally {
                    needCleanUp.cleanup();
                }
            }
        } catch (InterruptedException e) {
            System.out.println(MyUtils.getCurrentTime() + "Exiting through InterruptedException");
        }
    }
}

public class InterruptIdiom {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Blocked3());
        thread.start();
        Thread.sleep(2195);
        thread.interrupt();
    }
//2017-12-21 16:32:10:567  NeedCleanUp.<init>  id = 1
//2017-12-21 16:32:10:568  Sleeping
//2017-12-21 16:32:11:569  NeedCleanUp.<init>  id = 2
//2017-12-21 16:32:11:569  Calculating
//2017-12-21 16:32:11:589  d = Infinity
//2017-12-21 16:32:11:589  Time-consuming operation finished
//2017-12-21 16:32:11:589  NeedCleanUp.cleanup  id = 2
//2017-12-21 16:32:11:589  NeedCleanUp.cleanup  id = 1
//2017-12-21 16:32:11:589  NeedCleanUp.<init>  id = 1
//2017-12-21 16:32:11:589  Sleeping
//2017-12-21 16:32:12:039  NeedCleanUp.cleanup  id = 1
//2017-12-21 16:32:12:039  Exiting through InterruptedException
//
//Process finished with exit code 0
}
