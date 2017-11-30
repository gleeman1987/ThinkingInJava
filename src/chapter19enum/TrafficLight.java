package chapter19enum;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/30
 * Mail:zhengjun1987@outlook.com
 */
enum Signal {GREEN,YELLOW,RED}

public class TrafficLight {
    private Signal signal = Signal.RED;
    public void change(){
        switch (signal) {
            case RED:
                signal = Signal.GREEN;
                break;
            case GREEN:
                signal = Signal.YELLOW;
                break;
            case YELLOW:
                signal = Signal.RED;
                break;
        }
    }

    @Override
    public String toString() {
        return "TrafficLight{" +
                "signal=" + signal +
                '}';
    }

    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();
        for (int i = 0; i < 7; i++) {
            System.out.println("trafficLight = " + trafficLight);
            trafficLight.change();
        }
//        trafficLight = TrafficLight{signal=RED}
//        trafficLight = TrafficLight{signal=GREEN}
//        trafficLight = TrafficLight{signal=YELLOW}
//        trafficLight = TrafficLight{signal=RED}
//        trafficLight = TrafficLight{signal=GREEN}
//        trafficLight = TrafficLight{signal=YELLOW}
//        trafficLight = TrafficLight{signal=RED}
    }
}
