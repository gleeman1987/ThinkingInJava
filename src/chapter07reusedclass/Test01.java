package chapter07reusedclass;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/5/24.
 */
public class Test01 {
    public static void main(String[] args) {
        Wind instrument = new Wind();
        Instrument.test(instrument);
        instrument.flue();
    }
}

class Instrument {
    void play(){
        System.out.println("Instrument.play");
    }

    static void test(Instrument instrument){
        instrument.play();
    }
}

class Wind extends Instrument{
    public static final int WIND_SIZE_CONSTANT = 18;
    private final int s ;

    public Wind() {
        s = WIND_SIZE_CONSTANT;
    }

    public Wind(int s) {
        this.s = s;
    }

    @Override
    void play() {
        System.out.println("Wind.play");
    }

    void flue(){
        System.out.println("Wind.flue size:"+getSize());
    }

    public int getSize() {
        return s;
    }
}
