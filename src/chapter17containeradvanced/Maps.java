package chapter17containeradvanced;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/30
 * Mail:zhengjun1987@outlook.com
 */
public class Maps {
    public static void printKeys(Map<Integer,String> map){
        System.out.println("map.size() = " + map.size());
        System.out.print("Keys:");
        System.out.print(map.keySet());
        System.out.println();
    }

    public static void test(Map<Integer,String> map){
        System.out.println("map.getClass().getSimpleName() = " + map.getClass().getSimpleName());
        map.putAll(new CountingMapData(25));
        map.putAll(new CountingMapData(25));
        printKeys(map);

        System.out.print("Values:");
        System.out.print(map.values());
        System.out.println();
        System.out.println("map = " + map);
        System.out.println("map.containsKey(11) = " + map.containsKey(11));
        System.out.println("map.get(11) = " + map.get(11));
        System.out.println("map.containsValue(\"F0\") = " + map.containsValue("F0"));
        Integer next = map.keySet().iterator().next();
        System.out.println("map.keySet().iterator().next() = " + next);
        map.remove(next);
        printKeys(map);
        map.clear();
        System.out.println("map.isEmpty() = " + map.isEmpty());
        map.putAll(new CountingMapData(25));
        map.keySet().removeAll(map.keySet());
        System.out.println("map.isEmpty() = " + map.isEmpty());
    }

    public static void main(String[] args) {
        test(new HashMap<>());
//        map.getClass().getSimpleName() = HashMap
//        map.size() = 25
//        Keys:[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24]
//        Values:[A0, B0, C0, D0, E0, F0, G0, H0, I0, J0, K0, L0, M0, N0, O0, P0, Q0, R0, S0, T0, U0, V0, W0, X0, Y0]
//        map = {0=A0, 1=B0, 2=C0, 3=D0, 4=E0, 5=F0, 6=G0, 7=H0, 8=I0, 9=J0, 10=K0, 11=L0, 12=M0, 13=N0, 14=O0, 15=P0, 16=Q0, 17=R0, 18=S0, 19=T0, 20=U0, 21=V0, 22=W0, 23=X0, 24=Y0}
//        map.containsKey(11) = true
//        map.get(11) = L0
//        map.containsValue("F0") = true
//        map.keySet().iterator().next() = 0
//        map.size() = 24
//        Keys:[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24]
//        map.isEmpty() = true
//        map.isEmpty() = true
        test(new TreeMap<>());
//        map.getClass().getSimpleName() = TreeMap
//        map.size() = 25
//        Keys:[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24]
//        Values:[A0, B0, C0, D0, E0, F0, G0, H0, I0, J0, K0, L0, M0, N0, O0, P0, Q0, R0, S0, T0, U0, V0, W0, X0, Y0]
//        map = {0=A0, 1=B0, 2=C0, 3=D0, 4=E0, 5=F0, 6=G0, 7=H0, 8=I0, 9=J0, 10=K0, 11=L0, 12=M0, 13=N0, 14=O0, 15=P0, 16=Q0, 17=R0, 18=S0, 19=T0, 20=U0, 21=V0, 22=W0, 23=X0, 24=Y0}
//        map.containsKey(11) = true
//        map.get(11) = L0
//        map.containsValue("F0") = true
//        map.keySet().iterator().next() = 0
//        map.size() = 24
//        Keys:[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24]
//        map.isEmpty() = true
//        map.isEmpty() = true
        test(new LinkedHashMap<>());
//        map.getClass().getSimpleName() = LinkedHashMapDemo
//        map.size() = 25
//        Keys:[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24]
//        Values:[A0, B0, C0, D0, E0, F0, G0, H0, I0, J0, K0, L0, M0, N0, O0, P0, Q0, R0, S0, T0, U0, V0, W0, X0, Y0]
//        map = {0=A0, 1=B0, 2=C0, 3=D0, 4=E0, 5=F0, 6=G0, 7=H0, 8=I0, 9=J0, 10=K0, 11=L0, 12=M0, 13=N0, 14=O0, 15=P0, 16=Q0, 17=R0, 18=S0, 19=T0, 20=U0, 21=V0, 22=W0, 23=X0, 24=Y0}
//        map.containsKey(11) = true
//        map.get(11) = L0
//        map.containsValue("F0") = true
//        map.keySet().iterator().next() = 0
//        map.size() = 24
//        Keys:[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24]
//        map.isEmpty() = true
//        map.isEmpty() = true
        test(new IdentityHashMap<>());
//        map.getClass().getSimpleName() = IdentityHashMap
//        map.size() = 25
//        Keys:[21, 8, 24, 9, 17, 5, 3, 22, 6, 14, 19, 11, 18, 2, 20, 0, 7, 23, 13, 10, 15, 4, 16, 12, 1]
//        Values:[V0, I0, Y0, J0, R0, F0, D0, W0, G0, O0, T0, L0, S0, C0, U0, A0, H0, X0, N0, K0, P0, E0, Q0, M0, B0]
//        map = {21=V0, 8=I0, 24=Y0, 9=J0, 17=R0, 5=F0, 3=D0, 22=W0, 6=G0, 14=O0, 19=T0, 11=L0, 18=S0, 2=C0, 20=U0, 0=A0, 7=H0, 23=X0, 13=N0, 10=K0, 15=P0, 4=E0, 16=Q0, 12=M0, 1=B0}
//        map.containsKey(11) = true
//        map.get(11) = L0
//        map.containsValue("F0") = false
//        map.keySet().iterator().next() = 21
//        map.size() = 24
//        Keys:[8, 24, 9, 17, 5, 3, 22, 6, 14, 19, 11, 18, 2, 20, 0, 7, 23, 13, 10, 15, 4, 16, 12, 1]
//        map.isEmpty() = true
//        map.isEmpty() = true
        test(new ConcurrentHashMap<>());
//        map.size() = 25
//        Keys:[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24]
//        Values:[A0, B0, C0, D0, E0, F0, G0, H0, I0, J0, K0, L0, M0, N0, O0, P0, Q0, R0, S0, T0, U0, V0, W0, X0, Y0]
//        map = {0=A0, 1=B0, 2=C0, 3=D0, 4=E0, 5=F0, 6=G0, 7=H0, 8=I0, 9=J0, 10=K0, 11=L0, 12=M0, 13=N0, 14=O0, 15=P0, 16=Q0, 17=R0, 18=S0, 19=T0, 20=U0, 21=V0, 22=W0, 23=X0, 24=Y0}
//        map.containsKey(11) = true
//        map.get(11) = L0
//        map.containsValue("F0") = true
//        map.keySet().iterator().next() = 0
//        map.size() = 24
//        Keys:[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24]
//        map.isEmpty() = true
//        map.isEmpty() = true
        test(new WeakHashMap<>());
//        map.getClass().getSimpleName() = WeakHashMap
//        map.size() = 25
//        Keys:[24, 22, 23, 20, 21, 18, 19, 16, 17, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0]
//        Values:[Y0, W0, X0, U0, V0, S0, T0, Q0, R0, P0, O0, N0, M0, L0, K0, J0, I0, H0, G0, F0, E0, D0, C0, B0, A0]
//        map = {24=Y0, 22=W0, 23=X0, 20=U0, 21=V0, 18=S0, 19=T0, 16=Q0, 17=R0, 15=P0, 14=O0, 13=N0, 12=M0, 11=L0, 10=K0, 9=J0, 8=I0, 7=H0, 6=G0, 5=F0, 4=E0, 3=D0, 2=C0, 1=B0, 0=A0}
//        map.containsKey(11) = true
//        map.get(11) = L0
//        map.containsValue("F0") = true
//        map.keySet().iterator().next() = 24
//        map.size() = 24
//        Keys:[22, 23, 20, 21, 18, 19, 16, 17, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0]
//        map.isEmpty() = true
//        map.isEmpty() = true
    }
}
