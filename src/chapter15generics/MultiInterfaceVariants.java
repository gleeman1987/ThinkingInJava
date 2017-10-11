package chapter15generics;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/11
 * Mail:zhengjun1987@outlook.com
 */
interface Payable{
    void pay();
}

class Employee1 implements Payable{

    @Override
    public void pay() {

    }
}

class Hourly extends Employee1 implements Payable{

    @Override
    public void pay() {

    }
}

public class MultiInterfaceVariants {

}
