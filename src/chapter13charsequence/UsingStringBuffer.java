package chapter13charsequence;

import java.util.Random;

public class UsingStringBuffer {
    public static Random random = new Random(47);

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[");
        for (int i = 0; i < 25; i++) {
            stringBuffer.append(random.nextInt(100));
            stringBuffer.append(",");
        }
        stringBuffer.delete(stringBuffer.length()-1,stringBuffer.length());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        System.out.println(new UsingStringBuffer().toString());
    }
}
