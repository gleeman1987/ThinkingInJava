package chapter08polymophism;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/5/27.
 */
public class Cycle {
    public static void main(String[] args) {
        Cycle cycle = new Cycle();
        UniCycle cycle1 = new UniCycle();
        cycle.ride(cycle1);
        cycle.ride(new BiCycle());
        cycle.ride(new TriCycle());
    }

    public void ride(BaseCycle cycle){
        cycle.run();
        System.out.println("cycle = [" + cycle.getWheels() + "]");
    }
}

class BaseCycle {
    public int getDiameter() {
        return diameter;
    }

    private void print(){
        System.out.println("BaseCycle.print");
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    protected int wheels = 0;
    protected int diameter = 1;

    @Override
    public String toString() {
        return this.getClass().getName()+
                "  diameter=" + diameter;
    }

    public void run(){
        System.out.println("BaseCycle.run");
    }
}

class UniCycle extends BaseCycle {
    public UniCycle() {
        wheels = 1;
    }

    public void print(){
        System.out.println("UniCycle.print");
    }

    @Override
    public void run() {
        System.out.println("UniCycle.run");
    }
}

class BiCycle extends BaseCycle {
    @Override
    public int getWheels() {
        return wheels;
    }

    protected int wheels = 8;

    public BiCycle() {
        super.wheels = 2;
    }

    @Override
    public void run() {
        System.out.println("BiCycle.run");
    }
}

class TriCycle extends BaseCycle {
    public TriCycle() {
        wheels = 3;
    }

    @Override
    public void run() {
        System.out.println("TriCycle.run");
    }
}