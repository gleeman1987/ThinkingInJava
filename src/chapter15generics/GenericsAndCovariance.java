package chapter15generics;

import java.util.ArrayList;
import java.util.List;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/10
 * Mail:zhengjun1987@outlook.com
 */
public class GenericsAndCovariance {
    public static void main(String[] args) {
        List<? extends Fruit> fruits = new ArrayList<Apple>();
        //上面这种写法会让集合无法添加任何类型的对象
//        fruits.add(new Fruit());
//        fruits.add(new Apple());
//        fruits.add(new Object());

        fruits.add(null);
        Fruit fruit = fruits.get(0);


        List<? extends Fruit> list = new ArrayList<>();
        //上面这种写法会让集合无法添加任何类型的对象
//        list.add(new Fruit());
//        list.add(new Apple());
//        list.add(new Orange());

        list.add(null);
        Fruit fruit1 = list.get(0);



        List<Fruit> fruitList = new ArrayList<>();
        fruitList.add(new Fruit());
        fruitList.add(new Apple());
        fruitList.add(new Orange());
    }
}
