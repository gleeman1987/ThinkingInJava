package chapter15generics;

import java.util.List;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/10
 * Mail:zhengjun1987@outlook.com
 */
public class SuperTypeWildcards {
    static void writeToList(List<? super Apple> list){
        list.add(new Apple());
        list.add(new Jonathan());
//        list.add(new Fruit());
    }

    static void writeToList2(List<? extends Apple> list){
//        list.add(new Apple());
//        list.add(new Jonathan());
//        list.add(new Fruit());
    }

    public static void main(String[] args) {

    }
}