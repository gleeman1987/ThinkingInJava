package chapter16arrays;

import chapter15generics.Generator;

import java.util.Arrays;
import java.util.Random;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/25
 * Mail:zhengjun1987@outlook.com
 */
public class CompType implements Comparable<CompType> {
    int i,j;
    private static int count = 1;

    public CompType(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public String toString() {
        String s = "CompType[" +
                "i=" + i +
                ", j=" + j +
                "]  ";
        if (count++ % 3 ==0) {
            s += "\n";
        }
        return s;
    }

    @Override
    public int compareTo(CompType o) {
        return (i < o.i ? -1 : (i == o.i ? 0 : 1));
    }

    public static Random random = new Random(47);

    public static Generator<CompType> generator(){
        return new Generator<CompType>() {
            @Override
            public CompType next() {
                return new CompType(random.nextInt(100),random.nextInt(100));
            }
        };
    }

    public static void main(String[] args) {
        CompType[] compTypes = Generated.array(new CompType[12], generator());
        System.out.println("排序之前:");
        System.out.println(Arrays.toString(compTypes));
        Arrays.sort(compTypes);
        System.out.println("排序之后:");
        System.out.println(Arrays.toString(compTypes));
//        排序之前:
//[CompType[i=58, j=55]  , CompType[i=93, j=61]  , CompType[i=61, j=29]
//, CompType[i=68, j=0]  , CompType[i=22, j=7]  , CompType[i=88, j=28]
//, CompType[i=51, j=89]  , CompType[i=9, j=78]  , CompType[i=98, j=61]
//, CompType[i=20, j=58]  , CompType[i=16, j=40]  , CompType[i=11, j=22]
//]
//        排序之后:
//[CompType[i=9, j=78]  , CompType[i=11, j=22]  , CompType[i=16, j=40]
//, CompType[i=20, j=58]  , CompType[i=22, j=7]  , CompType[i=51, j=89]
//, CompType[i=58, j=55]  , CompType[i=61, j=29]  , CompType[i=68, j=0]
//, CompType[i=88, j=28]  , CompType[i=93, j=61]  , CompType[i=98, j=61]
//]
    }
}
