package chapter15generics;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/10
 * Mail:zhengjun1987@outlook.com
 */
public class GenericsHolder<T> {
    private T value;

    public GenericsHolder(T value) {
        this.value = value;
    }

    public GenericsHolder() {
    }

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        return value.equals(obj);
    }

    public static void main(String[] args) {
        GenericsHolder<Apple> appleGenericsHolder = new GenericsHolder<>(new Apple());
        Apple apple = appleGenericsHolder.get();
        appleGenericsHolder.set(apple);

//        GenericsHolder<Fruit> fruitGenericsHolder = appleGenericsHolder;此写法不通
        GenericsHolder<? extends Fruit> fruitGenericsHolder = appleGenericsHolder;
        Fruit fruit = fruitGenericsHolder.get();
        System.out.println("appleGenericsHolder.equals(fruit) = " + appleGenericsHolder.equals(fruit));
        //appleGenericsHolder.equals(fruit) = true
        Apple fruit1 = (Apple) fruitGenericsHolder.get();

        try {
            Orange o = (Orange) fruitGenericsHolder.get();
        } catch (Exception e) {
            e.printStackTrace();
//            java.lang.ClassCastException: chapter15generics.Apple cannot be cast to chapter15generics.Orange
        }
    }
}
