package chapter10innerclass;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/7/5.
 */
public interface ClassInInterface {
    void howdy();
    class Test implements ClassInInterface{
        @Override
        public void howdy() {
            System.out.println("Test.howdy");
        }
        public static void main(String[] args) {
            new Test().howdy();
        }

    }
}

class TestBed {
    void f(){
        System.out.println("TestBed.f");
    }

    public static void main(String[] args) {
        TestBed testBed = new TestBed();
        testBed.f();
    }
}
