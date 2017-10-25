package chapter17containeradvanced;

import chapter15generics.Generator;

import java.util.LinkedHashMap;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/25
 * Mail:zhengjun1987@outlook.com
 */
public class MapData<K,V> extends LinkedHashMap<K,V> {
    public MapData(Generator<Pair<K,V>> generator,int quantity) {
        for (int i = 0; i < quantity; i++) {
            Pair<K, V> next = generator.next();
            put(next.key,next.value);
        }
    }

    public MapData(Generator<K> kGenerator,Generator<V> vGenerator,int quantity) {
        for (int i = 0; i < quantity; i++) {
            put(kGenerator.next(),vGenerator.next());
        }
    }

    public MapData(Generator<K> kGenerator,V value,int quantity) {
        for (int i = 0; i < quantity; i++) {
            put(kGenerator.next(),value);
        }
    }

    public MapData(Iterable<K> kIterable,Generator<V> vGenerator) {
        for (K k : kIterable) {
            put(k,vGenerator.next());
        }
    }

    public MapData(Iterable<K> kIterable,V value) {
        for (K k : kIterable) {
            put(k,value);
        }
    }

    public static <K,V> MapData<K,V> map(Generator<Pair<K,V>> generator,int quantity){ return new MapData<K, V>(generator,quantity);}
    public static <K,V> MapData<K,V> map(Generator<K> kGenerator,Generator<V> vGenerator,int quantity){ return new MapData<K, V>(kGenerator,vGenerator,quantity);}
    public static <K,V> MapData<K,V> map(Generator<K> kGenerator,V value,int quantity){ return new MapData<K, V>(kGenerator,value,quantity);}
    public static <K,V> MapData<K,V> map(Iterable<K> kIterable,Generator<V> vGenerator){ return new MapData<K, V>(kIterable,vGenerator);}
    public static <K,V> MapData<K,V> map(Iterable<K> kIterable,V value){ return new MapData<K, V>(kIterable,value);}
}
