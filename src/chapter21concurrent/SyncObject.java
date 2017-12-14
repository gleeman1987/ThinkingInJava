package chapter21concurrent;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/12/14
 * Mail:zhengjun1987@outlook.com
 */
class DualSynch {
    private Object object = new Object();

    public synchronized void f() {
        for (int i = 0; i < 5; i++) {
            System.out.println(MyUtils.getCurrentTime() + "DualSynch.f  " + "");
            Thread.yield();
        }
    }

    public void g() {
        synchronized (object) {
            for (int i = 0; i < 5; i++) {
                System.out.println(MyUtils.getCurrentTime() + "DualSynch.g  " + "");
                Thread.yield();
            }
        }
    }
}

public class SyncObject {
    public static void main(String[] args) {
        DualSynch dualSynch = new DualSynch();
        new Thread() {
            @Override
            public void run() {
                dualSynch.f();
            }
        }.start();
        dualSynch.g();
    }
//2017-12-14 10:16:48:535  DualSynch.g
//2017-12-14 10:16:48:551  DualSynch.f
//2017-12-14 10:16:48:551  DualSynch.g
//2017-12-14 10:16:48:551  DualSynch.f
//2017-12-14 10:16:48:551  DualSynch.g
//2017-12-14 10:16:48:551  DualSynch.f
//2017-12-14 10:16:48:567  DualSynch.g
//2017-12-14 10:16:48:567  DualSynch.f
//2017-12-14 10:16:48:567  DualSynch.g
//2017-12-14 10:16:48:567  DualSynch.f

//改写f(),使用与g()相同的异步对象object,运行结果如下:
//    public void f(){
//        synchronized (object) {
//            for (int i = 0; i < 5; i++) {
//                System.out.println(MyUtils.getCurrentTime() + "DualSynch.f  " + "");
//                Thread.yield();
//            }
//        }
//    }
//2017-12-14 10:25:30:378  DualSynch.g
//2017-12-14 10:25:30:393  DualSynch.g
//2017-12-14 10:25:30:393  DualSynch.g
//2017-12-14 10:25:30:393  DualSynch.g
//2017-12-14 10:25:30:393  DualSynch.g
//2017-12-14 10:25:30:409  DualSynch.f
//2017-12-14 10:25:30:409  DualSynch.f
//2017-12-14 10:25:30:425  DualSynch.f
//2017-12-14 10:25:30:425  DualSynch.f
//2017-12-14 10:25:30:456  DualSynch.f
//
//    Process finished with exit code 0


    //改写g(),使用与f()相同的方法修饰符synchronized,运行结果如下:
//    public synchronized void g(){
//        for (int i = 0; i < 5; i++) {
//            System.out.println(MyUtils.getCurrentTime() + "DualSynch.g  " + "");
//            Thread.yield();
//        }
//    }
//2017-12-14 10:37:07:803  DualSynch.g
//2017-12-14 10:37:07:803  DualSynch.g
//2017-12-14 10:37:07:803  DualSynch.g
//2017-12-14 10:37:07:803  DualSynch.g
//2017-12-14 10:37:07:803  DualSynch.g
//2017-12-14 10:37:07:803  DualSynch.f
//2017-12-14 10:37:07:803  DualSynch.f
//2017-12-14 10:37:07:803  DualSynch.f
//2017-12-14 10:37:07:803  DualSynch.f
//2017-12-14 10:37:07:803  DualSynch.f
//
//    Process finished with exit code 0
}
