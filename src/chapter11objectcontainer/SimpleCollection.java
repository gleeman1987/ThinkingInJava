package chapter11objectcontainer;

import java.util.ArrayList;
import java.util.List;

public class SimpleCollection {
    public static void main(String[] args) {
//        ArrayList<Integer> integers = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();//使用List为integers的类型的意义在于在声明integers时候不写死integer的具体类型,从而允许选择更灵活的实现方式
        //若实现方式有变,仅需在初始化地方修改实现类型,其他方法调用的地方无需考虑修改
        for (int i = 0; i < 10; i++) {
            integers.add(i);
        }
        for (Integer integer : integers) {
            System.out.print(integer + ",");
        }
        //0,1,2,3,4,5,6,7,8,9,
    }
}
