package chapter15generics;

public class FourTuple<K,V,P,T> extends ThreeTuple<K,V,P> {
    protected T fourth;
    public FourTuple(K k, V v, P p,T t) {
        super(k, v, p);
        this.fourth = t;
    }

    @Override
    public String toString() {
        return "FourTuple{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                ", fourth=" + fourth +
                '}';
    }
}
