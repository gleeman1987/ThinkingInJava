package chapter15generics;

import java.lang.reflect.Array;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/9
 * Mail:zhengjun1987@outlook.com
 */
public class GenericArrayWithTypeToken<T> {
    private T[] array;

    public GenericArrayWithTypeToken(Class<T> tClass,int size) {
        this.array = (T[]) Array.newInstance(tClass,size);//java.lang.ClassCastException: [I cannot be cast to [Ljava.lang.Object
    }

    public void put(int index,T t){
        array[index] = t;
    }

    public T get(int index){
        return array[index];
    }

    public T[] rep(){
        return array;
    }

    public static void main(String[] args) {
        GenericArrayWithTypeToken<Integer> integerGenericArrayWithTypeToken = new GenericArrayWithTypeToken<>(Integer.class,10);
        for (int i = 0; i < 10; i++) {
            integerGenericArrayWithTypeToken.put(i,i*8);
        }
        Integer[] rep = integerGenericArrayWithTypeToken.rep();
        for (Integer integer : rep) {
            System.out.println("integer = " + integer);
        }
    }
}
