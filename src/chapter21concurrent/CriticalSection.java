package chapter21concurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
        if (x != y) {
            throw new PairNotEqualException();
        }
    }
}

abstract class PairManager {
    AtomicInteger checkCounter = new AtomicInteger(0);
    protected Pair pair = new Pair();
    private List<Pair> storage = Collections.synchronizedList(new ArrayList<>());

    public Pair getPair() {
        return new Pair(pair.getX(),pair.getY());
    }

    public void storePair(Pair p){
        storage.add(p);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public abstract void increment();
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

public class CriticalSection {
}
