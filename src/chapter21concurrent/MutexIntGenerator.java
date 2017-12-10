package chapter21concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author:Zheng Jun
 * E-mail:zhengjun1987@outlook.com
 * Date:2017/12/9
 * Project:ThinkingInJava
 */
public class MutexIntGenerator extends IntGenerator {
    private int currentValue;
    private Lock lock = new ReentrantLock();
    @Override
    public int next() {
        lock.lock();
        try {
            currentValue++;
            Thread.yield();
            currentValue++;
            return currentValue;
        } finally {
            lock.unlock();
            //显式的Lock对象的创建、锁定、解锁。相对于synchronized关键字而言，缺乏优雅，但更具有灵活性，可以用来解决特定问题
        }
    }

    public static void main(String[] args) {
        EvenChecker.test(new MutexIntGenerator());
    }
}
