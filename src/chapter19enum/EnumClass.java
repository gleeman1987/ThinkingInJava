package chapter19enum;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/30
 * Mail:zhengjun1987@outlook.com
 */
enum Shrubbery {GROUND,CRAWLING,HANGING}

public class EnumClass {
    public static void main(String[] args) {
        for (Shrubbery shrubbery : Shrubbery.values()) {
            System.out.println("shrubbery.ordinal() = " + shrubbery.ordinal());
            System.out.println("shrubbery.equals(Shrubbery.CRAWLING) = " + shrubbery.equals(Shrubbery.CRAWLING));
            System.out.println("shrubbery.compareTo(Shrubbery.CRAWLING) = " + shrubbery.compareTo(Shrubbery.CRAWLING));
            System.out.println("shrubbery == Shrubbery.CRAWLING   =   " + (shrubbery == Shrubbery.CRAWLING));
            System.out.println("shrubbery.getDeclaringClass() = " + shrubbery.getDeclaringClass());
            System.out.println("shrubbery.name() = " + shrubbery.name());
            System.out.println("----------------------------------");
        }

        for (String s : "GROUND CRAWLING HANGING".split(" ")) {
            Shrubbery shrubbery = Enum.valueOf(Shrubbery.class, s);
            System.out.println("shrubbery = " + shrubbery);
        }
//        shrubbery.ordinal() = 0
//        shrubbery.equals(Shrubbery.CRAWLING) = false
//        shrubbery.compareTo(Shrubbery.CRAWLING) = -1
//        shrubbery == Shrubbery.CRAWLING   =   false
//        shrubbery.getDeclaringClass() = class chapter19enum.Shrubbery
//        shrubbery.name() = GROUND
//                ----------------------------------
//        shrubbery.ordinal() = 1
//        shrubbery.equals(Shrubbery.CRAWLING) = true
//        shrubbery.compareTo(Shrubbery.CRAWLING) = 0
//        shrubbery == Shrubbery.CRAWLING   =   true
//        shrubbery.getDeclaringClass() = class chapter19enum.Shrubbery
//        shrubbery.name() = CRAWLING
//                ----------------------------------
//        shrubbery.ordinal() = 2
//        shrubbery.equals(Shrubbery.CRAWLING) = false
//        shrubbery.compareTo(Shrubbery.CRAWLING) = 1
//        shrubbery == Shrubbery.CRAWLING   =   false
//        shrubbery.getDeclaringClass() = class chapter19enum.Shrubbery
//        shrubbery.name() = HANGING
//                ----------------------------------
//        shrubbery = GROUND
//        shrubbery = CRAWLING
//        shrubbery = HANGING
    }
}
