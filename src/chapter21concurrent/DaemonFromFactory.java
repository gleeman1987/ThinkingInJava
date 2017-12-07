package chapter21concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/12/7
 * Mail:zhengjun1987@outlook.com
 */
public class DaemonFromFactory implements Runnable{
    @Override
    public void run() {
        try {
            while (true){
                Thread.sleep(600);
                System.out.println(MyUtils.getCurrentTime()+Thread.currentThread()+"  "+this);
            }
        } catch (InterruptedException e) {
            System.out.println("DaemonFromFactory.run  " + "Interrupted!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool(new DaemonThreadFactory());
        for (int i = 0; i < 3; i++) {
            executorService.execute(new DaemonFromFactory());
        }
        System.out.println(MyUtils.getCurrentTime() +"All Daemons started!");
        Thread.sleep(3000);
    }
//2017-12-07 15:50:45:999  All Daemons started!
//2017-12-07 15:50:46:583  Thread[Thread-2,5,main]  chapter21concurrent.DaemonFromFactory@57a0e8ea
//2017-12-07 15:50:46:584  Thread[Thread-1,5,main]  chapter21concurrent.DaemonFromFactory@72f5c249
//2017-12-07 15:50:46:584  Thread[Thread-0,5,main]  chapter21concurrent.DaemonFromFactory@4a24a59
//2017-12-07 15:50:47:184  Thread[Thread-1,5,main]  chapter21concurrent.DaemonFromFactory@72f5c249
//2017-12-07 15:50:47:185  Thread[Thread-0,5,main]  chapter21concurrent.DaemonFromFactory@4a24a59
//2017-12-07 15:50:47:185  Thread[Thread-2,5,main]  chapter21concurrent.DaemonFromFactory@57a0e8ea
//2017-12-07 15:50:47:785  Thread[Thread-0,5,main]  chapter21concurrent.DaemonFromFactory@4a24a59
//2017-12-07 15:50:47:786  Thread[Thread-2,5,main]  chapter21concurrent.DaemonFromFactory@57a0e8ea
//2017-12-07 15:50:47:786  Thread[Thread-1,5,main]  chapter21concurrent.DaemonFromFactory@72f5c249
//2017-12-07 15:50:48:386  Thread[Thread-0,5,main]  chapter21concurrent.DaemonFromFactory@4a24a59
//2017-12-07 15:50:48:387  Thread[Thread-2,5,main]  chapter21concurrent.DaemonFromFactory@57a0e8ea
//2017-12-07 15:50:48:388  Thread[Thread-1,5,main]  chapter21concurrent.DaemonFromFactory@72f5c249
//2017-12-07 15:50:48:987  Thread[Thread-0,5,main]  chapter21concurrent.DaemonFromFactory@4a24a59
//2017-12-07 15:50:48:988  Thread[Thread-2,5,main]  chapter21concurrent.DaemonFromFactory@57a0e8ea
//2017-12-07 15:50:48:989  Thread[Thread-1,5,main]  chapter21concurrent.DaemonFromFactory@72f5c249
}
