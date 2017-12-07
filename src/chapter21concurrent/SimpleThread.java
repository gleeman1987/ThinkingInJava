package chapter21concurrent;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/12/7
 * Mail:zhengjun1987@outlook.com
 */
public class SimpleThread extends Thread {
    private int countdown = 5;
    private static int threadCount = 0;

    public SimpleThread() {
        super(Integer.toString(threadCount++));
        start();
    }

    @Override
    public String toString() {
        return "#"+getName()+"("+countdown+")";
    }

    @Override
    public void run() {
        while (true){
            System.out.println(MyUtils.getCurrentTime() +this);
            if (--countdown==0) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new SimpleThread();
        }
    }
//        2017-12-07 17:07:26:268  #0(5)
//        2017-12-07 17:07:26:269  #4(5)
//        2017-12-07 17:07:26:269  #3(5)
//        2017-12-07 17:07:26:269  #2(5)
//        2017-12-07 17:07:26:269  #2(4)
//        2017-12-07 17:07:26:269  #2(3)
//        2017-12-07 17:07:26:270  #1(5)
//        2017-12-07 17:07:26:270  #1(4)
//        2017-12-07 17:07:26:270  #1(3)
//        2017-12-07 17:07:26:270  #1(2)
//        2017-12-07 17:07:26:270  #2(2)
//        2017-12-07 17:07:26:270  #3(4)
//        2017-12-07 17:07:26:270  #4(4)
//        2017-12-07 17:07:26:271  #0(4)
//        2017-12-07 17:07:26:271  #0(3)
//        2017-12-07 17:07:26:271  #0(2)
//        2017-12-07 17:07:26:271  #0(1)
//        2017-12-07 17:07:26:271  #3(3)
//        2017-12-07 17:07:26:271  #4(3)
//        2017-12-07 17:07:26:272  #2(1)
//        2017-12-07 17:07:26:272  #4(2)
//        2017-12-07 17:07:26:272  #1(1)
//        2017-12-07 17:07:26:272  #4(1)
//        2017-12-07 17:07:26:272  #3(2)
//        2017-12-07 17:07:26:272  #3(1)
}
