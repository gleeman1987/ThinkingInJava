package chapter08polymophism;


import chapter08polymophism.callback.Instrument;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/6/27.
 */
public class Piano implements Instrument {
    String name = "Piano";
    @Override
    public void play() {
        System.out.println(Instrument.class.getName());
        System.out.println(Instrument.class.getCanonicalName());
        System.out.println(Instrument.class.getSimpleName());
        System.out.println(Instrument.class.getTypeName());
    }

    @Override
    public void adjust() {

    }

    public static void main(String[] args) {
        new Piano().play();
    }
}
