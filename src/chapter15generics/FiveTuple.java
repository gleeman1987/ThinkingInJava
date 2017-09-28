package chapter15generics;

public class FiveTuple<K,V,P,T,U> extends FourTuple<K,V,P,T> {
    protected U fiveth;
    public FiveTuple(K k, V v, P p, T t,U u) {
        super(k, v, p, t);
        this.fiveth = u;
    }

    @Override
    public String toString() {
        return "FiveTuple{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                ", fourth=" + fourth +
                ", fiveth=" + fiveth +
                '}';
    }
}
