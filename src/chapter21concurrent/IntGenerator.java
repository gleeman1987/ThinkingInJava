package chapter21concurrent;

/**
 * Author:Zheng Jun
 * E-mail:zhengjun1987@outlook.com
 * Date:2017/12/9
 * Project:ThinkingInJava
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;
    public abstract int next();

    public boolean isCanceled() {
        return canceled;
    }

    public void cancel(){
        canceled = true;
    }
}
