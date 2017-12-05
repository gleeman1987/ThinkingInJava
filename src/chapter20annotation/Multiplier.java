package chapter20annotation;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/12/5
 * Mail:zhengjun1987@outlook.com
 */
@ExtractInterface("IMultiplier")
public class Multiplier {
    public int multiply(int x,int y){
        int total = 0;
        for (int i = 0; i < x; i++) {
            total = add(total,y);
        }
        return total;
    }

    private int add(int x, int y) {
        return x+y;
    }

    public static void main(String[] args) {
        Multiplier multiplier = new Multiplier();
        System.out.println("multiplier.multiply(11,16) = " + multiplier.multiply(11, 16));
    }
}
