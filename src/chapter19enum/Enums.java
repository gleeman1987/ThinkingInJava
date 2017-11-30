package chapter19enum;

import java.util.Random;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/30
 * Mail:zhengjun1987@outlook.com
 */
public class Enums {
    private static Random random = new Random(47);

    public static <T> T random(T[] values){return values[random.nextInt(values.length)];}

    public static <T extends Enum<T>> T random(Class<T> tClass){
        return random(tClass.getEnumConstants());
    }
}
