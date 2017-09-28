package chapter15generics;

public class TupleTest {
    static TwoTuple<String,Integer> f(){
        return new TwoTuple<>("hi",47);
    }
    public static void main(String[] args) {
        TwoTuple<String, Integer> tuple = f();
        System.out.println("tuple = " + tuple);
        System.out.println(new ThreeTuple<Amphibian,String,Integer>(new Amphibian(),"hi",47));
        System.out.println(new FourTuple<Vehicle,Amphibian,String,Integer>(new Vehicle(),new Amphibian(),"hi",47));
        System.out.println(new FiveTuple<Vehicle,Amphibian,String,Integer,Double>(new Vehicle(),new Amphibian(),"hi",47,3.14159));
//        tuple = TwoTuple{first=hi, second=47}
//        ThreeTuple{first=chapter15generics.Amphibian@4554617c, second=hi, third=47}
//        FourTuple{fourth=47, third=hi, first=chapter15generics.Vehicle@74a14482, second=chapter15generics.Amphibian@1540e19d}
//        FiveTuple{first=chapter15generics.Vehicle@677327b6, second=chapter15generics.Amphibian@14ae5a5, third=hi, fourth=47, fiveth=3.14159}
    }
}

class Amphibian {}

class Vehicle{}
