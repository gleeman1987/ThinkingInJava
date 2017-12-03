package chapter20annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Authur:zhengjun
 * E-mail:zhengjun1987@outlook.com
 * Date:2017/12/3
 * Project:ThinkingInJava
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface SimulatingNull {
    int id() default -1;
    String description() default "";
    String value() default "";//可以覆盖value值
}
