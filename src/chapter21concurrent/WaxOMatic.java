package chapter21concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/12/22
 * Mail:zhengjun1987@outlook.com
 */
class Car {
    private boolean waxOn = false;
    public synchronized void waxOn(){
        waxOn = true;
        notifyAll();
    }

    public synchronized void buff(){
        waxOn= false;
        notifyAll();
    }

    public synchronized void waitingForWax() throws InterruptedException {
        while (!waxOn) {
            wait();
        }
    }

    public synchronized void waitingForBuff() throws InterruptedException {
        while (waxOn) {
            wait();
        }
    }
}

class WaxOn implements Runnable {
    private Car car;

    public WaxOn(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println(MyUtils.getCurrentTime() +"Wax On!");
                Thread.sleep(200);
                car.waxOn();
                car.waitingForBuff();
            }
        } catch (InterruptedException e) {
            System.out.println(MyUtils.getCurrentTime() +"Exiting from InterruptedException");
        }
        System.out.println(MyUtils.getCurrentTime() +"Ending wax on task");
    }
}
class WaxOff implements Runnable {
    private Car car;

    public WaxOff(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                car.waitingForWax();
                System.out.println(MyUtils.getCurrentTime() +"Wax Off!");
                Thread.sleep(200);
                car.buff();
            }
        } catch (InterruptedException e) {
            System.out.println(MyUtils.getCurrentTime() +"Exiting from InterruptedException");
        }
        System.out.println(MyUtils.getCurrentTime() +"Ending wax off task");
    }
}

public class WaxOMatic {
    public static void main(String[] args) throws InterruptedException {
        Car car = new Car();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new WaxOff(car));
        executorService.execute(new WaxOn(car));
        Thread.sleep(1000);
        executorService.shutdownNow();
    }
//2017-12-22 15:07:27:454  Wax On!
//2017-12-22 15:07:27:655  Wax Off!
//2017-12-22 15:07:27:856  Wax On!
//2017-12-22 15:07:28:056  Wax Off!
//2017-12-22 15:07:28:256  Wax On!
//2017-12-22 15:07:28:399  Exiting from InterruptedException
//2017-12-22 15:07:28:399  Exiting from InterruptedException
//2017-12-22 15:07:28:400  Ending wax on task
//2017-12-22 15:07:28:400  Ending wax off task
//
//Process finished with exit code 0
}
