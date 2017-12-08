package chapter21concurrent;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/12/8
 * Mail:zhengjun1987@outlook.com
 */
class Sleeper extends Thread {
    private int duration;

    public Sleeper(String name, int duration) {
        super(name);
        this.duration = duration;
        System.out.println(MyUtils.getCurrentTime() + "Sleeper.<init>  " + "name = [" + name + "], duration = [" + duration + "]");
        start();
    }

    @Override
    public void run() {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            System.out.println(MyUtils.getCurrentTime() +getName()+" interrupted:"+isInterrupted());
            return;
        }
        System.out.println(MyUtils.getCurrentTime() +getName()+" has awakened");
    }
}

class Joiner extends Thread {
    private Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            System.out.println(MyUtils.getCurrentTime() +"Interrupted!");
        }
        System.out.println(MyUtils.getCurrentTime() +getName()+" join completed");
    }
}

public class Joining {
    public static void main(String[] args) {
        Sleeper sleepy = new Sleeper("sleepy",1000);
        Sleeper grumpy = new Sleeper("grumpy",2000);
        Joiner dopey = new Joiner("Dopey", sleepy);
        Joiner doc = new Joiner("Doc", grumpy);
        grumpy.interrupt();
//        2017-12-08 15:52:44:533  Sleeper.<init>  name = [sleepy], duration = [1000]
//        2017-12-08 15:52:44:533  Sleeper.<init>  name = [grumpy], duration = [2000]
//        2017-12-08 15:52:44:549  grumpy interrupted:false
//        2017-12-08 15:52:44:549  Doc join completed
//        2017-12-08 15:52:45:536  sleepy has awakened
//        2017-12-08 15:52:45:536  Dopey join completed
//
//        Process finished with exit code 0
    }
}
