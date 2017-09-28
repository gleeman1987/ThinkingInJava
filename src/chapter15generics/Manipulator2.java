package chapter15generics;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/9/27.
 */
public class Manipulator2<T extends HasF> {
    private T t;

    public Manipulator2(T t) {
        this.t = t;
    }

    public void manipulate(){
        t.f();
    }
}
