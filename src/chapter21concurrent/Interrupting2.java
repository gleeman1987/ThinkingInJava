package chapter21concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Author:Zheng Jun
 * E-mail:zhengjun1987@outlook.com
 * Date:2017/12/20
 * Project:ThinkingInJava
 */
class BlockedMutex {
    private ReentrantLock lock = new ReentrantLock();

    public BlockedMutex() {
        lock.lock();
    }

    public void f(){
        try {
            lock.lockInterruptibly();
        } catch (InterruptedException e) {
            System.out.println(MyUtils.getCurrentTime() + "Interrupted from aquisition lock in BlockedMutex.f  " + "");
        }
    }
}

class Blocked2 implements Runnable {
    BlockedMutex blockedMutex = new BlockedMutex();
    @Override
    public void run() {
        System.out.println(MyUtils.getCurrentTime() +"Waiting f() in BlockedMutex");
        blockedMutex.f();
        System.out.println(MyUtils.getCurrentTime() +"Broken out of blocked call");
    }
}

public class Interrupting2 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Blocked2());
        thread.start();
        Thread.sleep(1000);
        System.out.println(MyUtils.getCurrentTime() +"Issuing thread.interrupt()");
        thread.interrupt();
    }
//2017-12-21 10:35:57:890  Waiting f() in BlockedMutex
//2017-12-21 10:35:58:819  Issuing thread.interrupt()
//2017-12-21 10:35:58:819  Interrupted from aquisition lock in BlockedMutex.f
//2017-12-21 10:35:58:819  Broken out of blocked call
//
//Process finished with exit code 0
}
