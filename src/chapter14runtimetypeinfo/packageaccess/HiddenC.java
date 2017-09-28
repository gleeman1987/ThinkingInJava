package chapter14runtimetypeinfo.packageaccess;

import chapter14runtimetypeinfo.A;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/9/24.
 */
public class HiddenC {
    public static A makeA(){
        return new C();
    }
}

class C implements A {

    @Override
    public void f() {
        System.out.println("public C.f()");
    }

    public void g(){
        System.out.println("public C.g()");
    }

    void u(){
        System.out.println("package C.u()");
    }

    protected void v(){
        System.out.println("protected C.v()");
    }

    private void w(){
        System.out.println("private C.w()");
    }
}
