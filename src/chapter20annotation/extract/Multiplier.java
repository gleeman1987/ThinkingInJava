package chapter20annotation.extract;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/6/22.
 */
@ExtractInterface("IMutiplier")
public class Multiplier {
    public static void main(String[] args) {
        System.out.println(" 11 * 6561 = "+new Multiplier().multiply(11,6561));
    }

    public int multiply(int x,int y){
        int total = 0;
        for (int i = 0; i < y; i++) {
            total = add(total,x);
        }
        return total;
    }

    private int add(int total, int x) {
        return total + x;
    }
}
