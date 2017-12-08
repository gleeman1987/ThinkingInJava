package chapter21concurrent;

public class ThreadVariations {
    public static void main(String[] args) {
        new InnerThread1("InnerThread1");
        new InnerThread2("InnerThread2");
        new InnerRunnable1("InnerRunnable1");
        new InnerRunnable2("InnerRunnable2");
        new ThreadMethod("ThreadMethod").runTask();
    }
//2017-12-08 15:15:35:568  InnerThread1(5)
//2017-12-08 15:15:35:568  ThreadMethod(5)
//2017-12-08 15:15:35:568  InnerRunnable2(5)
//2017-12-08 15:15:35:568  InnerRunnable1(5)
//2017-12-08 15:15:35:568  InnerThread2(5)
//2017-12-08 15:15:35:677  InnerRunnable2(4)
//2017-12-08 15:15:35:677  ThreadMethod(4)
//2017-12-08 15:15:35:677  InnerThread1(4)
//2017-12-08 15:15:35:677  InnerThread2(4)
//2017-12-08 15:15:35:677  InnerRunnable1(4)
//2017-12-08 15:15:35:784  InnerRunnable1(3)
//2017-12-08 15:15:35:784  InnerThread2(3)
//2017-12-08 15:15:35:784  InnerRunnable2(3)
//2017-12-08 15:15:35:784  ThreadMethod(3)
//2017-12-08 15:15:35:784  InnerThread1(3)
//2017-12-08 15:15:35:885  InnerRunnable2(2)
//2017-12-08 15:15:35:885  InnerRunnable1(2)
//2017-12-08 15:15:35:885  ThreadMethod(2)
//2017-12-08 15:15:35:885  InnerThread1(2)
//2017-12-08 15:15:35:885  InnerThread2(2)
//2017-12-08 15:15:35:995  InnerThread2(1)
//2017-12-08 15:15:35:995  InnerRunnable2(1)
//2017-12-08 15:15:35:995  InnerRunnable1(1)
//2017-12-08 15:15:35:995  ThreadMethod(1)
//2017-12-08 15:15:35:995  InnerThread1(1)
//2017-12-08 15:15:36:104  InnerThread1(0)
//2017-12-08 15:15:36:104  InnerThread2(0)
//2017-12-08 15:15:36:104  InnerRunnable2(0)
//2017-12-08 15:15:36:104  InnerRunnable1(0)
//2017-12-08 15:15:36:104  ThreadMethod(0)

}
