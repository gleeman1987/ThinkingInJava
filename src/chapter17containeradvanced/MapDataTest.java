package chapter17containeradvanced;

import chapter15generics.Generator;
import chapter16arrays.CountingGenerator;
import chapter16arrays.RandomGenerator;

import java.util.Iterator;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/25
 * Mail:zhengjun1987@outlook.com
 */
class Letters implements Generator<Pair<Integer,String>>,Iterable<Integer>{
    private int size = 9;
    private int number = 1;
    private char letter = 'A';
    @Override
    public Pair<Integer, String> next() {
        return new Pair<>(number++,"" + letter++);
    }

    public Iterator<Integer> iterator(){
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return number < size;
            }

            @Override
            public Integer next() {
                return number++;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}

public class MapDataTest {
    public static void main(String[] args) {
        System.out.println("MapData.map(new Letters(),11) = " + MapData.map(new Letters(), 11));
//        MapData.map(new Letters(),11) = {1=A, 2=B, 3=C, 4=D, 5=E, 6=F, 7=G, 8=H, 9=I, 10=J, 11=K}
        System.out.println("MapData.map(new CountingGenerator.Character(),new RandomGenerator.String(3),8) = " + MapData.map(new CountingGenerator.Character(), new RandomGenerator.String(3), 8));
//        MapData.map(new CountingGenerator.Character(),new RandomGenerator.String(3),8) = {a=gRi, b=dUM, c=qmg, d=BFg, e=IQT, f=LkR, g=afK, h=xFj}
        System.out.println("MapData.map(new CountingGenerator.Character(),\"value\",6) = " + MapData.map(new CountingGenerator.Character(), "value", 6));
//        MapData.map(new CountingGenerator.Character(),"value",6) = {a=value, b=value, c=value, d=value, e=value, f=value}
        System.out.println("MapData.map(new Letters().iterator(),new RandomGenerator.String(3)) = " + MapData.map(new Iterable<Integer>() {
            @Override
            public Iterator<Integer> iterator() {
                return new Letters().iterator();
            }
        }, new RandomGenerator.String(3)));
//        MapData.map(new Letters().iterator(),new RandomGenerator.String(3)) = {1=JXW, 2=mkW, 3=YTt, 4=xkr, 5=TKs, 6=iiL, 7=ZIN, 8=ZHZ}
        System.out.println("MapData.map(new Letters(),\"Pop\") = " + MapData.map(new Letters(), "Pop"));
//        MapData.map(new Letters(),"Pop") = {1=Pop, 2=Pop, 3=Pop, 4=Pop, 5=Pop, 6=Pop, 7=Pop, 8=Pop}
    }
}
