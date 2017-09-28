package chapter05initialization;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/3/16.
 */
public class SimpleEnumTest {
    public static void main(String[] args) {
        Spiciness spiciness = Spiciness.MEDIUM;
        System.out.println(spiciness);
        System.out.println(spiciness.hashCode());
        System.out.println(spiciness.name());
        System.out.println(spiciness.ordinal());
        System.out.println(spiciness.getClass());
        System.out.println(spiciness.equals(Spiciness.NOT));
        System.out.println(spiciness.equals(Spiciness.MEDIUM));
        System.out.println(spiciness.equals(Spiciness.FLAMING));
        System.out.println(spiciness.compareTo(Spiciness.FLAMING));
        System.out.println(spiciness.compareTo(Spiciness.NOT));
        switch (spiciness) {
            case FLAMING:
                System.out.println("flaming");
                break;
            case HOT:
                System.out.println("hot");
                break;
            case MEDIUM:
                System.out.println("medium");
                break;
            case MILD:
                System.out.println("mild");
                break;
            case NOT:
                System.out.println("not");
                break;
        }
    }
}

enum Spiciness {
    NOT,MILD,MEDIUM,HOT,FLAMING
}
