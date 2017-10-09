package chapter15generics;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/9
 * Mail:zhengjun1987@outlook.com
 */
public class CovariantArrays {
    public static void main(String[] args) {
        Fruit[] fruits = new Apple[10];
        fruits[0] = new Apple();
        fruits[1] = new Jonathan();

        try {
            fruits[2] = new Fruit();//java.lang.ArrayStoreException: chapter15generics.Fruit
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            fruits[3] = new Orange();//java.lang.ArrayStoreException: chapter15generics.Orange
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Fruit {}
class Apple extends Fruit{}
class Jonathan extends Apple{}
class Orange extends Fruit{}