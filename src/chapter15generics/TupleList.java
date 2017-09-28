package chapter15generics;

import java.util.ArrayList;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/9/27.
 */
public class TupleList<A,B,C,D> extends ArrayList<FourTuple<A,B,C,D>> {
    public static void main(String[] args) {
        TupleList<Vehicle, Amphibian, String, Integer> fourTuples = new TupleList<>();
        fourTuples.add(new FourTuple<Vehicle,Amphibian,String,Integer>(new Vehicle(),new Amphibian(),"hi",47));
        fourTuples.add(new FourTuple<Vehicle,Amphibian,String,Integer>(new Vehicle(),new Amphibian(),"hi",47));
        for (FourTuple<Vehicle, Amphibian, String, Integer> fourTuple : fourTuples) {
            System.out.println("fourTuple = " + fourTuple);
        }
    }
}
