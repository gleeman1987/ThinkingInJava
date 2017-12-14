package chapter21concurrent;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/12/14
 * Mail:zhengjun1987@outlook.com
 */
abstract class Parent{
    public synchronized void f(){
        for (int i = 0; i < 5; i++) {
            System.out.println(MyUtils.getCurrentTime() + "Parent.f  " + "");
            Thread.yield();
        }
    }

    abstract void g();
}

class Child extends Parent{
//    public synchronized void f(){
//        for (int i = 0; i < 5; i++) {
//            System.out.println(MyUtils.getCurrentTime() + "Child.f  " + "");
//            Thread.yield();
//        }
//    }
    //g()的同步锁为Child.this时g()与f()是线程互斥的,说明在方法修饰符synchronized使用的默认同步锁就是<ClassName>.this
//2017-12-14 11:39:46:376  Child.f
//2017-12-14 11:39:46:376  Child.f
//2017-12-14 11:39:46:392  Child.f
//2017-12-14 11:39:46:392  Child.f
//2017-12-14 11:39:46:392  Child.f
//2017-12-14 11:39:46:392  Child.g
//2017-12-14 11:39:46:392  Child.g
//2017-12-14 11:39:46:392  Child.g
//2017-12-14 11:39:46:392  Child.g
//2017-12-14 11:39:46:392  Child.g

    @Override
    void g() {
        synchronized (Child.this) {
            for (int i = 0; i < 5; i++) {
                System.out.println(MyUtils.getCurrentTime() + "Child.g  " + "");
                Thread.yield();
            }
        }
    }
}

public class ExtensionSynch {
    public static void main(String[] args) {
        Child child = new Child();
        new Thread(){
            @Override
            public void run() {
                child.g();
            }
        }.start();
        child.f();//子类实例调用抽象父类的具体方法时,父类方法中使用synchronized关键字的默认同步锁与子类同步锁是同一个<ClassName>.this
    }
//2017-12-14 11:00:53:951  Child.g
//2017-12-14 11:00:53:952  Child.g
//2017-12-14 11:00:53:952  Child.g
//2017-12-14 11:00:53:952  Child.g
//2017-12-14 11:00:53:952  Child.g
//2017-12-14 11:00:53:952  Parent.f
//2017-12-14 11:00:53:953  Parent.f
//2017-12-14 11:00:53:953  Parent.f
//2017-12-14 11:00:53:953  Parent.f
//2017-12-14 11:00:53:953  Parent.f
//
//    Process finished with exit code 0
}
