package chapter15generics;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/11
 * Mail:zhengjun1987@outlook.com
 */
public class BasicHolder<T> {
    T element;

    public void set(T element) {
        this.element = element;
    }

    public T get() {
        return element;
    }

    void f(){
        System.out.println(element.getClass().getCanonicalName());
    }
}
