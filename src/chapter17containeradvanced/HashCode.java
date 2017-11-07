package chapter17containeradvanced;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/2
 * Mail:zhengjun1987@outlook.com
 */
public class HashCode {
    public static void main(String[] args) {
        String[] strings = "Hello Hello".split(" ");
        for (String string : strings) {
            System.out.println("string.hashCode() = " + string.hashCode());
        }
//        string.hashCode() = 69609650
//        string.hashCode() = 69609650
    }
}
