package chapter09interface;


import chapter09interface.classprocessor.Processor1;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/6/28.
 */
public class RandomWords implements Readable {
    public static final char[] capitals = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    public static final char[] lowers = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    public static final char[] vowels = "aeiou".toCharArray();
    private static Random random = new Random(47);
    private int count;

    public RandomWords(int count) {
        this.count = count;
    }


    @Override
    public int read(CharBuffer cb) throws IOException {
        System.out.println("count = " + count);
        if (count-- == 0) {
            return -1;
        }
        cb.append(capitals[random.nextInt(capitals.length)]);
        for (int i = 0; i < 4; i++) {
            cb.append(vowels[random.nextInt(vowels.length)]);
            cb.append(lowers[random.nextInt(lowers.length)]);
        }
        cb.append(" ");
        return 10;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new RandomWords(Processor1.March));
        while (scanner.hasNext()){
            System.out.println(scanner.next());
        }
    }
}
