package chapter10;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/7/8.
 */
public class ReferenceType {

    private static Person person;

    public static void main(String[] args) {
        person = new Person();
        person.setName("知名图书管理员");
        proceessPerson(person);
        System.out.println(person.getName());
        System.out.println("2017年07月13日".substring(0,8));
    }

    static void proceessPerson(Person person){
        person.setName("通吃岛岛主");
    }
}

class Person {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
