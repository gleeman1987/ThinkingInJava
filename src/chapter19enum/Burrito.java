package chapter19enum;

import static chapter19enum.Spiciness.*;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/30
 * Mail:zhengjun1987@outlook.com
 */
public class Burrito {
    Spiciness degree;

    public Burrito(Spiciness degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Burrito{" +
                "degree=" + degree +
                '}';
    }

    public static void main(String[] args) {
        System.out.println(new Burrito(NOT));
        System.out.println(new Burrito(MEDIUM));
        System.out.println(new Burrito(HOT));
//        Burrito{degree=NOT}
//        Burrito{degree=MEDIUM}
//        Burrito{degree=HOT}
    }
}
