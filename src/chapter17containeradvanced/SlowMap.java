package chapter17containeradvanced;

import java.util.*;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/31
 * Mail:zhengjun1987@outlook.com
 */
public class SlowMap<K,V> extends AbstractMap<K,V> {

    @Override
    public Set<Entry<K, V>> entrySet() {
        HashSet<Entry<K, V>> hashSet = new HashSet<>();
        Iterator<K> iterator = keys.iterator();
        Iterator<V> vIterator = values.iterator();
        while (iterator.hasNext())
            hashSet.add(new MapEntry<K, V>(iterator.next(),vIterator.next()));
        return hashSet;
    }

    private List<K> keys = new ArrayList<>();
    private List<V> values = new ArrayList<>();

    @Override
    public V get(Object key) {
        if (keys.contains(key)) {
            return values.get(keys.indexOf(key));
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        V oldValue = get(key);
        if (keys.contains(key)) {
            values.set(keys.indexOf(key),value);
        } else {
            keys.add(key);
            values.add(value);
        }
        return oldValue;
    }

    private static class MapEntry<K, V> implements Entry<K, V> {

        private K k;
        private V v;

        public MapEntry(K k, V v) {
            this.k = k;
            this.v = v;
        }

        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }

        @Override
        public V setValue(V value) {
            V v1 = this.v;
            this.v = value;
            return v1;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            MapEntry<?, ?> mapEntry = (MapEntry<?, ?>) o;

            if (!k.equals(mapEntry.k)) return false;
            return v.equals(mapEntry.v);

        }

        @Override
        public int hashCode() {
            int result = k.hashCode();
            result = 31 * result + v.hashCode();
            return result;
        }

        @Override
        public String toString() {
            return "MapEntry{" +
                    "k=" + k +
                    ", v=" + v +
                    '}';
        }
    }

    public static void main(String[] args) {
        SlowMap<String, String> slowMap = new SlowMap<>();
        slowMap.putAll(Countries.capitals(15));
        System.out.println("slowMap = " + slowMap);
        System.out.println("slowMap.get(\"BURUNDI\") = " + slowMap.get("BURUNDI"));
        System.out.println("slowMap.entrySet() = " + slowMap.entrySet());
//        slowMap = {BURKINA FASO=Ouagadougou, ANGOLA=Luanda, BURUNDI=Bujumbura, EGYPT=Cairo, COMOROS=Moroni, ALGERIA=Algiers, CAPE VERDE=Praia, BOTSWANA=Gaberone, CAMEROON=Yaounde, CONGO=Brazzaville, DJIBOUTI=Dijibouti, CHAD=N'djamena, CENTRAL AFRICAN REPUBLIC=Bangui, BENIN=Porto-Novo, EQUATORIAL GUINEA=Malabo}
//        slowMap.get("BURUNDI") = Bujumbura
//        slowMap.entrySet() = [chapter17containeradvanced.SlowMap$MapEntry@3390a551, chapter17containeradvanced.SlowMap$MapEntry@7feb6dc9, chapter17containeradvanced.SlowMap$MapEntry@51f6e954, chapter17containeradvanced.SlowMap$MapEntry@7dae6a4d, chapter17containeradvanced.SlowMap$MapEntry@9496c292, chapter17containeradvanced.SlowMap$MapEntry@be3dedf8, chapter17containeradvanced.SlowMap$MapEntry@8babbf00, chapter17containeradvanced.SlowMap$MapEntry@bde77288, chapter17containeradvanced.SlowMap$MapEntry@a1a0018f, chapter17containeradvanced.SlowMap$MapEntry@33a8e738, chapter17containeradvanced.SlowMap$MapEntry@91afdbdf, chapter17containeradvanced.SlowMap$MapEntry@68545a65, chapter17containeradvanced.SlowMap$MapEntry@6f4cedf9, chapter17containeradvanced.SlowMap$MapEntry@fd24209, chapter17containeradvanced.SlowMap$MapEntry@aba36a5c]

        }
}
