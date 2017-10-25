package chapter16arrays;

import chapter15generics.Generator;

import java.util.Random;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/24
 * Mail:zhengjun1987@outlook.com
 */
public class CountingGenerator {
    public static class Boolean implements Generator<java.lang.Boolean>{
        private boolean value = false;
        @Override
        public java.lang.Boolean next() {
            value = !value;
            return value;
        }
    }

    public static class Byte implements Generator<java.lang.Byte>{
        private byte value = 0;
        @Override
        public java.lang.Byte next() {
            return value++;
        }
    }

    static char[] chars = "abcdefghijklmnopqrrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWZYX".toCharArray();
    public static class Character implements Generator<java.lang.Character>{
        private int index;
        @Override
        public java.lang.Character next() {
            return chars[index++];
        }
    }

    public static class String implements Generator<java.lang.String>{
        private int size = 7;
        Character character = new Character();

        public String() {
        }

        public String(int size) {
            this.size = size;
        }

        @Override
        public java.lang.String next() {
            char[] buf = new char[size];
            for (int i = 0; i < size; i++) {
                buf[i] = character.next();
            }
            return new java.lang.String(buf);
        }
    }

    public static class Short implements Generator<java.lang.Short>{
        private short value = 0;
        @Override
        public java.lang.Short next() {
            return value++;
        }
    }

    public static class Integer implements Generator<java.lang.Integer>{
        private int value = 0;
        @Override
        public java.lang.Integer next() {
            return value++;
        }
    }

    public static class Long implements Generator<java.lang.Long>{
        private long value = 0;
        @Override
        public java.lang.Long next() {
            return value++;
        }
    }

    public static class Float implements Generator<java.lang.Float>{
        private float value = 0;
        @Override
        public java.lang.Float next() {
            float result = value;
            value += 1.0;
            return result;
        }
    }

    public static class Double implements Generator<java.lang.Double>{
        private double value = 0.0;
        @Override
        public java.lang.Double next() {
            double result = this.value;
            value += 1.0;
            return result;
        }
    }

}
