package chapter15generics;

import java.util.ArrayList;
import java.util.List;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/9/30.
 */
public class ListOfGenerics<T> {
    private List<T> list = new ArrayList<>();
    public void add(T t){
        list.add(t);
    }

    public T get(int index){
        return list.get(index);
    }

    public static void main(String[] args) {

    }
}
