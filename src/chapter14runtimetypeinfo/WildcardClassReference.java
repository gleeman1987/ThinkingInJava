package chapter14runtimetypeinfo;

public class WildcardClassReference {
    public static void main(String[] args) {
        Class<?> integerClass = int.class;//使用通配符?的好处是特定声明此处并非由于忽略或错误,而是本意即是如此
        integerClass = double.class;
        System.out.println(integerClass);//double
        integerClass = Double.TYPE;
        System.out.println("integerClass = " + integerClass);//integerClass = double
    }
}
