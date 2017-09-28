package chapter05initialization;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/1/8.
 */
public class TankGabageCollection {
    public static void main(String[] args) {
        Tank tank = new Tank(true);
        tank.emptyTank();
        new Tank(true);
        new Tank(true);
        new Tank(false);
        new Tank(true);
        System.gc();
    }
}

class Tank {
    boolean isFull = false;

    public Tank(boolean isFull) {
        this.isFull = isFull;
    }

    void emptyTank(){
        isFull = false;
    }

    @Override
    protected void finalize() throws Throwable {
        if (isFull) {
            System.out.println("Error:Please Empty this instance before finalize!");
        }
    }
}
