package chapter19enum;

/**
 * Authur:zhengjun
 * E-mail:zhengjun1987@outlook.com
 * Date:2017/12/3
 * Project:ThinkingInJava
 */
public interface Competitor<T extends Competitor<T>> {
    Outcome compete(T competitor);
}
