package chapter10innerclass;

import java.util.ArrayList;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/7/6.
 */
public class Practice23 {
    public static void main(String[] args) {
        PB pb = new PB();
        pb.add(new PA().getU());
        pb.add(new PA().getU());
        pb.add(new PA().getU());
        pb.play();
    }
}

interface U{
    void method1();
    void method2();
    void method3();
}

class PB{
    private ArrayList<U> arr = new ArrayList<U>();
    public void add(U u){
        arr.add(u);
    }
    public void clear(){
        arr.clear();
    }
    public void play(){
        for (U u : arr) {
            u.method1();
            u.method2();
            u.method3();
        }
    }
}

class PA {
    U getU(){
        return new U() {
            @Override
            public void method1() {
                System.out.println("PA.method1");
            }

            @Override
            public void method2() {
                System.out.println("PA.method2");
            }

            @Override
            public void method3() {
                System.out.println("PA.method3");
            }
        };
    }
}


