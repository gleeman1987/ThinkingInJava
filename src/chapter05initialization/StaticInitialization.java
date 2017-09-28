package chapter05initialization;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/1/9.
 */
public class StaticInitialization {
    static Table table = new Table();
    public static void main(String[] args) {
        System.out.println("Creating new Cupboard instance in Main Method");
        new Cupboard();
        System.out.println("Creating new Cupboard instance in Main Method");
        new Cupboard();
        table.tablefuction(1);
        cupboard.cupboardfunction(1);
    }
    static Cupboard cupboard = new Cupboard();
}

class Bowl {
    public Bowl(int mark) {
        System.out.println("Bowl构造方法:mark = [" + mark + "]");
    }

    void bowlfunction(int mark){
        System.out.println("Bowl.bowlfunction   mark = [" + mark + "]");
    }
}

class Table{
    static Bowl bowl1 = new Bowl(1);

    public Table() {
        System.out.println("Table.Table构造方法");
        bowl2.bowlfunction(1);
    }

    void tablefuction(int mark){
        System.out.println("Table.tablefuction   mark = [" + mark + "]");
    }

    static Bowl bowl2 = new Bowl(2);
}

class Cupboard{
    Bowl bowl3 = new Bowl(3);
    static Bowl bowl5 = new Bowl(5);

    public Cupboard() {
        System.out.println("Cupboard.Cupboard构造方法");
        bowl4.bowlfunction(2);
    }

    void cupboardfunction(int mark){
        System.out.println("Cupboard.cupboardfunction   mark = [" + mark + "]");
    }

    static Bowl bowl4 = new Bowl(4);
}
