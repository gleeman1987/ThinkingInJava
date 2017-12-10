package chapter21concurrent;

/**
 * Author:Zheng Jun
 * E-mail:zhengjun1987@outlook.com
 * Date:2017/12/9
 * Project:ThinkingInJava
 */
public class SychronizedEvenGenerator extends IntGenerator {
    private int currentValue = 0;
    @Override
    public synchronized int next() {
        currentValue++;
        Thread.yield();
        currentValue++;
        return currentValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new SychronizedEvenGenerator());
    }
}
