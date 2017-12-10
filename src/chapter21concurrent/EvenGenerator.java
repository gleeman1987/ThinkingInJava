package chapter21concurrent;

/**
 * Author:Zheng Jun
 * E-mail:zhengjun1987@outlook.com
 * Date:2017/12/9
 * Project:ThinkingInJava
 */
public class EvenGenerator extends IntGenerator {
    private int currentValue = 0;
    @Override
    public int next() {
        ++currentValue;
        ++currentValue;
        return currentValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
