package chapter21concurrent;

/**
 * Author:Zheng Jun
 * E-mail:zhengjun1987@outlook.com
 * Date:2017/12/19
 * Project:ThinkingInJava
 */
public class MultiLock {
    public synchronized void f1(int count){
        if (count-- > 0) {
            System.out.println(MyUtils.getCurrentTime() + Thread.currentThread().getName() +" f1 call f2 with count "+count);
            f2(count);
        }
    }

    private synchronized void f2(int count) {
        if (count-- > 0) {
            System.out.println(MyUtils.getCurrentTime() + Thread.currentThread().getName() +" f2 call f1 with count "+count);
            f1(count);
        }
    }

    public static void main(String[] args) {
        MultiLock multiLock = new MultiLock();
        new Thread(){
            @Override
            public void run() {
                multiLock.f1(10);
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                multiLock.f1(10);
            }
        }.start();
    }
//            2017-12-19 18:16:23:604  Thread-0 f1 call f2 with count 9
//            2017-12-19 18:16:23:605  Thread-0 f2 call f1 with count 8
//            2017-12-19 18:16:23:605  Thread-0 f1 call f2 with count 7
//            2017-12-19 18:16:23:605  Thread-0 f2 call f1 with count 6
//            2017-12-19 18:16:23:606  Thread-0 f1 call f2 with count 5
//            2017-12-19 18:16:23:606  Thread-0 f2 call f1 with count 4
//            2017-12-19 18:16:23:606  Thread-0 f1 call f2 with count 3
//            2017-12-19 18:16:23:606  Thread-0 f2 call f1 with count 2
//            2017-12-19 18:16:23:607  Thread-0 f1 call f2 with count 1
//            2017-12-19 18:16:23:607  Thread-0 f2 call f1 with count 0
//            2017-12-19 18:16:23:607  Thread-1 f1 call f2 with count 9
//            2017-12-19 18:16:23:607  Thread-1 f2 call f1 with count 8
//            2017-12-19 18:16:23:608  Thread-1 f1 call f2 with count 7
//            2017-12-19 18:16:23:608  Thread-1 f2 call f1 with count 6
//            2017-12-19 18:16:23:608  Thread-1 f1 call f2 with count 5
//            2017-12-19 18:16:23:608  Thread-1 f2 call f1 with count 4
//            2017-12-19 18:16:23:609  Thread-1 f1 call f2 with count 3
//            2017-12-19 18:16:23:609  Thread-1 f2 call f1 with count 2
//            2017-12-19 18:16:23:609  Thread-1 f1 call f2 with count 1
//            2017-12-19 18:16:23:609  Thread-1 f2 call f1 with count 0
//
//            Process finished with exit code 0
}
