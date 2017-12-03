package chapter20annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Authur:zhengjun
 * E-mail:zhengjun1987@outlook.com
 * Date:2017/12/3
 * Project:ThinkingInJava
 */
public class UseCaseTracker {
    public static void trackUseCases(List<Integer> useCases,Class<?> clazz){
        System.out.println("UseCaseTracker.trackUseCases  " + "useCases = [" + useCases + "], clazz = [" + clazz + "]");
        for (Method method : clazz.getDeclaredMethods()) {
            UseCase annotation = method.getAnnotation(UseCase.class);
            if (annotation != null) {
                System.out.println("Found annotation.id() = " + annotation.id()+"  annotation.description() = " + annotation.description());
                useCases.remove(new Integer(annotation.id()));
            }
        }
        for (Integer useCase : useCases) {
            System.out.println("Warning: Missing use case "+ useCase);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        Collections.addAll(integers,47,48,49,50);
        trackUseCases(integers,PasswordUtils.class);
    }
//    UseCaseTracker.trackUseCases  useCases = [[47, 48, 49, 50]], clazz = [class chapter20annotation.PasswordUtils]
//    Found annotation.id() = 47  annotation.description() = password must contain at least one numeric
//    Found annotation.id() = 48  annotation.description() = No description
//    Found annotation.id() = 49  annotation.description() = New password cannot equals previously used ones
//    Warning: Missing use case 50
}
