package chapter05initialization;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/1/8.
 */
public class SimpleConstructor {
    public static void main(String[] args) {
        int i = 0,j = 0;
        System.out.println(++i);
        System.out.println(++j);
        System.out.println("初始化的内容:"+new Rock("Yosemite").mountain);
    }
}

class Rock{
    String mountain;
    String name = "yellow stone";

    public Rock(String mountain) {
        this.mountain = mountain;
    }
}