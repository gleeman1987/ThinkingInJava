package chapter15generics;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/17
 * Mail:zhengjun1987@outlook.com
 */
public class Apply {
    public static <T,S extends Iterable<? extends T>> void apply(S sequence, Method method,Object... args){
        try {
            for (T t : sequence) {
                method.invoke(t,args);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

class Shape {
    public void rotate(){
        System.out.println(this.getClass().getSimpleName() + " ROTATE");
    }

    public void resize(int size){
        System.out.println(this +" RESIZE "+size);
    }
}

class Sqare extends Shape{}

class FilledList<T> extends ArrayList<T>{
    public FilledList(Class<T> tClass,int initialCapacity) {
        super(initialCapacity);
        try {
            for (int i = 0; i < initialCapacity; i++) {
                add(tClass.newInstance());
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

class ApplyTest {
    public static void main(String[] args) throws Exception {
        ArrayList<Shape> shapes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            shapes.add(new Shape());
        }
        Apply.apply(shapes,Shape.class.getMethod("rotate"));
        Apply.apply(shapes,Shape.class.getMethod("resize", int.class),5);

        System.out.println("-----------------------------------");

        List<Sqare> sqares = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            sqares.add(new Sqare());
        }
        Apply.apply(sqares,Sqare.class.getMethod("rotate"));
        Apply.apply(sqares,Sqare.class.getMethod("resize",int.class),5);

        System.out.println("-----------------------------------");

        Apply.apply(new FilledList<Shape>(Shape.class,10),Shape.class.getMethod("rotate"));
        Apply.apply(new FilledList<Sqare>(Sqare.class,10),Shape.class.getMethod("rotate"));

        System.out.println("-----------------------------------");

        SimpleQueue<Shape> shapeSimpleQueue = new SimpleQueue<>();
        for (int i = 0; i < 5; i++) {
            shapeSimpleQueue.add(new Shape());
            shapeSimpleQueue.add(new Sqare());
        }
        Apply.apply(shapeSimpleQueue,Shape.class.getMethod("rotate"));
    }
}