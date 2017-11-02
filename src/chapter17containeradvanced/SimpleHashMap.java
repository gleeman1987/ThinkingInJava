package chapter17containeradvanced;

import java.util.*;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/2
 * Mail:zhengjun1987@outlook.com
 */
public class SimpleHashMap<K,V> extends AbstractMap<K,V> {
    static final int SIZE = 997;
    LinkedList<SlowMap.MapEntry<K,V>>[] buckets = new LinkedList[997];

    @Override
    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        LinkedList<SlowMap.MapEntry<K, V>> bucket = buckets[index];
        SlowMap.MapEntry<K, V> kvMapEntry = new SlowMap.MapEntry<>(key,value);
        boolean found = false;
        Iterator<SlowMap.MapEntry<K, V>> mapEntryIterator = bucket.iterator();
        while (mapEntryIterator.hasNext()){
            SlowMap.MapEntry<K, V> next = mapEntryIterator.next();
            if (next.getKey().equals(key)) {
                oldValue = next.getValue();
                next.setValue(value);
                found = true;
                break;
            }
        }
        if (!found) {
            buckets[index].add(kvMapEntry);
        }
        return oldValue;
    }

    @Override
    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) {
            return null;
        }
        for (SlowMap.MapEntry<K, V> kvMapEntry : buckets[index]) {
            if (kvMapEntry.getKey().equals(key)) {
                return kvMapEntry.getValue();
            }
        }
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> mapEntries = new HashSet<>();
        for (LinkedList<SlowMap.MapEntry<K, V>> bucket : buckets) {
            if (bucket == null) {
                continue;
            }
            for (SlowMap.MapEntry<K, V> kvMapEntry : bucket) {
                mapEntries.add(kvMapEntry);
            }
        }
        return mapEntries;
    }

    public static void main(String[] args) {
        SimpleHashMap<String, String> hashMap = new SimpleHashMap<>();
        hashMap.putAll(Countries.capitals(10));
        System.out.println("hashMap = " + hashMap);
        System.out.println("hashMap.get(\"ANGOLA\") = " + hashMap.get("ANGOLA"));
        System.out.println("hashMap.entrySet() = " + hashMap.entrySet());
//        hashMap = {BURKINA FASO=Ouagadougou, CHAD=N'djamena, ANGOLA=Luanda, BURUNDI=Bujumbura, ALGERIA=Algiers, CENTRAL AFRICAN REPUBLIC=Bangui, BENIN=Porto-Novo, CAPE VERDE=Praia, BOTSWANA=Gaberone, CAMEROON=Yaounde}
//        hashMap.get("ANGOLA") = Luanda
//        hashMap.entrySet() = [MapEntry{k=BURKINA FASO, v=Ouagadougou}, MapEntry{k=CHAD, v=N'djamena}, MapEntry{k=ANGOLA, v=Luanda}, MapEntry{k=BURUNDI, v=Bujumbura}, MapEntry{k=ALGERIA, v=Algiers}, MapEntry{k=CENTRAL AFRICAN REPUBLIC, v=Bangui}, MapEntry{k=BENIN, v=Porto-Novo}, MapEntry{k=CAPE VERDE, v=Praia}, MapEntry{k=BOTSWANA, v=Gaberone}, MapEntry{k=CAMEROON, v=Yaounde}]

        }
}
