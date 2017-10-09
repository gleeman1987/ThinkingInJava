package chapter15generics;

import java.awt.*;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/9
 * Mail:zhengjun1987@outlook.com
 */
interface HasColor {
    Color getColor();
}

class Colored<T extends HasColor> {
    T item;

    public Colored(T item) {
        this.item = item;
    }

    T getItem(){
        return item;
    }

    public Color getColor() {
        return item.getColor();
    }
}

class Dimension {
    public int x,y,z;
}

class ColoredDimension<T extends Dimension & HasColor>{
    T item;

    public ColoredDimension(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    Color getColor(){
        return item.getColor();
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

interface Weight {
    int weight();
}

class Solid <T extends Dimension & HasColor & Weight> {
    T item;

    public Solid(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public Color getColor() {
        return item.getColor();
    }

    public int weight() {
        return item.weight();
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

class Bounded extends Dimension implements HasColor,Weight {

    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public int weight() {
        return 0;
    }
}

public class BasicBounds {
    public static void main(String[] args) {
        Solid<Bounded> boundedSolid = new Solid<>(new Bounded());
        boundedSolid.getColor();
        boundedSolid.getY();
        boundedSolid.weight();
    }
}
