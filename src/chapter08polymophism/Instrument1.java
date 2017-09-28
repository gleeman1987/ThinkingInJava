package chapter08polymophism;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/6/27.
 */
public abstract class Instrument1 {
    void play() {
        System.out.println("Instrument1.play");
    }

    String what(){
        System.out.println("Instrument1.what");
        return Instrument1.class.getName();
    }

    void adjust(){
        System.out.println("Instrument1.adjust");
    };

    public static void main(String[] args) {
        Instrument1 instrument = new Wind();
        instrument.adjust();
        System.out.println(instrument.what());
    }
}

class Wind extends Instrument1 {

}