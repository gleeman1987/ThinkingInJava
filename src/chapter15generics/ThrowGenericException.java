package chapter15generics;

import java.util.ArrayList;
import java.util.List;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/12
 * Mail:zhengjun1987@outlook.com
 */
public class ThrowGenericException {
    public static void main(String[] args) {
        ProcessRunner<String, Failure1> processors = new ProcessRunner<>();
        for (int i = 0; i < 3; i++) {
            processors.add(new Processor1());
        }
        try {
            processors.processAll();
        } catch (Failure1 failure1) {
            failure1.printStackTrace();
        }
        ProcessRunner<Integer, Failure2> integerFailure2ProcessRunner = new ProcessRunner<>();
        for (int i = 0; i < 2; i++) {
            integerFailure2ProcessRunner.add(new Processor2());
        }
        try {
            integerFailure2ProcessRunner.processAll();
        } catch (Failure2 failure2) {
            failure2.printStackTrace();
        }
    }
}

interface Processor<T , E extends Exception> {
    void process(List<T> resultCollector) throws E;
}

class ProcessRunner<T, E extends Exception> extends ArrayList<Processor<T,E>>{
    List<T> processAll() throws E {
        List<T> resultCollector = new ArrayList<>();
        for (Processor<T, E> processor : this) {
            processor.process(resultCollector);
        }
        return resultCollector;
    }
}

class Failure1 extends Exception {}

class Processor1 implements Processor<String,Failure1>{
    static int count = 3;
    @Override
    public void process(List<String> resultCollector) throws Failure1 {
        if (count-- > 1) {
            resultCollector.add("Hep!");
        } else {
            resultCollector.add("Ho!");
        }
        if (count < 0){
            throw new Failure1();
        }
    }
}

class Failure2 extends Exception {
    public Failure2(String s) {
        super(s);
    }
}

class Processor2 implements Processor<Integer,Failure2>{
    static int count = 2;
    @Override
    public void process(List<Integer> resultCollector) throws Failure2 {
        if (count-- == 0){
            resultCollector.add(47);
        } else {
            resultCollector.add(11);
        }
        if (count < 0){
            throw new Failure2("count should not be negtive");
        }
    }
}