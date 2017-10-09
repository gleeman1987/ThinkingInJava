package chapter15generics;

import java.awt.*;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/9
 * Mail:zhengjun1987@outlook.com
 */
public class InheritBounds {
    public static void main(String[] args) {
        Solid2<Bounded> boundedSolid2 = new Solid2<>(new Bounded());
        boundedSolid2.getColor();
        boundedSolid2.getY();
        boundedSolid2.weight();
    }
}

class HoldItem<T> {
    T item;

    public HoldItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}

class Colored2<T extends HasColor> extends HoldItem<T>{

    public Colored2(T item) {
        super(item);
    }

    public Color getColor() {
        return item.getColor();
    }
}

class ColoredDimension2<T extends Dimension & HasColor> extends Colored2<T>{

    public ColoredDimension2(T item) {
        super(item);
    }

    int getX(){
        return item.x;
    }

    int getY(){
        return item.y;
    }

    int getZ(){
        return item.z;
    }
}

class Solid2<T extends Dimension & HasColor & Weight> extends ColoredDimension2<T>{

    public Solid2(T item) {
        super(item);
    }

    public int weight() {
        return item.weight();
    }
}


