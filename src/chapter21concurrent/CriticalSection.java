package chapter21concurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/12/11
 * Mail:zhengjun1987@outlook.com
 */
class Pair {
    int x,y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pair() {
        this(0,0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void incrementX(){x++;}
    public void incrementY(){y++;}

    @Override
    public String toString() {
        return "Pair{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public class PairNotEqualException extends RuntimeException {
        public PairNotEqualException() {
            super("Pair values not equal : "+Pair.this);
        }
    }

    public void checkState(){
        System.out.println(MyUtils.getCurrentTime() + "Pair.checkState  " + Pair.this);
        if (x != y) {
            throw new PairNotEqualException();
        }
    }
}

abstract class PairManager {
    AtomicInteger checkCounter = new AtomicInteger(0);
    protected Pair pair = new Pair();
    private List<Pair> storage = Collections.synchronizedList(new ArrayList<>());

    public synchronized Pair getPair() {
        return new Pair(pair.getX(),pair.getY());
    }

    public void storePair(Pair p){
//        System.out.println(MyUtils.getCurrentTime() + "PairManager.storePair  " + "p = [" + p + "]");
        storage.add(p);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public abstract void increment();

    @Override
    public String toString() {
        return pair.toString() + " checkCounter:"+checkCounter;
    }
}

class PairManager1 extends PairManager {
    @Override
    public synchronized void increment() {
        pair.incrementX();
        pair.incrementY();
        storePair(getPair());
    }
}

class PairManager2 extends PairManager {
    @Override
    public void increment() {
        Pair temp;
        synchronized (PairManager2.this) {
            pair.incrementX();
            pair.incrementY();
            temp = getPair();
        }
        storePair(temp);
    }
}

class PairManipulator implements Runnable {
    private PairManager pairManager;

    public PairManipulator(PairManager pairManager) {
        this.pairManager = pairManager;
    }

    @Override
    public void run() {
        while (true){
            pairManager.increment();
        }
    }

    @Override
    public String toString() {
        return "Pair:"+pairManager.getPair()+"  checkCounter:"+pairManager.checkCounter.get();
    }
}

class PairChecker implements Runnable {
    private PairManager pairManager;

    public PairChecker(PairManager pairManager) {
        this.pairManager = pairManager;
    }

    @Override
    public void run() {
        while (true) {
            pairManager.checkCounter.incrementAndGet();
            pairManager.getPair().checkState();
//            try {
//                Thread.sleep(15);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}

public class CriticalSection {
    static void testApproaches(PairManager pairManager1,PairManager pairManager2){
        ExecutorService executorService = Executors.newCachedThreadPool();
        PairManipulator manipulator1 = new PairManipulator(pairManager1),manipulator2 = new PairManipulator(pairManager2);
        PairChecker pairChecker1 = new PairChecker(pairManager1),pairChecker2 = new PairChecker(pairManager2);
        executorService.execute(manipulator1);
        executorService.execute(manipulator2);
        executorService.execute(pairChecker1);
        executorService.execute(pairChecker2);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(MyUtils.getCurrentTime() + "CriticalSection.testApproaches  " + "pairManager1 = [" + pairManager1 + "], pairManager2 = [" + pairManager2 + "]");
        System.exit(0);
    }

    public static void main(String[] args) {
        testApproaches(new PairManager1(),new PairManager2());
    }
}
