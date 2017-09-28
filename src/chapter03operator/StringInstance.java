package chapter03operator;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/1/8.
 */
public class StringInstance {
    public static void main(String[] args) {
        String abcd = "abcd";
        String abcd1 = new String("abcd");
        System.out.println(abcd == abcd1);
        System.out.println(abcd.equals(abcd1));
        int maxValue = Integer.MAX_VALUE;
        System.out.println(4*maxValue);
        boolean b = true;
        boolean b1 = false;
        System.out.println(b&b1);
    }
}
