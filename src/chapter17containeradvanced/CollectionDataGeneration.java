package chapter17containeradvanced;

import chapter16arrays.RandomGenerator;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/25
 * Mail:zhengjun1987@outlook.com
 */
public class CollectionDataGeneration {
    public static void main(String[] args) {
        System.out.println("new ArrayList<String>(CollectionData.list(new RandomGenerator.String(9),10)) = " + new ArrayList<String>(CollectionData.list(new RandomGenerator.String(9), 10)));
        System.out.println("new HashSet<Integer>(new CollectionData<>(new RandomGenerator.Integer(),10)) = " + new HashSet<Integer>(new CollectionData<>(new RandomGenerator.Integer(), 10)));
//        new ArrayList<String>(CollectionData.list(new RandomGenerator.String(9),10)) = [gRidUMqmg, BFgIQTLkR, afKxFjJXW, mkWYTtxkr, TKsiiLZIN, ZHZrsEurn, TNhNqmueB, tcGVAZxlW, cbxupjFhK, dIYSKmGCQ]
//        new HashSet<Integer>(new CollectionData<>(new RandomGenerator.Integer(),10)) = [2017, 8037, 871, 7882, 6090, 4779, 299, 573, 4367, 3455]
    }
}
