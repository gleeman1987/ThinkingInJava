package chapter15generics;

public class TwoTuple<K,V> {
    public  K first;
    public  V second;

    public TwoTuple(K k, V v) {
        this.first = k;
        this.second = v;
    }

    public void set(K k, V v){
        this.first = k;
        this.second = v;
    }

    @Override
    public String toString() {
        return "TwoTuple{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    public static void main(String[] args) {
        TwoTuple<String, Integer> tuple = new TwoTuple<>("阳光宅男", 3);
        System.out.println("tuple = " + tuple);

        tuple.set("周杰伦",1978);
        System.out.println("tuple = " + tuple);
    }
}
