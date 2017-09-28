package chapter15generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/9/27.
 */
public class LostInformation {
    public static void main(String[] args) {
        ArrayList<Frob> frobs = new ArrayList<>();
        HashMap<Frob, Fnorkle> fnorkleHashMap = new HashMap<>();
        Quark<Fnorkle> quark = new Quark<>();
        Particle<Long, Double> particle = new Particle<>();
        System.out.println(Arrays.toString(frobs.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(fnorkleHashMap.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(quark.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(particle.getClass().getTypeParameters()));
//        [E]
//        [K, V]
//        [Q]
//        [POSITION, MOMENTUM]
        //通过类型信息获取到的类型参数(TypeParameters)只是用作参数占位符的标识符,而无法获取到任何有关真实泛型类型参数的信息
    }
}

class Frob {}

class Fnorkle {}

class Quark<Q> {}

class Particle<POSITION,MOMENTUM>{}

