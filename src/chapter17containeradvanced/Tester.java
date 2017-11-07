package chapter17containeradvanced;

import java.util.List;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/6
 * Mail:zhengjun1987@outlook.com
 */
public class Tester<C> {
    public static int fieldWidth = 8;
    public static TestParam[] defaultTestParams = TestParam.array(10, 5000, 100, 5000, 1000, 5000, 10000, 500);
    protected C container;

    protected C initialize(int size) {
        return container;
    }

    private String headline = "";
    private List<Test<C>> tests;

    private static String stringField() {
        return "%" + fieldWidth + "s";
    }

    private static String numberField() {
        return "%" + fieldWidth + "d";
    }

    private static int sizeWidth = 5;
    private static String sizeField = "%" + sizeWidth + "s";
    private TestParam[] testParams = defaultTestParams;

    public Tester(C container, List<Test<C>> tests) {
        this.container = container;
        this.tests = tests;
    }

    public Tester(C container, List<Test<C>> tests, TestParam[] testParams) {
        this.container = container;
        this.tests = tests;
        this.testParams = testParams;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public void timedTest(){
        displayHeader();
        for (TestParam testParam : testParams) {
            System.out.format(sizeField,testParam.size);
            for (Test<C> test : tests) {
                C ctnr = initialize(testParam.size);
                long start = System.nanoTime();
                int reps = test.test(ctnr, testParam);
                long duration = System.nanoTime() - start;
                long timePerRep = duration / reps;
                System.out.format(numberField(),timePerRep);
            }
            System.out.println();
        }
    }

    private void displayHeader() {
        int width = fieldWidth * tests.size() + sizeWidth;
        int dashLength = width - headline.length() - 1;
        StringBuffer head = new StringBuffer(width);
        for (int i = 0; i < dashLength / 2; i++) {
            head.append("-");
        }
        head.append(" ");
        head.append(headline==null||headline.equals("")?container.getClass().getSimpleName():headline);
        head.append(" ");
        for (int i = 0; i < dashLength / 2; i++) {
            head.append("-");
        }
        System.out.println(head);
        System.out.format(sizeField,"size");
        for (Test<C> test : tests) {
            System.out.format(stringField(),test.name);
        }
        System.out.println();
    }

    public static <C> void run(C cntnr,List<Test<C>> tests){
        new Tester<>(cntnr,tests).timedTest();
    }
}
