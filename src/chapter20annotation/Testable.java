package chapter20annotation;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/6/19.
 */
public class Testable {
    public static void main(String[] args) {
        new Testable().test();
    }

    public void execute(){
        System.out.println("Testable.execute");
    }

    @Test(_id = 3)
    public void test(){
        execute();
    }


}
