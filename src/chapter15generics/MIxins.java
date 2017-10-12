package chapter15generics;


import java.util.Date;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/12
 * Mail:zhengjun1987@outlook.com
 */
interface TimeStamped {
    long getStamp();
}

class TimeStampImpl implements TimeStamped{

    private final long stamp;

    public TimeStampImpl() {
        stamp = new Date().getTime();
    }

    @Override
    public long getStamp() {
        return stamp;
    }
}

interface SerialNumbered { long getSerialNumber(); }

class SerialNumberedImpl implements SerialNumbered {
    private static long counter = 1;
    private final long serialNumber = counter++;
    @Override
    public long getSerialNumber() {
        return serialNumber;
    }
}

interface Basic {
    public void set(String val);
    public String get();
}

class BasicImpl implements Basic {
    private String val;
    @Override
    public void set(String val) {
        this.val = val;
    }

    @Override
    public String get() {
        return val;
    }
}

class Mixin extends BasicImpl implements TimeStamped,SerialNumbered{
    private TimeStamped timeStamped = new TimeStampImpl();
    private SerialNumbered serialNumbered = new SerialNumberedImpl();
    @Override
    public long getStamp() {
        return timeStamped.getStamp();
    }

    @Override
    public long getSerialNumber() {
        return serialNumbered.getSerialNumber();
    }
}
public class MIxins {
    public static void main(String[] args) {
        Mixin mixin1 = new Mixin(),mixin2 = new Mixin();
        mixin1.set("测试字符串1");
        mixin2.set("测试字符串2");
        System.out.println(mixin1.get() +"  "+mixin1.getSerialNumber()+"  "+mixin1.getStamp());
        System.out.println(mixin2.get() +"  "+mixin2.getSerialNumber()+"  "+mixin2.getStamp());
    }
}
