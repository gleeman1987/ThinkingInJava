package chapter09interface.classprocessor;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/6/28.
 */
public class FilterProcessor {
    public static void main(String[] args) {
        Waveform waveform = new Waveform();
        Waveform waveform1 = new Waveform();
        Waveform waveform2 = new Waveform();
        Apply.process(new FilterAdapter(new HighPass(1.0)),waveform);
        Apply.process(new FilterAdapter(new LowPass(2.0)),waveform1);
        Apply.process(new FilterAdapter(new BandPass(1.0,2.2)),waveform2);
    }
}

class FilterAdapter implements Processor{

    Filter filter;

    public FilterAdapter(Filter filter) {
        this.filter = filter;
    }

    @Override
    public String name() {
        return getClass().getSimpleName();
    }

    @Override
    public Object process(Object input) {
        return filter.process((Waveform) input);
    }
}
