package chapter08polymophism.callback;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/6/27.
 */
public interface Instrument {
    String name = Instrument.class.getCanonicalName();
    void play();
    void adjust();
}
