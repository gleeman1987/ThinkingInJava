package chapter05initialization;

import java.util.Date;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/1/8.
 */
public class TerminationCondition {
    public static void main(String[] args) {
        Book novel = new Book(true);
        novel.checkedIn();
        for (int i = 0; i < 100; i++) {
            new Book(true);
        }
        System.out.println(new Date());
        System.gc();
    }
}

class Book {
    boolean checkedOut = false;

    void checkedIn(){
        checkedOut = false;
    }

    public Book(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    @Override
    protected void finalize()  {
        if (checkedOut) {
            System.out.println("Error:checked out!");
            try {
                super.finalize();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
                System.out.println(throwable.getMessage());
            }
        }
    }
}
