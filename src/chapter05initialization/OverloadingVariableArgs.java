package chapter05initialization;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/3/16.
 */
public class OverloadingVariableArgs {
    public static void main(String[] args) {
        f('q','a');
        f(new Integer(2),new Integer(28));
    }

    static void f(int... args){
        System.out.println("f(int... args)");
        for (int arg : args) {
            System.out.println(arg);
        }
    }

    static void f(char... args){
        System.out.println("f(char... args)");
        System.out.println(args[1]);
    }
}
