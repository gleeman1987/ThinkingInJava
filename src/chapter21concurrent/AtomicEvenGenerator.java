package chapter21concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/12/11
 * Mail:zhengjun1987@outlook.com
 */
public class AtomicEvenGenerator extends IntGenerator {
    private AtomicInteger currentValue = new AtomicInteger(0);
    @Override
    public int next() {
        return currentValue.addAndGet(2);
    }

    public static void main(String[] args) {
        EvenChecker.test(new AtomicEvenGenerator());
    }
}
