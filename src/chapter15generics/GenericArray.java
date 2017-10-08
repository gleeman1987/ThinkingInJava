package chapter15generics;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/5.
 */
public class GenericArray<T> {
    T[] array;

    public GenericArray(int size) {
        this.array = (T[]) new Object[size];
    }

    public void put(int index,T item){
        array[index] = item;
    }

    public T get(int index){
        return array[index];
    }

    public T[] rep(){
        return array;
    }

    public static void main(String[] args) {
        GenericArray<Integer> integerGenericArray = new GenericArray<>(10);
        for (int i = 0; i < 10; i++) {
            integerGenericArray.put(i,i*10);
        }
//        Integer[] rep = integerGenericArray.rep();此处出错,无法强转成T[]
        Object[] rep = integerGenericArray.rep();
        for (Object integer : rep) {
            System.out.print(integer + "  ");
        }
    }
}
