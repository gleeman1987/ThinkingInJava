package chapter02oop;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/17
 * Mail:zhengjun1987@outlook.com
 */

class Letter {
    char c;

    @Override
    public String toString() {
        return "Letter{" +
                "c=" + c +"\t"+
                super.toString() +
                '}';
    }
}
public class PassObject {
    static void f(Letter letter){
        letter.c = 'f';


    }

    public static void main(String[] args) {
        Letter letter = new Letter();
        letter.c = 'a';
        System.out.println("letter = " + letter);
        f(letter);
        System.out.println("letter = " + letter);
    }
}
