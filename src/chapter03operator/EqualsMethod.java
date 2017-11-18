package chapter03operator;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/17
 * Mail:zhengjun1987@outlook.com
 */
public class EqualsMethod {
    public static void main(String[] args) {
        System.out.println("(new Integer(47).equals(new Integer(47))) = " + (new Integer(47).equals(new Integer(47))));
//        (new Integer(47).equals(new Integer(47))) = true

        Value value1 = new Value();
        Value value2 = new Value();
        value1.anInt = value2.anInt = 47;
        System.out.println("value1.anInt = " + value1.anInt);
        System.out.println("value2.anInt = " + value2.anInt);
        System.out.println("(value1.equals(value2)) = " + (value1.equals(value2)));
//        value1.anInt = 47
//        value2.anInt = 47
//        (value1.equals(value2)) = false
    }
}

class Value {
    int anInt;
}
