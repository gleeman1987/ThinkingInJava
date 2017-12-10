package chapter21concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author:Zheng Jun
 * E-mail:zhengjun1987@outlook.com
 * Date:2017/12/10
 * Project:ThinkingInJava
 */
public class AttemptLocking {
    private ReentrantLock lock = new ReentrantLock();
    public void untimed(){
        System.out.println(MyUtils.getCurrentTime() + "AttemptLocking.untimed  " + "上锁之前lock.isLocked() = " + lock.isLocked());
        boolean tryLock = lock.tryLock();
        try {
            System.out.println(MyUtils.getCurrentTime() + "AttemptLocking.untimed  " + "上锁tryLock = " + tryLock);
        } finally {
            if (tryLock) {
                lock.unlock();
                System.out.println(MyUtils.getCurrentTime() + "AttemptLocking.untimed  " + "解锁lock.isLocked() = " + lock.isLocked());
            }
        }
    }

    public void timed(){
        boolean captured = false;
        try {
            System.out.println(MyUtils.getCurrentTime() + "AttemptLocking.timed  " + "上锁之前lock.isLocked() = " + lock.isLocked());
            captured = lock.tryLock(2, TimeUnit.SECONDS);//此方法的意思是在2秒时间内试图获取锁的控制权
        } catch (InterruptedException e) {
            System.out.println(MyUtils.getCurrentTime() + "上锁出错时上锁方法的返回值 captured = " + captured);
            throw new RuntimeException(e);
        }

        try {
            System.out.println(MyUtils.getCurrentTime() + "上锁tryLock(2, TimeUnit.SECONDS) captured = " + captured);
        } finally {
            if (captured) {
                lock.unlock();
                System.out.println(MyUtils.getCurrentTime() + "解锁tryLock(2, TimeUnit.SECONDS) lock.isLocked() = " + lock.isLocked());
            }
        }
    }

    public static void main(String[] args) {
        AttemptLocking attemptLocking = new AttemptLocking();
        attemptLocking.untimed();
        attemptLocking.timed();

        new Thread(){
            {
                System.out.println(MyUtils.getCurrentTime() + "AttemptLocking.instance initializer  " + "this = [" + this + "]");
                setDaemon(true);
            }

            @Override
            public void run() {
                attemptLocking.lock.lock();
                System.out.println(MyUtils.getCurrentTime() +"acquired");

                //子线程在适当时机释放锁之后，其他步骤才有权限获取锁的控制权
//                try {
//                    Thread.sleep(1500);
//                    attemptLocking.lock.unlock();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }.start();
        Thread.yield();
        attemptLocking.untimed();
        attemptLocking.timed();

        System.out.println(MyUtils.getCurrentTime() + "Integer.SIZE = " + Integer.SIZE);
        System.out.println(MyUtils.getCurrentTime() + "Integer.BYTES = " + Integer.BYTES);
//        2017-12-10 18:49:13:720  Integer.SIZE = 32
//        2017-12-10 18:49:13:720  Integer.BYTES = 4
        System.out.println(MyUtils.getCurrentTime() + "Long.SIZE = " + Long.SIZE);
        System.out.println(MyUtils.getCurrentTime() + "Long.BYTES = " + Long.BYTES);
//        2017-12-10 18:49:13:721  Long.SIZE = 64
//        2017-12-10 18:49:13:721  Long.BYTES = 8
        System.out.println(MyUtils.getCurrentTime() + "Short.SIZE = " + Short.SIZE);
        System.out.println(MyUtils.getCurrentTime() + "Short.BYTES = " + Short.BYTES);
//        2017-12-10 18:49:13:721  Short.SIZE = 16
//        2017-12-10 18:49:13:721  Short.BYTES = 2
        System.out.println(MyUtils.getCurrentTime() + "Byte.SIZE = " + Byte.SIZE);
        System.out.println(MyUtils.getCurrentTime() + "Byte.BYTES = " + Byte.BYTES);
//        2017-12-10 18:49:13:722  Byte.SIZE = 8
//        2017-12-10 18:49:13:722  Byte.BYTES = 1
        System.out.println(MyUtils.getCurrentTime() + "Double.SIZE = " + Double.SIZE);
        System.out.println(MyUtils.getCurrentTime() + "Double.BYTES = " + Double.BYTES);
//        2017-12-10 18:49:13:722  Double.SIZE = 64
//        2017-12-10 18:49:13:722  Double.BYTES = 8
        System.out.println(MyUtils.getCurrentTime() + "Float.SIZE = " + Float.SIZE);
        System.out.println(MyUtils.getCurrentTime() + "Float.BYTES = " + Float.BYTES);
//        2017-12-10 18:49:13:722  Float.SIZE = 32
//        2017-12-10 18:49:13:723  Float.BYTES = 4
        System.out.println(MyUtils.getCurrentTime() + "Character.SIZE = " + Character.SIZE);
        System.out.println(MyUtils.getCurrentTime() + "Character.BYTES = " + Character.BYTES);
//        2017-12-10 19:15:35:114  Character.SIZE = 16
//        2017-12-10 19:15:35:114  Character.BYTES = 2
    }
//            2017-12-10 18:10:06:415  AttemptLocking.untimed  上锁之前lock.isLocked() = false
//            2017-12-10 18:10:06:417  AttemptLocking.untimed  上锁tryLock = true
//            2017-12-10 18:10:06:417  AttemptLocking.untimed  解锁lock.isLocked() = false
//            2017-12-10 18:10:06:418  AttemptLocking.timed  上锁之前lock.isLocked() = false
//            2017-12-10 18:10:06:420  上锁tryLock(2, TimeUnit.SECONDS) captured = true//用不到两秒时间，轻而易举地获取到了该锁的控制权
//            2017-12-10 18:10:06:420  解锁tryLock(2, TimeUnit.SECONDS) lock.isLocked() = false
//            2017-12-10 18:10:06:422  AttemptLocking.instance initializer  this = [Thread[Thread-0,5,main]]
//            2017-12-10 18:10:06:423  acquired...//新线程获取了锁的控制权，一直未释放
//            2017-12-10 18:10:06:425  AttemptLocking.untimed  上锁之前lock.isLocked() = true
//            2017-12-10 18:10:06:425  AttemptLocking.untimed  上锁tryLock = false
//            2017-12-10 18:10:06:426  AttemptLocking.timed  上锁之前lock.isLocked() = true
//            2017-12-10 18:10:08:431  上锁tryLock(2, TimeUnit.SECONDS) captured = false//两秒时间到，未能获取到该锁的控制权
//
//            Process finished with exit code 0
}
