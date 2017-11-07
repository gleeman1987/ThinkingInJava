package chapter17containeradvanced;

import java.util.*;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/7
 * Mail:zhengjun1987@outlook.com
 */
public class SetPerformance {
    static List<Test<Set<Integer>>> tests = new ArrayList<>();
    static {
        tests.add(new Test<Set<Integer>>("add") {
            @Override
            int test(Set<Integer> container, TestParam testParam) {
                for (int i = 0; i < testParam.loops; i++) {
                    container.clear();
                    for (int i1 = 0; i1 < testParam.size*2; i1++) {
                        container.add(i1);
                    }
                }
                return testParam.size*testParam.loops;
            }
        });
        tests.add(new Test<Set<Integer>>("contains") {
            @Override
            int test(Set<Integer> container, TestParam testParam) {
                for (int i = 0; i < testParam.loops; i++) {
                    container.clear();
                    for (int i1 = 0; i1 < testParam.size; i1++) {
                        container.contains(i1);
                    }
                }
                return testParam.size*testParam.loops*2;
            }
        });
        tests.add(new Test<Set<Integer>>("iterate") {
            @Override
            int test(Set<Integer> container, TestParam testParam) {
                for (int i = 0; i < testParam.loops*10; i++) {
                    Iterator<Integer> iterator = container.iterator();
                    while (iterator.hasNext()) {
                        iterator.next();
                    }
                }
                return container.size()*testParam.loops*10;
            }
        });
    }

    public static void main(String[] args) {
        Tester.fieldWidth = 10;
        Tester.run(new TreeSet<>(),tests);
        Tester.run(new HashSet<>(),tests);
        Tester.run(new LinkedHashSet<>(),tests);
    }
}
