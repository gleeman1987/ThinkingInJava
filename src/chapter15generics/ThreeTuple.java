package chapter15generics;

public class ThreeTuple<K,V,P> extends TwoTuple<K,V> {
    protected P third;
    public ThreeTuple(K k, V v,P p) {
        super(k, v);
        this.third = p;
    }

    @Override
    public String toString() {
        return "ThreeTuple{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                '}';
    }

    public static void main(String[] args) {
        ThreeTuple<AutoMobile, String, Integer> threeTuple = new ThreeTuple<>(new AutoMobile(), "三年二班", 9);
        System.out.println("threeTuple = " + threeTuple);
    }
}
