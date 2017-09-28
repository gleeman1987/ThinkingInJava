package chapter14runtimetypeinfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.List;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/9/23.
 */
public class NullRobot {
    public static void main(String[] args) {
        SnowRemovalRobot snowBee = new SnowRemovalRobot("SnowBee");
        Robot.Test.test(snowBee);
        System.out.println("-------------------------");
        Robot robot = newNullRobot(SnowRemovalRobot.class);
        Robot.Test.test(robot);
    }

    public static Robot newNullRobot(Class<? extends Robot> c){
        System.out.println("c = [" + c + "]");
        return (Robot) Proxy.newProxyInstance(NullRobot.class.getClassLoader(),new Class[]{Null.class, Robot.class},new NullRobotProxyHandler(c));
    }
}

class NullRobotProxyHandler implements InvocationHandler {
    private String nullName;
    private Robot proxied = new NRobot();
    public NullRobotProxyHandler(Class<? extends Robot> type) {
        nullName = type.getSimpleName() + " NullRobot";
    }

    private class NRobot implements Null, Robot {

        @Override
        public String name() {
            return nullName;
        }

        @Override
        public String model() {
            return nullName;
        }

        @Override
        public List<Operation> operations() {
            return Collections.emptyList();
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("method = [" + method + "], args = [" + args + "]");
        return method.invoke(proxied,args);
    }
}
