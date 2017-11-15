package chapter02oop;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/15
 * Mail:zhengjun1987@outlook.com
 */
public class ShowProperties {
    public static void main(String[] args) {
        System.getProperties().list(System.out);
        System.out.println("System.getProperty(\"user.name\") = " + System.getProperty("user.name"));
//        System.getProperty("user.name") = zhengjun
    }
}
