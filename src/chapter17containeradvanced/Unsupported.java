package chapter17containeradvanced;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/26
 * Mail:zhengjun1987@outlook.com
 */
public class Unsupported {
    static void test(String message, List<String> list){
        System.out.println("---"+message+"---");
        Collection<String> collection = list;
        List<String> subList = list.subList(1, 8);
        List<String> strings = new ArrayList<>(subList);

        try {
            collection.retainAll(strings);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
