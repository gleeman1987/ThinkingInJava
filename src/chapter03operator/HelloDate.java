package chapter03operator;

import java.util.Date;
import java.util.Locale;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/23
 * Mail:zhengjun1987@outlook.com
 */
public class HelloDate {
    public static void main(String[] args) {
        System.out.println("Hello,it is "+new Date());
//        Hello,it is Mon Oct 23 10:30:48 CST 2017


//        Locale[] availableLocales = Locale.getAvailableLocales();
//        for (Locale availableLocale : availableLocales) {
//            System.out.println(availableLocale);
//        }

        String zh = new Date().toString();
        System.out.println("Hello,it is "+ zh);
    }
}
