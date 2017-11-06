package chapter17containeradvanced;

import chapter16arrays.CountingGenerator;
import chapter16arrays.Generated;

import java.util.*;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/6
 * Mail:zhengjun1987@outlook.com
 */
public class ListPerformance {
    static Random random = new Random();
    static int reps = 100;
    static List<Test<List<Integer>>> tests = new ArrayList<>();
    static List<Test<LinkedList<Integer>>> qTests = new ArrayList<>();
    static {
        tests.add(new Test<List<Integer>>("add") {
            @Override
            int test(List<Integer> container, TestParam testParam) {
                for (int i = 0; i < testParam.loops; i++) {
                    container.clear();
                    for (int i1 = 0; i1 < testParam.size; i1++) {
                        container.add(i1);
                    }
                }
                return testParam.size*testParam.loops;
            }
        });

        tests.add(new Test<List<Integer>>("get") {
            @Override
            int test(List<Integer> container, TestParam testParam) {
                int loops = testParam.loops * reps;
                int listSize = container.size();
                for (int i = 0; i < loops; i++) {
                    container.get(random.nextInt(listSize));
                }
                return loops;
            }
        });
        tests.add(new Test<List<Integer>>("set") {
            @Override
            int test(List<Integer> container, TestParam testParam) {
                int loops = testParam.loops * reps;
                int size = container.size();
                for (int i = 0; i < loops; i++) {
                    container.set(random.nextInt(size),47);
                }
                return loops;
            }
        });
        tests.add(new Test<List<Integer>>("itradd") {
            @Override
            int test(List<Integer> container, TestParam testParam) {
                final int LOOPS = 100000;
                int half = container.size() / 2;
                ListIterator<Integer> integerListIterator = container.listIterator(half);
                for (int i = 0; i < LOOPS; i++) {
                    integerListIterator.add(47);
                }
                return LOOPS;
            }
        });
        tests.add(new Test<List<Integer>>("insert") {
            @Override
            int test(List<Integer> container, TestParam testParam) {
                for (int i = 0; i < testParam.loops; i++) {
                    container.add(5,47);
                }
                return testParam.loops;
            }
        });
        tests.add(new Test<List<Integer>>("remove") {
            @Override
            int test(List<Integer> container, TestParam testParam) {
                for (int i = 0; i < testParam.loops; i++) {
                    container.clear();
                    container.addAll(new CountingIntegerList(testParam.size));
                    while (container.size() > 5) {
                        container.remove(5);
                    }
                }
                return testParam.loops*testParam.size;
            }
        });

        qTests.add(new Test<LinkedList<Integer>>("addFirst") {
            @Override
            int test(LinkedList<Integer> container, TestParam testParam) {
                for (int i = 0; i < testParam.loops; i++) {
                    container.clear();
                    for (int i1 = 0; i1 < testParam.size; i1++) {
                        container.addFirst(47);
                    }
                }
                return testParam.size*testParam.loops;
            }
        });
        qTests.add(new Test<LinkedList<Integer>>("addLasr") {
            @Override
            int test(LinkedList<Integer> container, TestParam testParam) {
                for (int i = 0; i < testParam.loops; i++) {
                    container.clear();
                    for (int i1 = 0; i1 < testParam.size; i1++) {
                        container.addLast(47);
                    }
                }
                return testParam.size*testParam.loops;
            }
        });
        qTests.add(new Test<LinkedList<Integer>>("rmFirst") {
            @Override
            int test(LinkedList<Integer> container, TestParam testParam) {
                for (int i = 0; i < testParam.loops; i++) {
                    container.clear();
                    container.addAll(new CountingIntegerList(testParam.size));
                    while (container.size() > 0) {
                        container.removeFirst();
                    }
                }
                return testParam.size*testParam.loops;
            }
        });
        qTests.add(new Test<LinkedList<Integer>>("rmLast") {
            @Override
            int test(LinkedList<Integer> container, TestParam testParam) {
                for (int i = 0; i < testParam.loops; i++) {
                    container.clear();
                    container.addAll(new CountingIntegerList(testParam.size));
                    while (container.size() > 0) {
                        container.removeLast();
                    }
                }
                return testParam.size*testParam.loops;
            }
        });
    }

    static class ListTester extends Tester<List<Integer>> {
        public ListTester(List<Integer> container, List<Test<List<Integer>>> tests) {
            super(container, tests);
        }

        @Override
        protected List<Integer> initialize(int size) {
            container.clear();
            container.addAll(new CountingIntegerList(size));
            return container;
        }

        public static void run(List<Integer> integers,List<Test<List<Integer>>> tests){
            new ListTester(integers,tests).timedTest();
        }

        public static void main(String[] args) {
            Tester<List<Integer>> arrayTest = new Tester<List<Integer>>(null, tests.subList(1, 3)) {
                @Override
                protected List<Integer> initialize(int size) {
                    return Arrays.asList(Generated.array(Integer.class, new CountingGenerator.Integer(), size));
                }
            };
            arrayTest.setHeadline("Array as List");
            arrayTest.timedTest();

            ListTester.run(new ArrayList<>(),tests);
            ListTester.run(new LinkedList<>(),tests);
            ListTester.run(new Vector<>(),tests);
        }
    }
}
