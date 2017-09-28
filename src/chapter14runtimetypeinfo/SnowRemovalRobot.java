package chapter14runtimetypeinfo;

import java.util.Arrays;
import java.util.List;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/9/23.
 */
interface Operation {
    String description();
    void command();
}

interface Robot {
    String name();
    String model();
    List<Operation> operations();
    class Test  {
        public static void test(Robot robot){
            if (robot instanceof Null) {
                System.out.println("robot = [ Null ]");
            }
            System.out.println("Name : "+robot.name());
            System.out.println("Model : "+robot.model());
            for (Operation operation : robot.operations()) {
                System.out.println("Operation : "+operation.description());
                operation.command();
            }
        }
    }
}

public class SnowRemovalRobot implements Robot {
    private String name;

    public SnowRemovalRobot(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String model() {
        return "SnowBot Series 11";
    }

    @Override
    public List<Operation> operations() {
        return Arrays.asList(
                new Operation() {
                    @Override
                    public String description() {
                        return name + " can shovel snow";
                    }

                    @Override
                    public void command() {
                        System.out.println(name + " shoveling snow now");
                    }
                },
                new Operation() {
                    @Override
                    public String description() {
                        return name + " can chip ice";
                    }

                    @Override
                    public void command() {
                        System.out.println(name + " chiping ice now");
                    }
                },
                new Operation() {
                    @Override
                    public String description() {
                        return name + "can clear roof";
                    }

                    @Override
                    public void command() {
                        System.out.println(name + " clearing roof now");
                    }
                }
        );
    }

    public static void main(String[] args) {
        Robot.Test.test(new SnowRemovalRobot("Slusher"));
//        Name : Slusher
//        Model : SnowBot Series 11
//        Operation : Slusher can shovel snow
//        Slusher shoveling snow now
//        Operation : Slusher can chip ice
//        Slusher chiping ice now
//        Operation : Slushercan clear roof
//        Slusher clearing roof now
    }
}
