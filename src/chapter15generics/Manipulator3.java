package chapter15generics;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/9/27.
 */
public class Manipulator3 {
    private HasF hasF;

    public Manipulator3(HasF hasF) {
        this.hasF = hasF;
    }

    public void manipulate(){
        hasF.f();
    }
}
