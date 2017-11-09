package chapter17containeradvanced;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/9
 * Mail:zhengjun1987@outlook.com
 */
public class Synchronization {
    public static void main(String[] args) {
        Collection<Object> objectCollection = Collections.synchronizedCollection(new ArrayList<>());
    }
}
