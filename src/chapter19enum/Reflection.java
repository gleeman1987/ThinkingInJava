package chapter19enum;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/30
 * Mail:zhengjun1987@outlook.com
 */
enum Explorer {HERE,THERE}

public class Reflection {
    public static Set<String> analyze(Class<?> enumClass){
        System.out.println("Reflection.analyze-----------------------enumClass = " + enumClass);
        System.out.println("Interfaces:");
        for (Type type : enumClass.getGenericInterfaces()) {
            System.out.println("type = " + type);
        }
        System.out.println("Base: "+enumClass.getSuperclass());
        System.out.println("Methods:");
        TreeSet<String> strings = new TreeSet<>();
        for (Method method : enumClass.getMethods()) {
            strings.add(method.getName());
        }
        System.out.println("" + strings);
        return strings;
    }

    public static void main(String[] args) {
        Set<String> strings = analyze(Explorer.class);
        Set<String> analyze = analyze(Enum.class);
        System.out.println("-------------------------------------------------");
        System.out.println("(strings.containsAll(analyze)) = " + (strings.containsAll(analyze)));
        System.out.println("(strings.removeAll(analyze)) = " + (strings.removeAll(analyze)));
        System.out.println("strings = " + strings);
    }
//    Reflection.analyze-----------------------enumClass = class chapter19enum.Explorer
//    Interfaces:
//    Base: class java.lang.Enum
//    Methods:
//            [compareTo, equals, getClass, getDeclaringClass, hashCode, name, notify, notifyAll, ordinal, toString, valueOf, values, wait]
//    Reflection.analyze-----------------------enumClass = class java.lang.Enum
//    Interfaces:
//    type = java.lang.Comparable<E>
//    type = interface java.io.Serializable
//    Base: class java.lang.Object
//    Methods:
//            [compareTo, equals, getClass, getDeclaringClass, hashCode, name, notify, notifyAll, ordinal, toString, valueOf, wait]
//    -------------------------------------------------
//    (strings.containsAll(analyze)) = true
//    (strings.removeAll(analyze)) = true
//    strings = [values]
}
