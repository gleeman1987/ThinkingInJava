package chapter21concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/12/13
 * Mail:zhengjun1987@outlook.com
 */
class ExplicitPairManager1 extends PairManager {
    private Lock lock = new ReentrantLock();
    @Override
    public void increment() {
        lock.lock();
        try {
            pair.incrementX();
            pair.incrementY();
            storePair(getPair());
        } finally {
            lock.unlock();
        }
    }
}

class ExplicitPairManager2 extends PairManager {
    private Lock lock = new ReentrantLock();
    @Override
    public void increment() {
        Pair temp;
        lock.lock();
        try {
            pair.incrementX();
            pair.incrementY();
            temp = getPair();
        } finally {
            lock.unlock();
        }
        storePair(temp);

    }
}
public class ExplicitCriticalSection {
    public static void main(String[] args) {
        PairManager pairManager1 = new ExplicitPairManager1(),pairManager2 = new ExplicitPairManager2();
        CriticalSection.testApproaches(pairManager1,pairManager2);
    }
}
