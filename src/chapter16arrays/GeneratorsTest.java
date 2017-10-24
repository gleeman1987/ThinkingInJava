package chapter16arrays;

import chapter15generics.Generator;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/24
 * Mail:zhengjun1987@outlook.com
 */
public class GeneratorsTest {
    public static final int size = 10;
    public static void test(Class<?> surroundingClass) throws IllegalAccessException, InstantiationException {
        for (Class<?> aClass : surroundingClass.getClasses()) {
            System.out.print(aClass.getSimpleName()+":");
            Generator generator = (Generator) aClass.newInstance();
            for (int i = 0; i < size; i++) {
                System.out.print(generator.next()+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        test(CountingGenerator.class);
//        Double:0.0 1.0 2.0 3.0 4.0 5.0 6.0 7.0 8.0 9.0
//        Float:0.0 1.0 2.0 3.0 4.0 5.0 6.0 7.0 8.0 9.0
//        Long:0 1 2 3 4 5 6 7 8 9
//        Integer:0 1 2 3 4 5 6 7 8 9
//        Short:0 1 2 3 4 5 6 7 8 9
//        String:rbsgqrx URYQeHU PavrXvv NSiPfQN bjAEjQr gelMYUH lhtWTHf ezcHKWq aLBuZNO cAdJWrD
//        Character:z k S y e k Z n x E
//        Byte:0 1 2 3 4 5 6 7 8 9
//        Boolean:true false true false true false true false true false
    }
}
