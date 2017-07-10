package chapter10;

import chapter10.controller.Controller;
import chapter10.controller.Event;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/7/6.
 */
public class GreenhouseController extends Controller {
    private boolean lightOn = false;

    public class LightOn extends Event {
        protected LightOn(int delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            lightOn = true;
        }

        @Override
        public String toString() {
            return "Light is on";
        }
    }

    public class LightOff extends Event{
        protected LightOff(int delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            lightOn = false;
        }

        @Override
        public String toString() {
            return "Light is off";
        }
    }
    private boolean waterOn = false;

    public class WaterOn extends Event {
        protected WaterOn(int delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            waterOn = true;
        }

        @Override
        public String toString() {
            return "water is on";
        }
    }

    public class WaterOff extends Event{
        protected WaterOff(int delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            waterOn = false;
        }

        @Override
        public String toString() {
            return "water is off";
        }
    }


    @Override
    public boolean add(Event event) {
        return super.add(event);
    }

    @Override
    public void run() {
        super.run();
    }
}
