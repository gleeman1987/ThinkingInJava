package chapter21concurrent;


/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/12/7
 * Mail:zhengjun1987@outlook.com
 */
public class SimpleDaemons implements Runnable {

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(300);
                System.out.println(MyUtils.getCurrentTime()+Thread.currentThread()+" "+this);
            } catch (InterruptedException e) {
                System.out.println(MyUtils.getCurrentTime()+"SimpleDaemons.sleep  " + "interrupted");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true);
            daemon.start();
        }
        System.out.println(MyUtils.getCurrentTime()+"All daemons started!");
        Thread.sleep(2000);
    }
//2017-12-07 15:18:13:116  All daemons started!
//2017-12-07 15:18:13:377  Thread[Thread-1,5,main] chapter21concurrent.SimpleDaemons@3d7c301d
//2017-12-07 15:18:13:378  Thread[Thread-0,5,main] chapter21concurrent.SimpleDaemons@5169ce60
//2017-12-07 15:18:13:377  Thread[Thread-2,5,main] chapter21concurrent.SimpleDaemons@3d6741a8
//2017-12-07 15:18:13:679  Thread[Thread-1,5,main] chapter21concurrent.SimpleDaemons@3d7c301d
//2017-12-07 15:18:13:680  Thread[Thread-0,5,main] chapter21concurrent.SimpleDaemons@5169ce60
//2017-12-07 15:18:13:680  Thread[Thread-2,5,main] chapter21concurrent.SimpleDaemons@3d6741a8
//2017-12-07 15:18:13:979  Thread[Thread-1,5,main] chapter21concurrent.SimpleDaemons@3d7c301d
//2017-12-07 15:18:13:980  Thread[Thread-0,5,main] chapter21concurrent.SimpleDaemons@5169ce60
//2017-12-07 15:18:13:980  Thread[Thread-2,5,main] chapter21concurrent.SimpleDaemons@3d6741a8
//2017-12-07 15:18:14:280  Thread[Thread-1,5,main] chapter21concurrent.SimpleDaemons@3d7c301d
//2017-12-07 15:18:14:281  Thread[Thread-2,5,main] chapter21concurrent.SimpleDaemons@3d6741a8
//2017-12-07 15:18:14:281  Thread[Thread-0,5,main] chapter21concurrent.SimpleDaemons@5169ce60
//2017-12-07 15:18:14:581  Thread[Thread-1,5,main] chapter21concurrent.SimpleDaemons@3d7c301d
//2017-12-07 15:18:14:582  Thread[Thread-2,5,main] chapter21concurrent.SimpleDaemons@3d6741a8
//2017-12-07 15:18:14:582  Thread[Thread-0,5,main] chapter21concurrent.SimpleDaemons@5169ce60
//2017-12-07 15:18:14:882  Thread[Thread-1,5,main] chapter21concurrent.SimpleDaemons@3d7c301d
//2017-12-07 15:18:14:883  Thread[Thread-2,5,main] chapter21concurrent.SimpleDaemons@3d6741a8
//2017-12-07 15:18:14:884  Thread[Thread-0,5,main] chapter21concurrent.SimpleDaemons@5169ce60
//
//Process finished with exit code 0
}
