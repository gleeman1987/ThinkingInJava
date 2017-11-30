package chapter19enum;

import chapter15generics.Generator;

import java.util.Random;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/30
 * Mail:zhengjun1987@outlook.com
 */
enum CartoonCharacter implements Generator<CartoonCharacter> {
    SLAPPY,SPANKY,PANCHY,SILLY,BOUNCY,NUTTY,BOB;
    private Random random = new Random(47);

    @Override
    public CartoonCharacter next() {
        return values()[random.nextInt(values().length)];
    }
}
public class EnumImplementation {
    public static <T> void printNext(Generator<T> generator){
        System.out.print(generator.next()+",");
    }

    public static void main(String[] args) {
        CartoonCharacter bob = CartoonCharacter.BOB;
        for (int i = 0; i < 10; i++) {
            printNext(bob);
        }
//        BOB,PANCHY,BOB,SPANKY,NUTTY,PANCHY,SLAPPY,NUTTY,NUTTY,SLAPPY
    }
}
