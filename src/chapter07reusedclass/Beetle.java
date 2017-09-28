package chapter07reusedclass;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/5/24.
 */
public class Beetle extends Insect {
    private int k = printInit("Beetle  int k 初始化");

    public static void main(String[] args) {
//        System.out.println("Beetle 构造方法");
//        Insect beetle = new Beetle();
    }

    public Beetle() {
        System.out.println("k = " + k+" , j = " + j);
    }

    private static int x2 = printInit("Beetle static int x2 初始化");
    static {
        System.out.println("Beetle static代码块");
    }
}

class Insect {
    private int i = 9;
    protected int j;

    static {
        System.out.println("Insect static代码块");
        Beetle beetle = new Beetle();
    }

    public Insect() {
        System.out.println("i = " + i + " , j = " + j);
        j = 39;
    }

    private static int x1 = printInit("Insect static int x1 初始化");

    static int printInit(String s){
        System.out.println("s = [" + s + "]");
        return 47;
    }
}
