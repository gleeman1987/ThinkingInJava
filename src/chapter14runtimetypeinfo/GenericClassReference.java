package chapter14runtimetypeinfo;

public class GenericClassReference {
    public static void main(String[] args) {
        Class clazz = int.class;
        Class<Integer> integerClass = int.class;
        integerClass = Integer.class;
        integerClass = Integer.TYPE;
//        integerClass = Double.class;
    }
}
