package chapter15generics;


import java.util.ArrayList;
import java.util.List;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/10
 * Mail:zhengjun1987@outlook.com
 */
public class NonCovariantGenerics {
    public static void main(String[] args) {
//        ArrayList<Fruit> apples = new ArrayList<Apple>();泛型之间无法向上转型--容器的类型 和 容器所持有的对象的类型 是两回事
        ArrayList<Fruit> fruits = new ArrayList<>();

        List<? extends Fruit> fruits1 = new ArrayList<Apple>();//
    }
}
