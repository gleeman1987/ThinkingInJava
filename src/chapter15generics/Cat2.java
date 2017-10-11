package chapter15generics;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/11
 * Mail:zhengjun1987@outlook.com
 */
//public class Cat2 extends ComparablePet implements Comparable<Cat2> {//
public class Cat2 extends ComparablePet {
    @Override
    public int compareTo(ComparablePet comparablePet) {//注意本行的参数类型是ComparablePet而非Cat2
        return super.compareTo(comparablePet);
    }
}

class Hamster extends ComparablePet implements Comparable<ComparablePet>{//有没有 implements Comparable<ComparablePet>无所谓
    @Override
    public int compareTo(ComparablePet comparablePet) {
        return super.compareTo(comparablePet);
    }
}
