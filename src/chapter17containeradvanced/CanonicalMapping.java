package chapter17containeradvanced;

import java.util.WeakHashMap;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/12
 * Mail:zhengjun1987@outlook.com
 */
class Element {
    private String ident;

    public Element(String ident) {
        this.ident = ident;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element = (Element) o;
        return ident != null ? ident.equals(element.ident) : element.ident == null;
    }

    @Override
    public int hashCode() {
        return ident != null ? ident.hashCode() : 0;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalizing "+getClass().getSimpleName()+" "+ident);
    }
}

class Key extends Element{
    public Key(String ident) {
        super(ident);
    }
}

class Value extends Element {
    public Value(String ident) {
        super(ident);
    }
}

public class CanonicalMapping {
    public static void main(String[] args) {
        int size = 1000;
        Key[] keys = new Key[size];
        WeakHashMap<Key, Value> keyValueWeakHashMap = new WeakHashMap<>();
        for (int i = 0; i < size; i++) {
            Key key = new Key(Integer.toString(i));
            Value value = new Value(Integer.toString(i));
            if (i % 3 == 0) {
                keys[i] = key;
            }
            keyValueWeakHashMap.put(key,value);
        }
        System.gc();
//        Finalizing Key 742
//        Finalizing Key 391
//        Finalizing Key 406
//        Finalizing Key 440
//        Finalizing Key 482
//        Finalizing Key 520
//        Finalizing Key 578
//        Finalizing Key 608
//        Finalizing Key 238
//        Finalizing Key 283
//        Finalizing Key 323
//        Finalizing Key 8
//        Finalizing Key 86
//        Finalizing Key 196
//        Finalizing Key 103
//        Finalizing Key 101
//        Finalizing Key 100
//        Finalizing Key 98
//        Finalizing Key 97
//        Finalizing Key 95
//        Finalizing Key 94
//        Finalizing Key 92
//        Finalizing Key 91
//        Finalizing Key 89
//        Finalizing Key 88
//        Finalizing Key 85
//        Finalizing Key 83
//        Finalizing Key 82
//        Finalizing Key 46
//        Finalizing Key 44
//        Finalizing Key 43
//        Finalizing Key 41
//        Finalizing Key 40
//        Finalizing Key 38
    }
}
