package chapter15generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import chapter14runtimetypeinfo.*;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/12
 * Mail:zhengjun1987@outlook.com
 */
public class CheckedList {
    static void oldStyleMethod(List probablyDogs){
        probablyDogs.add(new Cat());
    }

    public static void main(String[] args) {
        ArrayList<Dog> dogs1 = new ArrayList<Dog>();
        oldStyleMethod(dogs1);

        List<Dog> dogs = Collections.checkedList(new ArrayList<Dog>(), Dog.class);//返回的是new CheckedList<>(list, type));
        // public void add(int index, E element) {
        //     list.add(index, typeCheck(element));
        // }
        try {
            oldStyleMethod(dogs);
//            E typeCheck(Object o) {
//                if (o != null && !type.isInstance(o))
//                    throw new ClassCastException(badElementMsg(o));
//                return (E) o;
//            }
        } catch (Exception e) {
            e.printStackTrace();
            //Exception in thread "main" java.lang.ClassCastException: Attempt to insert class chapter14runtimetypeinfo.Cat element into collection with element type class chapter14runtimetypeinfo.Dog
        }
        List<Pet> pets = Collections.checkedList(new ArrayList<Pet>(), Pet.class);
        pets.add(new Dog());
        pets.add(new Cat());

        System.out.println("BINGO!");
    }
}
