package chapter15generics;

import java.util.Date;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/12
 * Mail:zhengjun1987@outlook.com
 */
class Basica {
    private String val;

    public void set(String val) {
        this.val = val;
    }

    public String get() {
        return val;
    }
}

class Decorator extends Basica {
    protected Basica basica;

    public Decorator(Basica basica) {
        this.basica = basica;
    }

    @Override
    public String get() {
        return basica.get();
    }

    @Override
    public void set(String val) {
        basica.set(val);
    }
}

class TimeStampeda extends Decorator {
    private final long timeStamp;

    public TimeStampeda(Basica basica) {
        super(basica);
        timeStamp = new Date().getTime();
    }

    public long getTimeStamp() {
        return timeStamp;
    }
}

class SerialNumbereda extends Decorator{
    private static long counter = 1;
    private final long serialNumber = counter++;

    public long getSerialNumber() {
        return serialNumber;
    }

    public SerialNumbereda(Basica basica) {
        super(basica);
    }
}

public class Decoration {
    public static void main(String[] args) {
        TimeStampeda timeStampeda = new TimeStampeda(new Basica());
        TimeStampeda timeStampeda1 = new TimeStampeda(new SerialNumbereda(new Basica()));
        long timeStamp = timeStampeda1.getTimeStamp();
        System.out.println("timeStamp = " + timeStamp);
        if (timeStampeda1.basica instanceof SerialNumbereda) {
            SerialNumbereda stampeda1 = (SerialNumbereda) timeStampeda1.basica;
            System.out.println("stampeda1 = " + stampeda1.getSerialNumber());
        }
    }
}
