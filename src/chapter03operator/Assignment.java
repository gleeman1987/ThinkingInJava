package chapter03operator;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/1/7.
 */
public class Assignment {
    public static void main(String[] args) {
        Tank tank1 = new Tank();
        Tank tank2 = new Tank();
        tank1.level = 12;
        tank2.level = 27;
        say(tank1, tank2);
        tank1.level = tank2.level;
        say(tank1, tank2);
        tank1.level = 29;
        say(tank1, tank2);

    }

    private static void say(Tank tank1, Tank tank2) {
        System.out.println("1--"+tank1+"--tank1.level:"+tank1.level+"--"+tank2+"--tank2.level:"+tank2.level);
    }

    static class Tank{
        float level;
    }
}
