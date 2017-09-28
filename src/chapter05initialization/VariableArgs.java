package chapter05initialization;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/3/15.
 */
public class VariableArgs {
    public static void main(String[] args) {
        printArray("a","b",new ArrayTest.Tobo("Vincent",2),"c");
        printArray(new ArrayTest.Tobo("Mario",1),new ArrayTest.Tobo("Anthena",3));
        printArray(new Object[]{"a","b",new ArrayTest.Tobo("Vincent",2)});
    }

    static void printArray(Object... args){
        System.out.println("参数:"+args);
        for (Object arg : args) {
            System.out.println(arg.toString());
        }
    }
}
