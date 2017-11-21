package chapter04routine;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/21
 * Mail:zhengjun1987@outlook.com
 */
public class ForEachString {
    public static void main(String[] args) {
        for (String s : "An African Swallow".split("")) {
            System.out.print(s + "-");
        }
//        A-n- -A-f-r-i-c-a-n- -S-w-a-l-l-o-w-
        for (char c : "算不尽芸芸众生微贱命,回头看五味杂陈奈何天".toCharArray()) {
            System.out.print(c + " ");
        }

        System.out.println();
    }
}
