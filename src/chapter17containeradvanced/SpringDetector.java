package chapter17containeradvanced;

import java.lang.reflect.Constructor;
import java.util.HashMap;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/30
 * Mail:zhengjun1987@outlook.com
 */
public class SpringDetector {
    public static <T extends Groundhog> void detectSpring(Class<T> tClass) throws Exception {
        Constructor<T> tClassConstructor = tClass.getConstructor(int.class);
        HashMap<Groundhog, Prediction> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(tClassConstructor.newInstance(i),new Prediction());
        }
        System.out.println("map = " + map);
        Groundhog groundhog = tClassConstructor.newInstance(3);
        System.out.println("Look up for prediction of "+groundhog);
        if (map.containsKey(groundhog)) {
            System.out.println("map.get(groundhog) = " + map.get(groundhog));
        } else {
            System.out.println("Prediction not found!");
        }
    }

    public static void main(String[] args) throws Exception {
        detectSpring(Groundhog.class);
//        map = {Groundhog #0=Six more weeks of winter, Groundhog #1=Six more weeks of winter, Groundhog #2=Early spring, Groundhog #3=Early spring, Groundhog #4=Six more weeks of winter, Groundhog #5=Early spring, Groundhog #6=Early spring, Groundhog #7=Early spring, Groundhog #8=Six more weeks of winter, Groundhog #9=Six more weeks of winter}
//        Look up for prediction of Groundhog #3
//        map.get(groundhog) = Early spring
    }
}
