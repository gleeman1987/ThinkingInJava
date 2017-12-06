package chapter21concurrent;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/12/6
 * Mail:zhengjun1987@outlook.com
 */
public class LiftOff implements Runnable {
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int taskId = taskCount++;

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public LiftOff() {
    }

    public String status() {
        return "#"+taskId+"("+(countDown>0?countDown:"LiftOff!"+Thread.currentThread().getName())+") ";
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.print(status());
            Thread.yield();
        }
    }
}
