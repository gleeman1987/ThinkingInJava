package chapter10innerclass.controller;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/7/6.
 */
public abstract class Event {
    private long eventTime;
    protected final long delayTime;

    protected Event(int delayTime) {
        this.delayTime = delayTime;
        start();
    }

    public void start(){
        eventTime = System.nanoTime()+delayTime;
    }

    public boolean ready(){
        return  System.nanoTime() >= eventTime;
    }

    public abstract void action();
}
