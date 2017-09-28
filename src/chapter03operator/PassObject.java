package chapter03operator;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/1/7.
 */
public class PassObject {
    public static void main(String[] args) {
        Letter letter = new Letter();
        letter.aChar = 'X';
        say(letter);
        Letter letter1 = change(letter);
        say(letter1);

    }

    private static Letter change(Letter letter) {
        letter.aChar = 'A';
        say(letter);
        return letter;
    }

    private static void say(Letter letter) {
        System.out.println(letter + "  " + letter.aChar);
    }
}

class Letter{
    char aChar;
}
