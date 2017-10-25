package chapter16arrays;

import chapter15generics.Generator;

import java.util.Random;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/24
 * Mail:zhengjun1987@outlook.com
 */
public class RandomGenerator {
    private static Random random = new Random(47);

    public static class Boolean implements Generator<java.lang.Boolean> {
        @Override
        public java.lang.Boolean next() {
            return random.nextBoolean();
        }
    }

    public static class Byte implements Generator<java.lang.Byte> {
        @Override
        public java.lang.Byte next() {
            return (byte)random.nextInt();
        }
    }

    public static class Character implements Generator<java.lang.Character> {
        @Override
        public java.lang.Character next() {
            return CountingGenerator.chars[random.nextInt(CountingGenerator.chars.length)];
        }
    }

    public static class String implements Generator<java.lang.String> {
        private int size = 8;
        private Character character = new Character();

        public String() {
        }

        public String(int size) {
            this.size = size;
        }

        @Override
        public java.lang.String next() {
            char[] chars = new char[size];
            for (int i = 0; i < chars.length; i++) {
                chars[i] = character.next();
            }
            return new java.lang.String(chars);
        }
    }

    public static class Short implements Generator<java.lang.Short> {
        @Override
        public java.lang.Short next() {
            return (short) random.nextInt();
        }
    }

    public static class Long implements Generator<java.lang.Long> {
        @Override
        public java.lang.Long next() {
            return (long)random.nextInt();
        }
    }

    public static class Integer implements Generator<java.lang.Integer> {
        private int mode = 10000;

        public Integer(int mode) {
            this.mode = mode;
        }

        public Integer() {
        }

        @Override
        public java.lang.Integer next() {
            return random.nextInt(mode);
        }
    }

    public static class Float implements Generator<java.lang.Float> {
        @Override
        public java.lang.Float next() {
            return (float)(Math.round(random.nextFloat()*100)/100);
        }
    }

    public static class Double implements Generator<java.lang.Double> {
        @Override
        public java.lang.Double next() {
            return (double)(Math.round(random.nextDouble()*100));
        }
    }
}
