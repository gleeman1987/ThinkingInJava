package chapter15generics;

import java.util.ArrayList;
import java.util.List;

public class GenericVariableArgs {
    public static <T> List<T> makeList(T... args){
        ArrayList<T> ts = new ArrayList<>();
        for (T arg : args) {
            ts.add(arg);
        }
        return ts;
    }

    public static void main(String[] args) {
        List<String> strings = makeList("渭城朝雨浥轻尘", "客舍青青柳色新", "劝君更尽一杯酒", "西出阳关无故人");
        System.out.println("strings = " + strings);//strings = [渭城朝雨浥轻尘, 客舍青青柳色新, 劝君更尽一杯酒, 西出阳关无故人]
        List<String> stringList = makeList("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split(""));
        System.out.println("stringList = " + stringList);//stringList = [A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z]
    }
}
