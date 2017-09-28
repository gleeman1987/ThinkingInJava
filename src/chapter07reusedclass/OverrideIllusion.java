package chapter07reusedclass;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/5/24.
 */
public class OverrideIllusion {
    public static void main(String[] args) {
        Amphibian frog = new Frog();
        frog.ff();
        System.out.println(frog.getAnInt());
    }
}

class Amphibian {
    public int getAnInt() {
        return anInt;
    }

    int anInt = 9;
    protected void ff(){
        System.out.println("Amphibian.ff");
    }

    protected final void g(){
        // FIXME: 2017/5/24 这个方法
        System.out.println("Amphibian.g");
    }
}

class Frog extends Amphibian{
    @Override
    public int getAnInt() {
        return anInt;
    }

    int anInt = 1;
    @Override
    protected void ff() {
        System.out.println("Frog.ff");
        super.g();
    }
}
