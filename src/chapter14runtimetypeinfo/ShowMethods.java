package chapter14runtimetypeinfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

public class ShowMethods {
    private static String usage = "usage : \n" +
            "Showmethods qualified.class.name\n" +
            "To show all methods in class or\n" +
            "Showmethods qualified.class.name word\n" +
            "To search for methods involving 'word'";
    private static Pattern pattern = Pattern.compile("\\w+\\.");

    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("chapter14runtimetypeinfo.Individual");
            Method[] methods = aClass.getMethods();
            Constructor<?>[] constructors = aClass.getConstructors();
            for (Method method : methods) {
                System.out.println("method = " + method.toString());
            }
            for (Constructor<?> constructor : constructors) {
                System.out.println("constructor = " + constructor);
            }
//            method = public java.lang.String chapter14runtimetypeinfo.Individual.toString()
//            method = public long chapter14runtimetypeinfo.Individual.id()
//            method = public final void java.lang.Object.wait() throws java.lang.InterruptedException
//            method = public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
//            method = public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
//            method = public boolean java.lang.Object.equals(java.lang.Object)
//            method = public native int java.lang.Object.hashCode()
//            method = public final native java.lang.Class java.lang.Object.getClass()
//            method = public final native void java.lang.Object.notify()
//            method = public final native void java.lang.Object.notifyAll()
//            constructor = public chapter14runtimetypeinfo.Individual()
//            constructor = public chapter14runtimetypeinfo.Individual(java.lang.String)
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
