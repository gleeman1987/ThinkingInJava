package chapter14runtimetypeinfo;

import java.util.Arrays;
import java.util.List;

public abstract class Shape {
    void draw(){
        System.out.println(this + "  draw");
        //此处先调用各实现类实例对象的this的toString(),再append一个字符串
    }
    abstract public String toString();//使用abstract强制子类重写本方法
}

class Circle extends Shape {

    @Override
    public String toString() {
//        System.out.println("Circle.toString");
        return "Circle";
    }
}

class Square extends Shape {

    @Override
    public String toString() {
//        System.out.println("Square.toString");
        return "Square";
    }
}

class Triangle extends Shape {

    @Override
    public String toString() {
//        System.out.println("Triangle.toString");
        return "Triangle";
    }
}

class Rhomboid extends Shape {

    @Override
    public String toString() {
//        System.out.println("Triangle.toString");
        return "Rhomboid";
    }
}

class Shapes {
    public static void main(String[] args) {
        List<Shape> shapes = Arrays.asList(new Circle(), new Triangle(), new Square(),new Rhomboid());
        //对于数组而言,所有个体都是Shape类型,而忽略了具体的实际类型

        for (Shape shape : shapes) {
            shape.draw();//多态机制
        }
//        Circle  draw
//        Triangle  draw
//        Square  draw

        Shape shape = new Rhomboid();
        Rhomboid rhomboid = (Rhomboid)shape;
        System.out.println("rhomboid = " + rhomboid);
        Circle circle = (Circle)shape;//Exception in thread "main" java.lang.ClassCastException : chapter14runtimetypeinfo.Rhomboid cannot be cast to chapter14runtimetypeinfo.Circle
        System.out.println("circle = " + circle);
    }
}
