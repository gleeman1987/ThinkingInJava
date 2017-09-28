package chapter20annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/6/19.
 */
public class UseCaseTracker {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        Collections.addAll(integers,45,46,47,48);
        trackUseCases(integers,PasswordUtils.class);
    }

    public static void trackUseCases(List<Integer> useCases,Class clazz){
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println("method:"+method);
            UseCase useCase = method.getAnnotation(UseCase.class);
            if (useCase != null) {
                System.out.println("useCase = " + useCase.id() + " description = "+useCase.description());
                useCases.remove(new Integer(useCase.id()));
            }
        }
        for (Integer useCase : useCases) {
            System.out.println("找不到id为"+useCase + "的注解");
        }
    }
}
