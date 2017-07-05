package chapter10;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/6/29.
 */
public class DotNew {

    class Inner1{
        private int value = 11;
    }

    public static void main(String[] args) {
        DotNew dotNew = new DotNew();

        Inner1 inner = dotNew.new Inner1();
        System.out.println(inner.value);
    }
}
