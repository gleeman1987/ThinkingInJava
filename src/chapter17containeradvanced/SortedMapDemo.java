package chapter17containeradvanced;

import java.util.Iterator;
import java.util.TreeMap;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/30
 * Mail:zhengjun1987@outlook.com
 */
public class SortedMapDemo {
    public static void main(String[] args) {
        TreeMap<Integer, String> integerStringTreeMap = new TreeMap<>(new CountingMapData(10));
        System.out.println("integerStringTreeMap = " + integerStringTreeMap);
        Integer low = integerStringTreeMap.firstKey();
        Integer high = integerStringTreeMap.lastKey();
        System.out.println("low = " + low);
        System.out.println("high = " + high);
//        integerStringTreeMap = {0=A0, 1=B0, 2=C0, 3=D0, 4=E0, 5=F0, 6=G0, 7=H0, 8=I0, 9=J0}
//        low = 0
//        high = 9
        Iterator<Integer> iterator = integerStringTreeMap.keySet().iterator();
        for (int i = 0; i <= 6; i++) {
            if (i==3) low=iterator.next();
            if (i==6) high=iterator.next();
            else iterator.next();
        }
        System.out.println("low = " + low);
        System.out.println("high = " + high);
        System.out.println("integerStringTreeMap.subMap(low,high) = " + integerStringTreeMap.subMap(low, high));
        System.out.println("integerStringTreeMap.headMap(high) = " + integerStringTreeMap.headMap(high));
        System.out.println("integerStringTreeMap.tailMap(low) = " + integerStringTreeMap.tailMap(low));
//        low = 3
//        high = 7
//        integerStringTreeMap.subMap(low,high) = {3=D0, 4=E0, 5=F0, 6=G0}
//        integerStringTreeMap.headMap(high) = {0=A0, 1=B0, 2=C0, 3=D0, 4=E0, 5=F0, 6=G0}
//        integerStringTreeMap.tailMap(low) = {3=D0, 4=E0, 5=F0, 6=G0, 7=H0, 8=I0, 9=J0}
    }
}
