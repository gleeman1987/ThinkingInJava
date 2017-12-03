package chapter20annotation;

/**
 * Authur:zhengjun
 * E-mail:zhengjun1987@outlook.com
 * Date:2017/12/3
 * Project:ThinkingInJava
 */
public class Testable {
    private void execute(){
        System.out.println("Testable.execute  " + "");
    }

    @Test
    void test(){ execute(); }
}
