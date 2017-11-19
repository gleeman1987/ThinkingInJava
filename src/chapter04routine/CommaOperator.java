package chapter04routine;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/19
 * Mail:zhengjun1987@outlook.com
 */
public class CommaOperator {
    public static void main(String[] args) {
        for (int i = 0,j=i+10; i < 5; i++,j = i*2) {
            System.out.println("i = " + i+"; j = " + j);
        }
//        i = 0; j = 10
//        i = 1; j = 2
//        i = 2; j = 4
//        i = 3; j = 6
//        i = 4; j = 8
    }
}
