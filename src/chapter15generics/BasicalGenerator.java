package chapter15generics;

public class BasicalGenerator<T> implements Generator<T> {
    private Class<T> tClass;

    public BasicalGenerator(Class<T> tClass) {
        this.tClass = tClass;
    }

    @Override
    public T next() {
        try {
            return tClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> BasicalGenerator<T> create(Class<T> tClass){
        return new BasicalGenerator<>(tClass);
    }
}
