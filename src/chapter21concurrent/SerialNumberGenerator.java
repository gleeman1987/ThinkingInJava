package chapter21concurrent;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/12/11
 * Mail:zhengjun1987@outlook.com
 */
public class SerialNumberGenerator {
    public volatile static int serialNumber = 0;

    public synchronized static int getSerialNumber() {
        serialNumber++;
        System.out.println(MyUtils.getCurrentTime()+Thread.currentThread().getName() + "  serialNumber = " + serialNumber);
        return serialNumber;
    }
}
