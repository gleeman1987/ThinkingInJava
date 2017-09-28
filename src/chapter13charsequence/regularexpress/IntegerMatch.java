package chapter13charsequence.regularexpress;

public class IntegerMatch {
    public static void main(String[] args) {
        System.out.println("-1234".matches("-?\\d+"));
        System.out.println("5678".matches("-?\\d+"));
        System.out.println("+911".matches("-?\\d+"));//false
        System.out.println("+911".matches("(-|\\+)?\\d+"));
        System.out.println("+911".matches("(-|\\+)?\\d+"));
        System.out.println("-1234".matches("(-|\\+)?\\d+"));
        System.out.println("5678".matches("(-|\\+)?\\d+"));
        //除了标注为false的一项其他均为true
    }
}
