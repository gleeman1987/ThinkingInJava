package chapter07reusedclass;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/5/24.
 */
public class FinalClass {
    public static void main(String[] args) {
        Dinasour dinasour = new Dinasour();
        dinasour.setAge(12);
        System.out.println(dinasour.getAge());
    }
}

final class Dinasour{
    int age = 50;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}


