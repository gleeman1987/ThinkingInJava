package chapter19enum;

import java.util.EnumSet;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/12/1
 * Mail:zhengjun1987@outlook.com
 */
public class CarWash {
    public enum Cycle {
        UNSERBODY {
            @Override
            void action() {
                System.out.println("Spraying the underbody");
            }
        },HOTWAX {
            @Override
            void action() {
                System.out.println("Applying hot wax");
            }
        },WHEELWASH {
            @Override
            void action() {
                System.out.println("Washing the wheels");
            }
        },PREWASH {
            @Override
            void action() {
                System.out.println("Loosening the dirt");
            }
        },BASIC {
            @Override
            void action() {
                System.out.println("The basic wash");
            }
        },RINSE {
            @Override
            void action() {
                System.out.println("Rinsing");
            }
        },BLOWDRY {
            @Override
            void action() {
                System.out.println("Blowing dry");
            }
        };
        abstract void action();
    }

    EnumSet<Cycle> enumSet = EnumSet.of(Cycle.BASIC,Cycle.RINSE);

    public boolean add(Cycle cycle) {
        return enumSet.add(cycle);
    }

    public void washCar(){
        for (Cycle cycle : enumSet) {
            cycle.action();
        }
    }

    @Override
    public String toString() {
        return "CarWash{" +
                "enumSet=" + enumSet +
                '}';
    }

    public static void main(String[] args) {
        CarWash carWash = new CarWash();
        System.out.println("carWash = " + carWash);
        carWash.washCar();
//        carWash = CarWash{enumSet=[BASIC, RINSE]}
//        The basic wash
//        Rinsing

        carWash.add(Cycle.BLOWDRY);
        carWash.add(Cycle.BLOWDRY);
        carWash.add(Cycle.RINSE);
        carWash.add(Cycle.HOTWAX);
        System.out.println("carWash = " + carWash);
        carWash.washCar();
//        carWash = CarWash{enumSet=[HOTWAX, BASIC, RINSE, BLOWDRY]}
//        Applying hot wax
//        The basic wash
//        Rinsing
//        Blowing dry
    }
}
