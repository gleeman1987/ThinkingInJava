package chapter15generics;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/20
 * Mail:zhengjun1987@outlook.com
 */
interface Combiner<T> {
    T combine(T x,T y);
}

interface UnaryFunction<R,T>{
    R function(T t);
}

interface Collector<T> extends UnaryFunction<T,T>{
    T result();
}

interface UnaryPredict<T> {
    boolean test(T x);
}

public class Functional {
   /*
   * 将序列中的对象逐个combine,返回最终结果,若序列为空,则返回null
   * */
    public static <T> T reduce(Iterable<T> sequence,Combiner<T> combiner){
        Iterator<T> iterator = sequence.iterator();
        if (iterator.hasNext()) {
            T result = iterator.next();
            while (iterator.hasNext())
                result = combiner.combine(result,iterator.next());
            return result;
        }
        return null;
    }

    /*
    * 将序列中的元素逐个处理之后返回新的序列集合
    * */
    public static <T> Collection<T> forEach(Iterable<T> sequence,Collector<T> collector){
        ArrayList<T> result = new ArrayList<>();
        for (T t : sequence) {
            result.add(collector.function(t));
        }
        return result;
    }

    /*
    * 将序列中的元素逐个转换成新的类型的元素之后返回新元素的集合
    * */
    public static <R,T> List<R> transform(Iterable<T> sequence,UnaryFunction<R,T> functioner){
        ArrayList<R> result = new ArrayList<>();
        for (T t : sequence) {
            result.add(functioner.function(t));
        }
        return result;
    }

    /*
    * 将序列中的元素逐个甄别是否符合条件,返回符合条件的元素的集合
    * */
    public static <T> List<T> filter(Iterable<T> sequence,UnaryPredict<T> predictor){
        ArrayList<T> result = new ArrayList<>();
        for (T t : sequence) {
            if (predictor.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    static class IntegerAdder implements Combiner<Integer>{
        @Override
        public Integer combine(Integer x, Integer y) {
            return x + y;
        }
    }

    static class IntegerSubtractor implements Combiner<Integer>{
        @Override
        public Integer combine(Integer x, Integer y) {
            return x-y;
        }
    }

    static class BigDecimalAdder implements Combiner<BigDecimal>{
        @Override
        public BigDecimal combine(BigDecimal x, BigDecimal y) {
            return x.add(y);
        }
    }

    static class BigIntegerAdder implements Combiner<BigInteger>{
        @Override
        public BigInteger combine(BigInteger x, BigInteger y) {
            return x.add(y);
        }
    }

    static class AtomicLongAdder implements Combiner<AtomicLong>{
        @Override
        public AtomicLong combine(AtomicLong x, AtomicLong y) {
            return new AtomicLong(x.addAndGet(y.get()));
        }
    }

    static class BigDecimalUlp implements UnaryFunction<BigDecimal,BigDecimal>{
        @Override
        public BigDecimal function(BigDecimal bigDecimal) {
            return bigDecimal.ulp();
        }
    }

    static class GreaterThan<T extends Comparable<T>> implements UnaryPredict<T>{
        private T bound;

        public GreaterThan(T bound) {
            this.bound = bound;
        }

        @Override
        public boolean test(T x) {
            return x.compareTo(bound) > 0;
        }
    }

    static class MultiplyingIntegerCollector implements Collector<Integer>{
        private Integer val = 1;

        @Override
        public Integer result() {
            return val;
        }

        @Override
        public Integer function(Integer integer) {
            val *= integer;
            return val;
        }
    }

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        Integer reduce = reduce(integers, new IntegerAdder());
        System.out.println("reduce = " + reduce);
//        reduce = 28
        reduce = reduce(integers,new IntegerSubtractor());
        System.out.println("reduce = " + reduce);
//        reduce = -26
        System.out.println("filter(integers,new GreaterThan<>(4)) = " + filter(integers, new GreaterThan<>(4)));
//        filter(integers,new GreaterThan<>(4)) = [5, 6, 7]
        System.out.println("forEach(integers,new MultiplyingIntegerCollector())) = " + forEach(integers, new MultiplyingIntegerCollector()));
//        forEach(integers,new MultiplyingIntegerCollector())) = [1, 2, 6, 24, 120, 720, 5040]
        System.out.println("forEach(filter(integers,new GreaterThan<>(4)),new MultiplyingIntegerCollector()) = " + forEach(filter(integers, new GreaterThan<>(4)), new MultiplyingIntegerCollector()));
//        forEach(filter(integers,new GreaterThan<>(4)),new MultiplyingIntegerCollector()) = [5, 30, 210]


        MathContext mathContext = new MathContext(7);
        List<BigDecimal> bigDecimals = Arrays.asList(new BigDecimal(1.1, mathContext), new BigDecimal(2.2, mathContext), new BigDecimal(3.3, mathContext), new BigDecimal(4.4, mathContext));
        System.out.println("reduce("+bigDecimals+",new BigDecimalAdder()) = " + reduce(bigDecimals, new BigDecimalAdder()));
//        reduce(bigDecimals,new BigDecimalAdder()) = 11.000000
//        reduce([1.100000, 2.200000, 3.300000, 4.400000],new BigDecimalAdder()) = 11.000000

        System.out.println("filter(bigDecimals,new GreaterThan<>(new BigDecimal(2))) = " + filter(bigDecimals, new GreaterThan<>(new BigDecimal(2))));
//        filter(bigDecimals,new GreaterThan<>(new BigDecimal(2))) = [2.200000, 3.300000, 4.400000]

        List<BigInteger> bigIntegers = new ArrayList<>();
        BigInteger bigInteger = BigInteger.valueOf(11);
        for (int i = 0; i < 11; i++) {
            bigIntegers.add(bigInteger);
            bigInteger = bigInteger.nextProbablePrime();
        }
        System.out.println("bigIntegers = " + bigIntegers);
//        bigIntegers = [11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47]
        BigInteger sum = reduce(bigIntegers, new BigIntegerAdder());
        System.out.println("reduce(bigIntegers,new BigIntegerAdder()) = " + sum);
//        reduce(bigIntegers,new BigIntegerAdder()) = 311
        System.out.println("sum.isProbablePrime(5) = " + sum.isProbablePrime(5));
//        reduce(bigIntegers,new BigIntegerAdder()).isProbablePrime(5) = true

        List<AtomicLong> atomicLongs = Arrays.asList(new AtomicLong(11), new AtomicLong(47), new AtomicLong(74), new AtomicLong(133));
        System.out.println("reduce(atomicLongs,new AtomicLongAdder()) = " + reduce(atomicLongs, new AtomicLongAdder()));
//        reduce(atomicLongs,new AtomicLongAdder()) = 265
        System.out.println("transform(bigDecimals,new BigDecimalUlp()) = " + transform(bigDecimals, new BigDecimalUlp()));
//        transform(bigDecimals,new BigDecimalUlp()) = [0.000001, 0.000001, 0.000001, 0.000001]
    }
}
