package chapter16arrays;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/24
 * Mail:zhengjun1987@outlook.com
 */
public class ArrayOfGenericType<T> {
    T[] array;

    public ArrayOfGenericType(int size) {
        this.array = (T[])new Object[size];
    }

//    public <U> U[] makeArray(){ return new U[10]}
}
