package chapter15generics;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/16
 * Mail:zhengjun1987@outlook.com
 */
class Mime{
    public void walkAgainstTheWind(){
        System.out.println("Mime.walkAgainstTheWind");
    }

    public void sit(){
        System.out.println("Mime.sit");
    }

    public void pushInvisibleWalls(){
        System.out.println("Mime.pushInvisibleWalls");
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}

class SmartDog{
    public void sit(){
        System.out.println("SmartDog.sit");
    }

    public void speak(){
        System.out.println("SmartDog.speak Woof!");
    }

    public void reproduce(){
        System.out.println("SmartDog.reproduce");
    }
}

class CommunicateReflectively {
    public static void perform(Object args) {
        Class<?> argsClass = args.getClass();
        try {
            Method speak = argsClass.getMethod("speak");
            speak.invoke(args);
        } catch (NoSuchMethodException e) {
            System.out.println(args + " cannot speak!");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        try {
            Method sit = argsClass.getMethod("sit");
            sit.invoke(args);
        } catch (NoSuchMethodException e) {
            System.out.println(args +" cannot sit!");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
public class LatentReflection {

}
