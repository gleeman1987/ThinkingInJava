package chapter17containeradvanced;

import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/30
 * Mail:zhengjun1987@outlook.com
 */
public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>(new CountingMapData(9));
        System.out.println("linkedHashMap = " + linkedHashMap);
//        linkedHashMap = {0=A0, 1=B0, 2=C0, 3=D0, 4=E0, 5=F0, 6=G0, 7=H0, 8=I0}
        linkedHashMap = new LinkedHashMap<>(16,0.75f,true);
        linkedHashMap.putAll(new CountingMapData(9));
        System.out.println("linkedHashMap = " + linkedHashMap);
//        linkedHashMap = {0=A0, 1=B0, 2=C0, 3=D0, 4=E0, 5=F0, 6=G0, 7=H0, 8=I0}
        for (int i = 0; i < 6; i++) {
            linkedHashMap.get(i);
        }
        System.out.println("linkedHashMap = " + linkedHashMap);
//        linkedHashMap = {6=G0, 7=H0, 8=I0, 0=A0, 1=B0, 2=C0, 3=D0, 4=E0, 5=F0}
        linkedHashMap.get(0);
        System.out.println("linkedHashMap = " + linkedHashMap);
//        linkedHashMap = {6=G0, 7=H0, 8=I0, 1=B0, 2=C0, 3=D0, 4=E0, 5=F0, 0=A0}
    }
}
