package chapter17containeradvanced;

import java.util.Random;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/30
 * Mail:zhengjun1987@outlook.com
 */
public class Prediction {
    private static Random random = new Random(47);
    private boolean shadow = random.nextDouble() > 0.5;

    @Override
    public String toString() {
        return shadow?"Six more weeks of winter":"Early spring";
    }
}
