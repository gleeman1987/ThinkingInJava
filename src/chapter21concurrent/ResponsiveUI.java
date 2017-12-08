package chapter21concurrent;

import java.io.IOException;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/12/8
 * Mail:zhengjun1987@outlook.com
 */
public class ResponsiveUI extends Thread {
    private volatile static double d = 1;

    public ResponsiveUI() {
        setDaemon(true);
        start();
    }

    @Override
    public void run() {
        while (d > 0){
            d = d + (Math.E+Math.PI)/d;
        }
    }

    public static void main(String[] args) throws IOException {
        new ResponsiveUI();
        int read = System.in.read();
        System.out.println(MyUtils.getCurrentTime() + "read = " + read);
        System.out.println(MyUtils.getCurrentTime() +d);
    }
}

class UnResponsiveUI {
    private volatile double d = 1;

    public UnResponsiveUI() throws IOException {
        while (d > 0){
            d = d + (Math.PI + Math.E)/d;
        }
        System.in.read();
    }

//    2017-12-08 16:39:54:886  read = 10
//    2017-12-08 16:39:54:887  46377.50095082564
//
//    Process finished with exit code 0
}
