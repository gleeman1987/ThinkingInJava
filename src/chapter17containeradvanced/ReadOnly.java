package chapter17containeradvanced;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/9
 * Mail:zhengjun1987@outlook.com
 */
public class ReadOnly {
    static Collection<String> data = new ArrayList<>(Countries.names(6));

    public static void main(String[] args) {
        Collection<String> collection = Collections.unmodifiableCollection(data);
        System.out.println("collection = " + collection);
//        collection = [ALGERIA, ANGOLA, BENIN, BOTSWANA, BURKINA FASO, BURUNDI]
        try {
            collection.add("Hello");//java.lang.UnsupportedOperationException
            System.out.println("collection = " + collection);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<String> unmodifiableList = Collections.unmodifiableList(new ArrayList<>(data));
        System.out.println("unmodifiableList = " + unmodifiableList);
//        unmodifiableList = [ALGERIA, ANGOLA, BENIN, BOTSWANA, BURKINA FASO, BURUNDI]
        try {
            unmodifiableList.add("Hello");//java.lang.UnsupportedOperationException
            System.out.println("unmodifiableList = " + unmodifiableList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
