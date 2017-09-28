package chapter13charsequence;

import java.util.Formatter;

public class Conversion {
    public static void main(String[] args) {
        Formatter formatter = new Formatter(System.out);
        int u = 'a';
        formate(formatter, u);
    }

    private static void formate(Formatter formatter, Object u) {
        System.out.println("u ="+u);//u = 'a'
        formatter.format("s:%s\n",u);//s:a
        formatter.format("d:%d\n",u);
        formatter.format("c:%c\n",u);//c:a
        formatter.format("b:%b\n",u);//b:true
        formatter.format("f:%f\n",u);
        formatter.format("e:%e\n",u);
        formatter.format("x:%x\n",u);
        System.out.println("-------------------------------------");
    }
}
