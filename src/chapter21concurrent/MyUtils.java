package chapter21concurrent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/12/7
 * Mail:zhengjun1987@outlook.com
 */
public class MyUtils {
    public static synchronized String getCurrentTime(){
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date());
        return format + "  ";
    }

    public static void main(String[] args) {
        System.out.println(getCurrentTime());
    }
}
