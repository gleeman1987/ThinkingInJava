package chapter21concurrent;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/12/8
 * Mail:zhengjun1987@outlook.com
 */
public class SelfManaged implements Runnable {
    private int countdown = 5;
    private Thread thread = new Thread(this);

    public SelfManaged() {
        System.out.println(MyUtils.getCurrentTime() + "SelfManaged.<init>  " + "");
        thread.start();
    }

    @Override
    public String toString() {
        return Thread.currentThread().getName()+"("+countdown+")";
    }

    @Override
    public void run() {
        System.out.println(MyUtils.getCurrentTime() + "SelfManaged.run  " + "");
        while (true){
            System.out.println(MyUtils.getCurrentTime() +this);
            if (countdown--==0) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            new SelfManaged();
        }
    }
//2017-12-08 10:29:24:984  SelfManaged.<init>
//2017-12-08 10:29:24:992  SelfManaged.<init>
//2017-12-08 10:29:24:992  SelfManaged.run
//2017-12-08 10:29:24:992  SelfManaged.<init>
//2017-12-08 10:29:24:992  Thread-0(5)
//            2017-12-08 10:29:24:992  SelfManaged.<init>
//2017-12-08 10:29:24:992  SelfManaged.run
//2017-12-08 10:29:24:992  SelfManaged.<init>
//2017-12-08 10:29:24:992  Thread-0(4)
//            2017-12-08 10:29:24:993  SelfManaged.run
//2017-12-08 10:29:24:993  SelfManaged.run
//2017-12-08 10:29:24:993  Thread-0(3)
//            2017-12-08 10:29:24:993  SelfManaged.<init>
//2017-12-08 10:29:24:993  Thread-0(2)
//            2017-12-08 10:29:24:993  SelfManaged.run
//2017-12-08 10:29:24:993  SelfManaged.run
//2017-12-08 10:29:24:993  Thread-1(5)
//            2017-12-08 10:29:24:994  Thread-5(5)
//            2017-12-08 10:29:24:994  Thread-1(4)
//            2017-12-08 10:29:24:994  Thread-3(5)
//            2017-12-08 10:29:24:994  Thread-0(1)
//            2017-12-08 10:29:24:994  Thread-4(5)
//            2017-12-08 10:29:24:994  Thread-2(5)
//            2017-12-08 10:29:24:994  Thread-4(4)
//            2017-12-08 10:29:24:994  Thread-0(0)
//            2017-12-08 10:29:24:994  Thread-3(4)
//            2017-12-08 10:29:24:995  Thread-1(3)
//            2017-12-08 10:29:24:995  Thread-5(4)
//            2017-12-08 10:29:24:995  Thread-1(2)
//            2017-12-08 10:29:24:995  Thread-3(3)
//            2017-12-08 10:29:24:995  Thread-4(3)
//            2017-12-08 10:29:24:995  Thread-2(4)
//            2017-12-08 10:29:24:995  Thread-4(2)
//            2017-12-08 10:29:24:995  Thread-3(2)
//            2017-12-08 10:29:24:995  Thread-1(1)
//            2017-12-08 10:29:24:995  Thread-5(3)
//            2017-12-08 10:29:24:996  Thread-1(0)
//            2017-12-08 10:29:24:996  Thread-3(1)
//            2017-12-08 10:29:24:996  Thread-3(0)
//            2017-12-08 10:29:24:996  Thread-4(1)
//            2017-12-08 10:29:24:996  Thread-4(0)
//            2017-12-08 10:29:24:996  Thread-2(3)
//            2017-12-08 10:29:24:996  Thread-5(2)
//            2017-12-08 10:29:24:996  Thread-2(2)
//            2017-12-08 10:29:24:996  Thread-5(1)
//            2017-12-08 10:29:24:997  Thread-2(1)
//            2017-12-08 10:29:24:997  Thread-5(0)
//            2017-12-08 10:29:24:997  Thread-2(0)
//
//    Process finished with exit code 0
}
