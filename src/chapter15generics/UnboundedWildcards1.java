package chapter15generics;

import java.util.ArrayList;
import java.util.List;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/10
 * Mail:zhengjun1987@outlook.com
 */
public class UnboundedWildcards1 {
    static List list1;
    static List<?> list2;
    static List<? extends Object> list3;
    static void asign1(List list){
        list1 = list;
        list2 = list;
        list3 = list;//unchecked assignment
    }
    static void asign2(List<?> list){
        list1 = list;
        list2 = list;
        list3 = list;
    }
    static void asign3(List<? extends Object> list){
        list1 = list;
        list2 = list;
        list3 = list;
    }

    public static void main(String[] args) {
        asign1(new ArrayList());
        asign2(new ArrayList());
        asign3(new ArrayList());

        asign1(new ArrayList<String>());
        asign2(new ArrayList<String>());
        asign3(new ArrayList<String>());

        List<?> arraylist = new ArrayList<>();
        arraylist = new ArrayList<String>();
        asign1(arraylist);
        asign2(arraylist);
        asign3(arraylist);
    }
}
