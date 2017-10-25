package chapter17containeradvanced;

import java.util.AbstractMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/25
 * Mail:zhengjun1987@outlook.com
 */
public class CountingMapData extends AbstractMap<Integer,String> {
    private int size;
    private static String[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
    public CountingMapData(int size) {
        this.size = size<0?0:size;
    }

    private static class Entry implements Map.Entry<Integer,String>{
        int index;

        public Entry(int index) {
            this.index = index;
        }

        @Override
        public boolean equals(Object obj) {
            return Integer.valueOf(index).equals(obj);
        }

        @Override
        public Integer getKey() {
            return index;
        }

        @Override
        public String getValue() {
            return chars[index%chars.length]+Integer.toString(index/chars.length);
        }

        @Override
        public String setValue(String value) {
           throw new UnsupportedOperationException();
        }
    }

    public Set<Map.Entry<Integer, String>> entrySet() {
        LinkedHashSet<Map.Entry<Integer,String>> entries = new LinkedHashSet<>();
        for (int i = 0; i < size; i++) {
            entries.add(new Entry(i));
        }
        return entries;
    }

    public static void main(String[] args) {
        System.out.println("new CountingMapData(30) = " + new CountingMapData(30));
//        new CountingMapData(30) = {0=A0, 1=B0, 2=C0, 3=D0, 4=E0, 5=F0, 6=G0, 7=H0, 8=I0, 9=J0, 10=K0, 11=L0, 12=M0, 13=N0, 14=O0, 15=P0, 16=Q0, 17=R0, 18=S0, 19=T0, 20=U0, 21=V0, 22=W0, 23=X0, 24=Y0, 25=Z0, 26=A1, 27=B1, 28=C1, 29=D1}
    }
}
