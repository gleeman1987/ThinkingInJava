package chapter15generics;

public class TupleTest2 {
    public static void main(String[] args) {
        System.out.println(f());
        System.out.println(f2());
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());
//        TwoTuple{first=hi, second=47}
//        TwoTuple{first=hi, second=47}
//        ThreeTuple{first=chapter15generics.Amphibian@74a14482, second=hi, third=47}
//        FourTuple{fourth=47, third=hi, first=chapter15generics.Vehicle@1540e19d, second=chapter15generics.Amphibian@677327b6}
//        FiveTuple{first=chapter15generics.Vehicle@14ae5a5, second=chapter15generics.Amphibian@7f31245a, third=hi, fourth=47, fiveth=11.1}
    }

    static TwoTuple<String,Integer> f(){
        return new TwoTuple<>("hi",47);
    }

    static TwoTuple<String,Integer> f2(){
        return Tuple.tuple("hi",47);
    }

    static ThreeTuple<Amphibian,String,Integer> g(){
        return Tuple.tuple(new Amphibian(),"hi",47);
    }

    static FourTuple<Vehicle,Amphibian,String,Integer> h(){
        return Tuple.tuple(new Vehicle(),new Amphibian(),"hi",47);
    }

    static FiveTuple<Vehicle,Amphibian,String,Integer,Double> k(){
        return Tuple.tuple(new Vehicle(),new Amphibian(),"hi",47,11.1);
    }

}
