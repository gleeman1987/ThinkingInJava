package chapter10;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/6/29.
 */
public class DotThis {
    void f(){
        System.out.println("DotThis.f");
    }

    private class Inner{
        public DotThis outer(){
            return DotThis.this;
        }
    }

    public Inner inner(){
        return new Inner();
    }

    public static void main(String[] args) {
        DotThis dotThis = new DotThis();
        Inner inner = dotThis.new Inner(){
            @Override
            public DotThis outer() {
                return super.outer();
            }
        };
        inner.outer().f();
    }
}
