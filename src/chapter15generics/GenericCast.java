package chapter15generics;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/11
 * Mail:zhengjun1987@outlook.com
 */
class FixedSizeStack<T>{
    private int index = 0;
    private Object[] storage;

    public FixedSizeStack(int size) {
        this.storage = new Object[size];
    }

    public void push(T item){
        storage[index++] = item;
    }

    public T pop(){
        return (T) storage[--index];//Unchecked cast
    }
}

public class GenericCast {
    public static final int SIZE = 10;
    public static void main(String[] args) {
        FixedSizeStack<String> stringFixedSizeStack = new FixedSizeStack<>(SIZE);
        for (String s : "ABCDEFGHIJ".split("")) {
            stringFixedSizeStack.push(s);
        }
        for (int i = 0; i < SIZE; i++) {
            System.out.print(stringFixedSizeStack.pop()+" ");
        }
    }
}
