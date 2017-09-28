package chapter11objectcontainer;

public class HceByteTest {
    private static int messageCounter = 0;

    public static void main(String[] args) {
        byte[] bytes = "Hello Desktop!".getBytes();
        for (byte aByte : bytes) {
            System.out.print(aByte);
        }
        System.out.println();
        byte[] bytes1 = ("Message from android: " + messageCounter++).getBytes();
        for (byte b : bytes1) {
            System.out.print(b);
        }
        System.out.println();
//        System.out.println(String.valueOf());
    }
}
