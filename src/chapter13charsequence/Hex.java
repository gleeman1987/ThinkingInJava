package chapter13charsequence;

public class Hex {
    public static String format(byte[] bytes){
        StringBuilder result = new StringBuilder();
        int n = 0;
        for (byte b : bytes) {
            if (n % 16 == 0) {
                result.append(String.format("%05X:",n));
            }
            result.append(String.format("%02X ",b));
            n++;
            if (n %16 == 0) {
                result.append("\n");
            }
        }
        result.append("\n");
        return result.toString();
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println(format("Hex.class".getBytes()));
            System.out.println(format("两个黄鹂鸣翠柳一行白鹭上青天".getBytes()));
        }
    }
}
