package chapter09interface.classprocessor;

import java.util.Arrays;
import java.util.List;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/6/27.
 */
public class Apply {
    public static final String s = "Quick fox jumps faster than lazy dog";

    public static void process(Processor processor, Object o){
        System.out.println("使用处理器:"+processor.name());
        Object process = processor.process(o);
        System.out.println("process = " + process.toString());
    }

    public static void main(String[] args) {
        process(new UpperCase(),s);
        process(new LowCase(),s);
        process(new Splitter(),s);
    }
}

interface Processor {
    String name();

    Object process(Object input);
}

class UpperCase implements Processor {
    @Override
    public String name() {
        return getClass().getSimpleName();
    }

    @Override
    public String process(Object input) {
        return input.toString().toUpperCase();
    }
}

class LowCase implements Processor {
    @Override
    public String name() {
        return getClass().getSimpleName();
    }

    @Override
    public String process(Object input) {
        return input.toString().toLowerCase();
    }
}

class Splitter implements Processor {
    @Override
    public String name() {
        return getClass().getSimpleName();
    }

    @Override
    public List<String> process(Object input) {
        return Arrays.asList(input.toString().split(" "));
    }
}