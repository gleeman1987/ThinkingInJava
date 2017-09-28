package chapter11objectcontainer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/9/14.
 */
public class AsListInterface {
    public static void main(String[] args) {
        List<Snow> snows = Arrays.asList(new Powder(), new Slush(), new Crusty());
        System.out.println("snows = " + snows);

        List<Snow> powders = Arrays.asList(new Heavy(), new Light(),new Crusty(),new Slush());
        System.out.println("powders = " + powders);

        ArrayList<Snow> snowArrayList = new ArrayList<>();
        Collections.addAll(snowArrayList,new Crusty(),new Heavy(),new Light(),new Slush());
        System.out.println("snowArrayList = " + snowArrayList);

        List<Snow> snowList = Arrays.asList(new Crusty(), new Heavy(), new Light(), new Slush());
        System.out.println("snowList = " + snowList);

//        snows = [chapter11objectcontainer.Powder@610455d6, chapter11objectcontainer.Slush@511d50c0, chapter11objectcontainer.Crusty@60e53b93]
//        powders = [chapter11objectcontainer.Heavy@5e2de80c, chapter11objectcontainer.Light@1d44bcfa, chapter11objectcontainer.Crusty@266474c2, chapter11objectcontainer.Slush@6f94fa3e]
//        snowArrayList = [chapter11objectcontainer.Crusty@5e481248, chapter11objectcontainer.Heavy@66d3c617, chapter11objectcontainer.Light@63947c6b, chapter11objectcontainer.Slush@2b193f2d]
//        snowList = [chapter11objectcontainer.Crusty@355da254, chapter11objectcontainer.Heavy@4dc63996, chapter11objectcontainer.Light@d716361, chapter11objectcontainer.Slush@6ff3c5b5]
    }
}

class Snow{}

class Powder extends Snow {}

class Light extends Powder {}

class Heavy extends Powder {}

class Crusty extends Snow {}

class Slush extends Snow {}

