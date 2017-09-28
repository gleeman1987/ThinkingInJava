package chapter13charsequence;

public class Immutable {
    public static void main(String[] args) {
        String howdy = "howdy";
        System.out.println(howdy);
        String upcase = upcase(howdy);//把String作为参数传递时,传递的是该String的拷贝,原String对象并未变化,也不会传递原String的引用
        System.out.println("==================");
        System.out.println(howdy);
        System.out.println(upcase);
    }

    private static String upcase(String howdy) {
        //传给局部引用变量howdy,return语句后howdy消失
        return howdy.toUpperCase();
    }
}
