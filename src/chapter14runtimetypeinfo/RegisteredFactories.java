package chapter14runtimetypeinfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/9/22.
 */
public class RegisteredFactories {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Part.createRandom());
        }
    }
}

class Part {
    static List<Factory<? extends Part>> partFactories = new ArrayList<>();
    static {
        System.out.println("Part.static initializer");
        partFactories.add(new FuelFilter.Factory());
        partFactories.add(new AirFilter.Factory());
        partFactories.add(new CabinAirFilter.Factory());
        partFactories.add(new FanBelt.Factory());
        partFactories.add(new GeneratorBelt.Factory());
        partFactories.add(new PowerSteeringBelt.Factory());
    }
    private static Random random = new Random(47);

    public static Part createRandom(){
        int nextInt = random.nextInt(partFactories.size());
        return partFactories.get(nextInt).create();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}

class Filter extends Part {}

class FuelFilter extends Filter {
    public static class Factory implements chapter14runtimetypeinfo.Factory<FuelFilter>{

        @Override
        public FuelFilter create() {
            return new FuelFilter();
        }
    }
}

class AirFilter extends Filter {
    public static class Factory implements chapter14runtimetypeinfo.Factory<AirFilter>{

        @Override
        public AirFilter create() {
            return new AirFilter();
        }
    }
}

class CabinAirFilter extends Filter {
    public static class Factory implements chapter14runtimetypeinfo.Factory<CabinAirFilter>{

        @Override
        public CabinAirFilter create() {
            return new CabinAirFilter();
        }
    }
}

class Belt extends Part {}

class FanBelt extends Belt {
    public static class Factory implements chapter14runtimetypeinfo.Factory<FanBelt>{

        @Override
        public FanBelt create() {
            return new FanBelt();
        }
    }
}

class GeneratorBelt extends Belt {
    public static class Factory implements chapter14runtimetypeinfo.Factory<GeneratorBelt>{

        @Override
        public GeneratorBelt create() {
            return new GeneratorBelt();
        }
    }
}

class PowerSteeringBelt extends Belt {
    public static class Factory implements chapter14runtimetypeinfo.Factory<PowerSteeringBelt>{

        @Override
        public PowerSteeringBelt create() {
            return new PowerSteeringBelt();
        }
    }
}