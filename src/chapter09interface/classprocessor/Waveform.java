package chapter09interface.classprocessor;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/6/28.
 */
public class Waveform {
    private static long counter;
    private final long id = counter++;

    @Override
    public String toString() {
        return "Waveform{" +
                "id=" + id +
                '}';
    }
}

class Filter {
    public String name(){
        return getClass().getSimpleName();
    }

    public Waveform process(Waveform input){
        return input;
    }
}

class LowPass extends Filter{
    double cutoff;

    public LowPass(double cutoff) {
        this.cutoff = cutoff;
    }

    @Override
    public Waveform process(Waveform input) {
        return input;
    }
}

class HighPass extends Filter{
    double cutoff;

    public HighPass(double cutoff) {
        this.cutoff = cutoff;
    }

    @Override
    public Waveform process(Waveform input) {
        return input;
    }
}

class BandPass extends Filter{
    double highCut,lowCut;

    public BandPass(double highCut,double lowCut) {
        this.highCut = highCut;
        this.lowCut = lowCut;
    }

    @Override
    public Waveform process(Waveform input) {
        return input;
    }
}
